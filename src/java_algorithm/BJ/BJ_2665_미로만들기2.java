package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2665_미로만들기2 {

	static class Point {
		public int x;
		public int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static int map[][];
	static int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
	static int dist[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		dist = new int[n][n];
		for(int i = 0; i<n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(dist[n-1][n-1]);
	}

	public static void bfs() {
		Queue<Point> que = new LinkedList<>();
		dist[0][0] = 0;
		que.add(new Point(0, 0));
		
		while(!que.isEmpty()) {
			Point point = que.poll();
			for(int i = 0; i<4; i++) {
				int nx = point.x+dx[i];
				int ny = point.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(dist[nx][ny] > dist[point.x][point.y]) {
					if(map[nx][ny] == 1) 
						dist[nx][ny] = dist[point.x][point.y];
					else
						dist[nx][ny] = dist[point.x][point.y]+1;
					que.add(new Point(nx, ny));
				}
			}
		}
		
	}
}
