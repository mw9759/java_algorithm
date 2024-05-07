package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_1644_소수의연속합 {

	static int n, arr[];
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 2; i<=n/2; i++) {
			if(arr[i] == 1) continue;
			list.add(i);
			for(int j = 2; j*i<=n; j++) {
				arr[i*j] = 1;
			}
		}
		for(int i = n/2+1; i<=n; i++) {
			if(i>1 && arr[i] == 0) list.add(i);
		}
		//if(arr[n] == 0) answer++; // 본인이 소수일떄 
		//System.out.println(list);
		int left = 0;
		int right = 0;
		while(left<list.size() && right<list.size()) {
			
			int sum = 0;
			for(int i = left; i<=right; i++) {
				sum += list.get(i);
			}
			
			if(sum == n) {
				answer++;
				right++;
			}
			else if(sum < n){
				right++;
			}
			else if(sum > n) {
				left++;
			}
				
		}
		System.out.println(answer);
	}

}
