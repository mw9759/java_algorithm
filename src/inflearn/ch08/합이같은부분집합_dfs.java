package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이같은부분집합_dfs {

	static int n;
	static int arr[];
	static int sumAll;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumAll += arr[i];
		}
		
		solution(0,0);
		System.out.println(flag ? "YES":"NO");
	}

	private static void solution(int cnt, int sum) {
		if(flag) return;
		if(cnt == n) {
			if(sumAll-sum == sum) flag = true;
			return;
		}
		
		solution(cnt + 1, sum+arr[cnt]);
		solution(cnt + 1, sum);
	}

}
