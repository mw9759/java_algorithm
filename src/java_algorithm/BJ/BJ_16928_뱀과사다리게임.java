package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16928_뱀과사다리게임 {
	static class Spot{
		int count;
		int num;
		
		public Spot(int count, int num) {
			this.count = count;
			this.num = num;
		}
	}
	static int n, m;
	static int arr[], visit[];
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 사다리 개수
		m = Integer.parseInt(st.nextToken()); // 뱀 개수
		arr = new int[101];
		visit = new int[101];
		
		for(int i = 0; i<n+m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[start] = end; 
		}
		
		bfs();
		
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Spot> que = new ArrayDeque<>();
		que.add(new Spot(0,1));
		visit[1] = 1;
		
		while(!que.isEmpty()) {
			Spot spot = que.poll();
			
			int count = spot.count;
			int num = spot.num;
			
			//주사위
			// 1. 이미 방문했던 구간인가
			// 2. 사다리인가
			// 3. 뱀인가 -> 뱀이면 패스
			// 4. 100을 넘는가 -> 넘으면 패스
			for(int i = 1; i<=6; i++) {
				int nextNum = num + i; // 다음 구역
				// 100일 경우
				if(nextNum == 100) {
					answer = count+1;
					return;
				}
				
				// 방문체크, 100 이상 체크
				if(nextNum>100 || visit[nextNum] == 1) continue;
				visit[nextNum] = 1;
//				// 뱀 여부
//				if(arr[nextNum/10][nextNum%10] > 0 && nextNum>arr[nextNum/10][nextNum%10]) {
//					visit[nextNum/10][nextNum%10] = 1;
//					que.add(new Spot(count+1, arr[nextNum/10][nextNum%10])); // 카운트+1, 뱀 도착지
//					continue;
//				};
				
				// 사다리 여부
				if(arr[nextNum] != 0) {
					visit[arr[nextNum]] = 1;
					que.add(new Spot(count+1, arr[nextNum])); // 카운트+1, 사다리 도착지
					continue;
				}
				
				// 그냥 이동
				que.add(new Spot(count+1, nextNum));
			}
		}
	}
}
