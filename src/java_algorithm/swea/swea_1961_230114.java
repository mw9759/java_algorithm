package java_algorithm.swea;

import java.util.*;
import java.io.*;
public class swea_1961_230114 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase < T+1; testcase++) {
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//90도 회전
			int arr_90[][] = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr_90[i][j] = arr[n-1-j][i];
				}
			}
			
			//180도 회전
			int arr_180[][] = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr_180[i][j] = arr_90[n-1-j][i];
				}
			}
			
			//270도 회전
			int arr_270[][] = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr_270[i][j] = arr_180[n-1-j][i];
				}
			}
			
			//출력
			System.out.println("#"+testcase);
			
			for(int i = 0; i < n; i++) {
				String a_90 = "";
				String a_180 = "";
				String a_270 = "";
				for(int j = 0; j < n; j++) {
					a_90 += arr_90[i][j]; 
					a_180 += arr_180[i][j]; 
					a_270 += arr_270[i][j]; 
				}
				System.out.print(a_90 + " ");
				System.out.print(a_180 + " ");
				System.out.println(a_270);
			}
		}
	}

}
