package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pro01 {
	public static void solution(int n, int[] arr) {
		int stack = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i]>stack) {
				System.out.print(arr[i]+" ");
			}
			stack = arr[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solution(n, arr);
	}

}
