package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바둑이승차 {

	static int c;
	static int n;
	static int arr[];
	static int maxW = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		solution(0, 0);
		System.out.println(maxW);
	}
	private static void solution(int cnt, int sum) {
		if(cnt == n) {
			if(sum<=c) maxW = Math.max(maxW, sum);
			return;
		}
		
		solution(cnt+1, sum+arr[cnt]);
		solution(cnt+1, sum);
	}

}
