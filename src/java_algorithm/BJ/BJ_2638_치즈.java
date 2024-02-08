package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2638_치즈 {

	static int n, m, arr[][];
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static Queue<int[]> que;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isMelt = false;
		int answer = 0;
		while(!isMelt) {
			
			que = new ArrayDeque<int[]>();
			
			fillOut();
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(arr[i][j] == 0 || arr[i][j] == 2) continue;
					if(check(i, j) < 2) continue;
					que.add(new int[] {i,j});
				}
			}
			
			melting();
			
			answer++;
			
			if(countCheese() == 0) isMelt = true;
		}
		System.out.println(answer);
		
	}
	private static int countCheese() {
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(arr[i][j] == 1) cnt++;
			}
		}
		return cnt;
	}
	private static void melting() {
		while(!que.isEmpty()) {
			int spot[] = que.poll();
			arr[spot[0]][spot[1]] = 0;
		}
	}
	private static int check(int x, int y) {
		
		int cnt = 0;
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(arr[nx][ny] == 2) cnt++;
		}
		
		return cnt;
	}
	
	private static void fillOut() {
		int visited[][] = new int[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		visited[0][0] = 1;
		que.add(new int[] {0, 0});
		
		while(!que.isEmpty()) {
			int s[] = que.poll();
			int x = s[0];
			int y = s[1];
			arr[x][y] = 2;
			
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위이탈
				if(visited[nx][ny] == 1) continue; // 방문지역
				if(arr[nx][ny] == 1) continue; // 치즈공간
				
				visited[nx][ny] = 1;
				que.add(new int[] {nx, ny});
			}
			
		}
	}

}
