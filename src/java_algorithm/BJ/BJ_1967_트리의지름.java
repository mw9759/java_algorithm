package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1967_트리의지름 {

	static int n;
	static ArrayList<Integer[]> tree[];
	static int visited[];
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n+1];
		
		for(int i = 0; i<=n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		boolean leafNode[]=new boolean[n+1];
		Arrays.fill(leafNode,true);
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			tree[x].add(new Integer[] {y, cost});
			tree[y].add(new Integer[] {x, cost});
			leafNode[x] =false;
		}
		
		for(int i=1;i<leafNode.length;i++) {
			if(leafNode[i]) {
				visited = new int[n+1];
				dfs(i,0);
			}
		}
		
		System.out.println(answer);
	}
	private static void dfs(int now, int cost) {
		visited[now] = 1;
		answer = Math.max(answer, cost);
		
		for(Integer nodes[] : tree[now]) {
			if(visited[nodes[0]] == 0) {
				dfs(nodes[0], cost + nodes[1]);
			}
		}
	}
	

}
