package java_algorithm.swea;

import java.util.Scanner;
import java.io.FileInputStream;

public class swea_1959_230114 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n,m;
			n = sc.nextInt();
			m = sc.nextInt();
			int[] arr_n = new int[n];
			int[] arr_m = new int[m];
			
			for(int i = 0; i<n; i++) {
				arr_n[i] = sc.nextInt();
			}
			
			for(int i = 0; i<m; i++) {
				arr_m[i] = sc.nextInt();
			}
			//길이가 더큰 배열 정의
			int[] long_arr;
			int[] short_arr;
			if(arr_n.length >= arr_m.length) {
				long_arr = arr_n;
				short_arr = arr_m;
			}
			else {
				long_arr = arr_m;
				short_arr = arr_n;
			}
			int count = 1 + long_arr.length-short_arr.length;
			//자리별 곲의 합 구하기
			int answer = 0;
			for(int i = 0; i<count; i++) {
				int sum = 0;
				for(int j = 0; j < short_arr.length; j++) {
					sum += long_arr[j+i]*short_arr[j];
				}
				if(answer < sum) {
					answer = sum;
				}
			}
			System.out.println("#"+test_case+" "+answer); 
			
			
		}
	}

}
