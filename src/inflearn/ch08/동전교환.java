package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전교환 {
	
	static int n, m, minCnt = Integer.MAX_VALUE;
	static Integer[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		
		m = Integer.parseInt(br.readLine());
		
		solution(0, 0);
		System.out.println(minCnt);
	}
	private static void solution(int cnt, int sum) {
		if(cnt >= minCnt) return;
		if(sum > m) return;
		if(sum == m) {
			minCnt = Math.min(minCnt, cnt);
		}

		for(int i = 0; i<n; i++) {
			solution(cnt+1, sum+arr[i]);
		}
	}
}
