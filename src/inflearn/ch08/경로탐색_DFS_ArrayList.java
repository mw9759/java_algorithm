package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로탐색_DFS_ArrayList {

	static int n;
	static int m;
	static int ch[];
	static ArrayList<ArrayList<Integer>> graph;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ch = new int[n+1];
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		
		ch[1] = 1;
		dfs(1);
		System.out.println(answer);
	}

	private static void dfs(int cnt) {
		if(cnt == n) {
			answer++;
			return;
		}
		
		for(int i : graph.get(cnt)) {
			if(ch[i] == 0) {
				ch[i] = 1;
				dfs(i);
				ch[i] = 0;
			}
		}
	}

}
