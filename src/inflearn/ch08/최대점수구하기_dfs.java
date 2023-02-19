package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수구하기_dfs {
	
	static int n, m;
	static int[] score, time;
	static int dp[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		score = new int[n+1];
		time = new int[n+1];
		dp = new int[n+1][m+1];
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			score[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=n; i++) {
			
			for(int j = 1; j<=m; j++) {
				if(time[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]]+score[i]);
				}
				else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		
		System.out.println(dp[n][m]);
	}

}
