package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16235_나무재테크 {
	/***
	 * 봄 : 자신의 나이만큼 양분 먹음-> 나이 1증가. 나이가 어린 나무부터. 양분 나이만큼 못먹으면 죽음
	 * 여름 : 죽은 나무의 나이/2 만큼 양분증가.
	 * 가을 : 나무번식->나이가 5의 배수라면 8방에 나이 1 나무 생성. 땅 벗어나면 안생김.
	 * 겨울 : 각 지역에 양분 추가.
	 * 
	 * 정답 : k년 후 살아있는 나무 개수.
	 */
	static int n, m, k;
	static PriorityQueue<Integer> que[][];
	static int addNutriment[][], nowNutrument[][];
	static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1}, dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 땅 크기
		m = Integer.parseInt(st.nextToken()); // 초기 나무 개수
		k = Integer.parseInt(st.nextToken()); // 년
		
		que = new PriorityQueue[n][n];
		addNutriment = new int[n][n];
		nowNutrument = new int[n][n];
		
		// 땅의 각 지역에 포함될 나무들 초기화 : 나이가 들어감. 0번인덱스는 항상 그 지역의 양분수치
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				que[i][j] = new PriorityQueue<>();
				nowNutrument[i][j] = 5;
			}
		}
		
		// 겨울마다 추가될 양분 입력
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				addNutriment[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사전에 심을 나무 정보 입력
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken()); // 나무 나이.
			
			que[x][y].add(z);
		}
		
		//k년 만큼 반복
		for(int i = 0; i<k; i++) {
			solution();
		}
		
		int answer = 0; // k년 후 나무 수
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				answer+= que[i][j].size();
			}
		}
		System.out.println(answer);
	}
	
	private static void solution() {
		// 봄 과정 : 양분먹고 커짐. 못먹으면 죽음.
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				int dead = 0; // 해당 지역에서 죽은 나무 양분
				if(!que[i][j].isEmpty()) dead += spring(i, j); // 나무가 존재할때만.
				
				//여름 과정 : 죽은나무 양분됨
				if(dead>0) summer(dead, i, j); // 죽은 나무가 있다면.
			}
		}
		
		// 가을과정 : 나무 번식
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(!que[i][j].isEmpty()) fall(i, j); // 나무가 존재할때만.
			}
		}
		
		// 겨울과정 : 양분 추가
		winter();
	}

	private static void winter() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				int val = addNutriment[i][j];
				nowNutrument[i][j] += val;
			}
		}
	}

	private static void fall(int x, int y) {
		List<Integer> list = new ArrayList<>();
		while(!que[x][y].isEmpty()) {
			int now = que[x][y].poll();
			list.add(now); // 다시 큐에 넣어줘야 함으로 저장해둠.
			// 번식 가능
			if(now%5 == 0) { 
				for(int k = 0; k<8; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					// 범위 조건 검증
					if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
					
					que[nx][ny].add(1); 
				}
			}
		}
		
		// 저장해둔 나무들 다시 큐에 넣어줌.
		for(int tree : list) que[x][y].add(tree);
	}

	private static void summer(int dead, int i, int j) {
		nowNutrument[i][j] += dead;
	}

	private static int spring(int x, int y) {
		List<Integer> list = new ArrayList<>();
		int sumDead = 0;
		while(!que[x][y].isEmpty()) {
			// 양분 추가 가능 상황
			if(que[x][y].peek()<=nowNutrument[x][y]) { 
				nowNutrument[x][y] -= que[x][y].peek(); // 땅의 양분 차감.
				list.add(que[x][y].poll()+1); // 증가된 나이 저장.
			}
			
			// 양분 추가 불가능
			else {
				//죽은 나무-> 나이/2 만큼 양분됨.
				sumDead += que[x][y].peek()/2;

				que[x][y].poll(); // 나무 죽음.
			}
		}
		
		// 양분을 먹고 추가된 나이를 담은 나무들 다시 큐에 넣어줌.
		for(int tree : list) que[x][y].add(tree);
		
		return sumDead;
	}

}
