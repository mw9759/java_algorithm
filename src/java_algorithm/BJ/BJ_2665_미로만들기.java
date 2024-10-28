package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_2665_미로만들기 {

	static class Point implements Comparable<Point>{
		public int x;
		public int y;
		public int cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int n;
	static int map[][];
	static int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
	static int visited[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs());
	}

	public static int bfs() {
		PriorityQueue<Point> que = new PriorityQueue<>();
		visited[0][0] = 1;
		que.add(new Point(0, 0, 0));
		
		while(!que.isEmpty()) {
			Point point = que.poll();
			if(point.x == n-1 && point.y == n-1)
				return point.cnt;
			
			for(int i = 0; i<4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(visited[nx][ny] == 1) continue;
				
				visited[nx][ny] = 1;
				
				que.add(new Point(nx, ny, map[nx][ny]==0?point.cnt+1:point.cnt));
			}
		}
		
		return 0;
	}
}
