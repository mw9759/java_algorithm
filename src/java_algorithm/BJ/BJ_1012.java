package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int[][] visited;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken()); // 가로길이
			m = Integer.parseInt(st.nextToken()); // 세로길이
			int k = Integer.parseInt(st.nextToken()); // 갯수
			
			int arr[][] = new int[n][m];
			visited = new int[n][m];
			
			for(int i = 0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
			}
			
			int answer = 0;
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					
					if(arr[i][j] == 1 && visited[i][j] == 0) {
						visited[i][j] = 1;
						bfs(arr, i, j);
						answer++;
					}
				}
			}
			
			System.out.println(answer);
			
		}
		
	}

	private static void bfs(int arr[][], int a, int b) {
		int spot[] = new int[2];
		
		spot[0] = a;
		spot[1] = b;
		
		Queue<int[]> que = new ArrayDeque<int[]>();
		
		que.add(spot);
		
		while(!que.isEmpty()) {
			int xy[] = que.poll();
			int x = xy[0];
			int y = xy[1];
			
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx>=n || ny <0 || ny>=m) {
					continue;
				}
				
				if(arr[nx][ny] == 1 && visited[nx][ny] == 0) {
					que.add(new int[] {nx, ny});
					visited[nx][ny] = 1;
				}
			}
		}
	}

}
