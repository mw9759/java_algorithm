package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_6087_레이저통신 {
	
	static class Spot implements Comparable<Spot>{
		int x;
		int y;
		int dir;
		int cnt;
		
		public Spot(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Spot o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int n, m;
	static int arr[][], dist[][];
	static int start_x = -1, start_y, end_x, end_y;
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}; // 우하좌상 1234
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		dist = new int[m][n];
		
		for(int i = 0; i<m; i++) {
			Arrays.fill(dist[i], 987654321);
		}
		
		boolean flag = false;
		for(int i = 0; i<m; i++) {
			String str = br.readLine();
			for(int j = 0; j<n; j++) {
				char c = str.charAt(j);
				if(c == '*') arr[i][j] = -1;
				else if(c == 'C') {
					arr[i][j] = 5;
					if(!flag) {
						start_x = i;
						start_y = j;
						flag = true;
					}
					else {
						end_x = i;
						end_y = j;
					}
				}
				else if(c == '.') arr[i][j] = 0;
			}
		}
		
		int answer = solution();
//		for(int i = 0; i<m; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		System.out.println(answer);
	}
	private static int solution() {
		PriorityQueue<Spot> que = new PriorityQueue<>();
		que.add(new Spot(start_x, start_y, -1, 0));
		dist[start_x][start_y] = 0;

		while(!que.isEmpty()) {
			Spot now = que.poll();
			int x = now.x;
			int y = now.y;
			
			if(end_x == x && end_y == y) {
				return dist[end_x][end_y];
			}
			if(dist[x][y] < now.cnt) continue;
			
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>=m || ny<0 || ny>=n || arr[nx][ny] == -1) continue;
				if(Math.abs(i-now.dir) == 2) continue;
					
				int next = 1;
				if(now.dir == i || now.dir == -1) next = 0;
				
				if(dist[nx][ny] >= dist[x][y] + next) {
					dist[nx][ny] = dist[x][y] + next;
					que.add(new Spot(nx, ny, i, dist[nx][ny]));
				}
			}
			
		}
		return -1;
	}

}
