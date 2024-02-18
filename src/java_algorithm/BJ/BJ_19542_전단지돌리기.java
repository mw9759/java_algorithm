package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_19542_전단지돌리기 {
	static int n, s, D;
	static int arr[][], visit[];
	static List<Integer> list[];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visit = new int[n+1];
		list = new ArrayList[n+1];
		
		for(int i = 0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			
			list[start].add(finish);
			list[finish].add(start);
		}
		dfs(s);
		System.out.println(answer);
	}
	
	static int dfs(int v) {
		if (visit[v] == 1) return 0;
		visit[v] = 1;
		int d = 0;
		for (int n: list[v]) {
			int result = dfs(n);
			if (result > D) answer += 2;
			d = Math.max(d, result);
		}
		return d + 1;
	}

}
