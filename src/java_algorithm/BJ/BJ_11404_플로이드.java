package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_플로이드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][n+1];
		
		//초기값 설정
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(i==j) continue;
				arr[i][j] = 10000000;
			}
		}
		
		StringTokenizer st = null;
		int start;
		int finish;
		int cost;
		// 입력받기.
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			finish = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			if(cost < arr[start][finish]) {
				arr[start][finish] = cost;
			}
		}
		
		// i에서 j까지의 최단거리 구하기
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(i==j) continue;
					if(arr[i][k]+arr[k][j]<arr[i][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(arr[i][j] == 10000000) arr[i][j] = 0;
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
