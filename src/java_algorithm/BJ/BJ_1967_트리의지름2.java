package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1967_트리의지름2 {
	static class Node1{
		public int node;
		public int cost;
		
		public Node1(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
	
	static int n;
	static ArrayList<Node1> tree[];
	static int visit[];
	static int answer = 0;
	static int maxIdx = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n+1];
		
		for(int i = 0; i<=n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			tree[start].add(new Node1(end, cost));
			tree[end].add(new Node1(start, cost));
		}
		
		
		visit = new int[n+1];
		visit[1] = 1;
		dfs(1, 0);
		
		visit = new int[n+1];
		visit[maxIdx] = 1;
		dfs(maxIdx, 0);
//		visit = new int[n+1];
//		dfs(maxIdx, 0);
		System.out.println(answer);
	}
	
	private static void dfs(int to, int sum) {
		
		if(answer < sum) {
			answer = sum;
			maxIdx = to;
		}
		
		for(Node1 n : tree[to]) {
			if(visit[n.node] == 0) {
				visit[n.node] = 1;
				dfs(n.node, n.cost+sum);
			}
		}
		
	}
	

}
