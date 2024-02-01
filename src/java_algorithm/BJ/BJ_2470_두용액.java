package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470_두용액 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int lo = 0;
		int hi = n-1;
		
		int answer1 = arr[0];
		int answer2 = arr[n-1];
		
		int minAbs = Integer.MAX_VALUE;
		while(lo < hi) {
			int sum = arr[lo] + arr[hi];
			
			if(Math.abs(sum) <= Math.abs(minAbs)) {
				answer1 = arr[lo];
				answer2 = arr[hi];
				minAbs = sum;
			}
			
			if(sum == 0) {
				break;
			}
			else if(sum > 0) {
				hi--;
			}
			else {
				lo++;
			}
		}
		
		System.out.println(answer1+" "+answer2);
	}

}
