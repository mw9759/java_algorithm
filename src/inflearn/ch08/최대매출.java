package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대매출 {
	
	static int n, k;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int sum = 0;
		for(int i = 0; i<n; i++) {
			if(i<k) {
				sum += arr[i];
				max = sum;
				continue;
			}
			sum += arr[i];
			sum -= arr[i-k];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
