package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1937_욕심쟁이판다 {

	static int n;
	static int arr[][], dp[][], dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		
		StringTokenizer st;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				answer = Math.max(answer, dfs(i, j));
			}
		}
		System.out.println(answer);
	}
	private static int dfs(int x, int y) {
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
			if(arr[nx][ny] <= arr[x][y]) continue;
			
			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
		}
		
		return dp[x][y];
	}
	
}
