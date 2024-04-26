package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1806_부분합 {

	static int n, s;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		int answer = solution();
		if(answer == Integer.MAX_VALUE) answer = 0;
		
		System.out.println(answer);
	}
	private static int solution() {
		int start = 0;
		int finish = 0;
		int answer = Integer.MAX_VALUE;
		int sum = arr[0];
		while(start<n || finish<n) {
			
			if(sum < s) {
				finish++;
				if(finish>=n) break;
				sum += arr[finish];
			}
			
			else if(sum >= s) {
				answer = Math.min(answer, finish-start+1);
				sum -= arr[start];
				start++;
			}
		}
		
		return answer;
	}
}
