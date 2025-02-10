package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14940_쉬운최단거리 {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int n,m;
	static int map[][], visited[][], answer[][];
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static StringBuilder sb;
	static int spot_x, spot_y;
	public static void main(String[] args) throws Exception{
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		answer = new int[n][m];
		
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num == 2) {
					spot_x = i;
					spot_y = j;
				}
			}
		}
		
		// 로직
		solution(spot_x, spot_y);
		
		// 출력
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(visited[i][j] == 0 && map[i][j] ==1) {
					sb.append(-1);
				}
				else
					sb.append(answer[i][j]);
				if(j == m-1) {
					if(i < n-1)
						sb.append("\n");
				}
				else sb.append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static void append(int x, int y, int cost) {
		sb.append(cost);
		if(y == m-1) {
			if(x < n-1) 
				sb.append("\n");
		}
		else sb.append(" ");
	}
	
	
	private static void solution(int x, int y) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		visited = new int[n][m];
		visited[x][y] = 1;
		que.add(new Node(x, y, 0));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			answer[node.x][node.y]= node.cnt; 
			// 이동조건 체크
			for(int i = 0; i<4; i++) {
				
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				// map 범위 체크
				if(nx < 0 || ny < 0 || nx>=n || ny>=m) continue;
				// 방문여부 체크
				if(visited[nx][ny] == 1) continue;
				// 길 체크
				if(map[nx][ny] == 0) continue;
				
				// 이동 진행
				visited[nx][ny] = 1;
				que.add(new Node(nx, ny, node.cnt + 1));
				
			}
		}
//		answer[x][y] = 0;
	}

}
