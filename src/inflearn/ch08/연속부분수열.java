package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속부분수열 {

	static int n, m;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution());
	}
	private static int solution() {
		int lt = 0;
		int sum = 0;
		int answer = 0;
		for(int i = 0; i<n; i++) {
			sum += arr[i];
			if(sum==m) answer++;
			while(sum>m) {
				sum -= arr[lt++];
				if(sum == m) answer++;
			}
		}
		return answer;
	}

}
