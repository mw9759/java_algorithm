package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro09 {
	private static int solution(int n, int[][] arr) {
		int answer = 0;
		//대각선확인
		int sum_cross1 = 0;
		int sum_cross2 = 0;
		for(int i = 0; i<n; i++) {
			int sum_x = 0;
			int sum_y = 0;
			sum_cross1 += arr[i][i];
			sum_cross2 += arr[i][n-i-1];
			for(int j = 0; j<n; j++) {
				//x축 확인,y축확인
				sum_x+=arr[i][j];
				sum_y+=arr[j][i];
			}
			answer = Math.max(answer, sum_x);
			answer = Math.max(answer, sum_y);
		}
		answer = Math.max(answer, sum_cross1);
		answer = Math.max(answer, sum_cross2);
		return answer;
		
	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		for(int i = 0; i< n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution(n, arr));
	}

}
