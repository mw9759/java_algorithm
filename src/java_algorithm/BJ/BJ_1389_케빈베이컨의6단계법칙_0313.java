package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1389_케빈베이컨의6단계법칙_0313 {
	static int arr[][];
	static int n, m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 사람의 수
		m = Integer.parseInt(st.nextToken()); // 관계의 수
		arr = new int[n+1][n+1]; // 사람의 수만큼 배열 생성 및 초기화
		
		for(int i = 1; i<=m; i++) { // 관계의 수만큼 반복
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; // a의 친구는 b이기에 1
			arr[b][a] = 1; // b의 친구는 a이기에 1
		}
		int min = Integer.MAX_VALUE; // 최솟값을 구해야 하기에 최댓값으로 초기화 
		int answer = 0; // 정답: 최소 베이컨을 갖는 사람 번호
		for(int i = 1; i<=n; i++) { // i번째 사람의 베이컨 수 구하기
			int count =0; // 베이컨 카운팅
			for(int j = 1; j<=n; j++) { // i의 친구 j
				if(arr[i][j] == 1) { // 진짜 친구면
					count++;			// 카운팅 +1
					continue;			// 다음 친구 검증
				}
				count += solution(i,j);	// 친구가 아니면 친구의 친구인지 검증: bfs
			}
			if(min>count) { // 친구조사가 다 끝나면=> 카운팅이 최소인지 확인
				min = count;	// 최소라면 min초기화
				answer = i;		// 정답: 사람번호도 초기화
			}
		}
		System.out.println(answer); //출력
	}
	
	private static int solution(int a, int b) { // a의 친구중에 사람b가 몇번의 다리건너 있을까
		Queue<int[]> que = new LinkedList<int[]>(); // 사람번호와 다리개수 담을 큐
		que.add(new int[] {a,1}); //a와 카운팅 1 넣기
		int visit[][] = new int[n+1][n+1]; // 방문체크
		visit[a][b] = 1;	// 방문했다
		
		while(!que.isEmpty()) { // 큐가 빌때까지
			int x = que.peek()[0]; // 검증해야할 사람 번호 빼기
			int cnt = que.poll()[1]; // 여태 건넌 다리 수: 건너건너 아는사람
			
			if(arr[x][b] == 1) { // 만약 건너건너 b라는 사람이 발견되었다.
				return cnt;			// 건넌 다리개수 리턴.
			}
			for(int i = 1; i<=n; i++) { // 사람의 수만큼 반복
				if(arr[x][i] == 1 && visit[x][i] == 0) { // b는 아니지만 또 다리를 건너야 하기에 x의 친구 i를 조사
					visit[x][i] = 1;		// 방문체크
					que.add(new int[] {i,cnt+1});	// 큐에 조사할 i와 건넌 다리개수+1 해서 큐에 담기.
				}
			}
		}
		
		return 0; // 리턴타입 오류방지용: while문 무조건 탈출.
	}

}
