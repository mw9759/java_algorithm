package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15652_N과M4 {

	static int n, m;
	static int arr[];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		arr = new int[m];
		solution(0, 0);
		System.out.println(sb.toString());
	}
	
	public static void solution(int cnt, int start) {
		if(cnt == m) {
			for(int i = 0; i<m; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = start; i<n; i++) {
			arr[cnt] = i+1;
			solution(cnt+1, i);
		}
	}
}
