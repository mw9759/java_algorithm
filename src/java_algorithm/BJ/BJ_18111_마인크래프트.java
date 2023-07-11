package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18111_마인크래프트 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n][m];
		
		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		int time = 0;
		int height = 0;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				minValue = Math.min(minValue, arr[i][j]);
				maxValue = Math.max(maxValue, arr[i][j]);
			}
		}
		
		for(int i = minValue; i<=maxValue; i++) {
			for(int j = 0; j<n; j++) {
				for(int k = 0; k<m; k++) {
					if()
					if(arr[j][k] < i) {
						time += i-arr[j][k];
					}
				}
			}
		}
	}

}
