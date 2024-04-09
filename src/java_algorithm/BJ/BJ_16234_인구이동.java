package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구이동 {

	static class Country{
		int x;
		int y;
		
		public Country(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, l, r;
	static int arr[][], visited[][];
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
	static Queue<Country> team = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while(true) {
			boolean isMove = false;
			visited = new int[n][n];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(visited[i][j] == 0) {
						int sum = bfs(i, j);
						if(team.size() > 1) {
							move(sum); 
							isMove = true;
						}
					}
				}
			}
			if(!isMove) break;
			cnt++;
		}
		System.out.println(cnt);
	}

	private static void move(int sum) {
		int avg = sum / team.size();
		while(!team.isEmpty()) {
			Country c = team.poll();
			arr[c.x][c.y] = avg;
		}
	}

	private static int bfs(int x, int y) {
		team = new ArrayDeque<>();
		visited[x][y] = 1;
		int sum = arr[x][y];
		Queue<Country> que = new ArrayDeque<Country>();
		que.add(new Country(x, y));
		team.add(new Country(x, y));
		
		while(!que.isEmpty()) {
			Country now = que.poll();
			for(int i = 0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
				if(visited[nx][ny] == 1) continue;


				int sub = Math.abs(arr[now.x][now.y] - arr[nx][ny]);
				if(l <= sub && sub<=r) {
					sum += arr[nx][ny];
					visited[nx][ny] = 1;
					que.add(new Country(nx, ny));
					team.add(new Country(nx, ny));
				}
			}
		}
		// 인구이동이 있는? 있다면-> 분배할 인구 : 없다면 -> 1
		return sum;
	}

}
