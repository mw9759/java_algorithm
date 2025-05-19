package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_불 {

	static class Node{
		int x;
		int y;
		int time;
		
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int n, m;
	static char[][] map;
	static int[][] spot;
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
	static int fireTime[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		spot = new int[2][2];
		fireTime = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 'J') {
					spot[0][0] = i;
					spot[0][1] = j;
				}
				else if(map[i][j] == 'F') {
					spot[1][0] = i;
					spot[1][1] = j;
				}
			}
		}
		
		int answer = solution();
		if(answer != -1) {
			System.out.println(answer);
		}
		else System.out.println("IMPOSSIBLE");
	}

	private static int solution() {
		// 불이동 -> 각 지역 번짐 시간 적용.
		Queue<Node> fireQueue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
	        Arrays.fill(fireTime[i], Integer.MAX_VALUE);
	    }
		
		//  불의 초기 위치 큐에 모두 넣기
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (map[i][j] == 'F') {
	                fireQueue.add(new Node(i, j, 0));
	                fireTime[i][j] = 0;
	            }
	        }
	    }
	    // 🔥 불의 BFS - 미리 확산 시간 기록
	    while (!fireQueue.isEmpty()) {
	        Node now = fireQueue.poll();
	        for (int i = 0; i < 4; i++) {
	            int nx = now.x + dx[i];
	            int ny = now.y + dy[i];

	            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
	            if (map[nx][ny] == '#' || fireTime[nx][ny] != Integer.MAX_VALUE) continue;

	            fireTime[nx][ny] = now.time + 1;
	            fireQueue.add(new Node(nx, ny, now.time + 1));
	        }
	    }
	    
	    
		// 지훈이 이동
		Queue<Node> que = new LinkedList<Node>();
		que.add(new Node(spot[0][0],spot[0][1],0));
		
		int visited[][] = new int[n][m];
		visited[spot[0][0]][spot[0][1]] = 1;
		map[spot[0][0]][spot[0][1]] = '.'; //지훈초기위치 화재가능구역으로 전환.
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			// 기저조건
			 if (now.x == 0 || now.x == n - 1 || now.y == 0 || now.y == m - 1) {
		            return now.time + 1;
		        }
			
			for(int i = 0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				
				// 범위체크
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				
				// 방문가능 지역 및 기 방문지역여부
				if(map[nx][ny] != '.' || visited[nx][ny] == 1) continue;
				
				// 🔥 불보다 먼저 도착해야 함
	            if (now.time + 1 >= fireTime[nx][ny]) continue;
				
				visited[nx][ny] = 1;
				que.add(new Node(nx, ny, now.time+1));
				
			}
		}
		return -1;
	}

}

