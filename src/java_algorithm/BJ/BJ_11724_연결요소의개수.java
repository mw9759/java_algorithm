package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11724_연결요소의개수 {

	static int n, m;
	static int arr[][], visit[];
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		visit = new int[n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		
		int answer = 0;
		
		for(int i = 1; i<n+1; i++) {
			if(visit[i] == 0) {
				dfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);
	}

	private static void dfs(int value) {
		if(visit[value] == 1) {
			return;
		}
		
		visit[value] = 1;
		
		for(int i = 1; i<n+1; i++) {
			if(arr[value][i] == 1) {
				dfs(i);
			}
		}
	}

}
