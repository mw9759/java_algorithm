package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_21924_도시건설 {

	static class Load implements Comparable<Load>{
		int a;
		int b;
		int cost;
		
		public Load(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Load o) {
			return this.cost - o.cost;
		}
	}
	
	static int n, m;
	static int parent[];
	static PriorityQueue<Load> que = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		
		for(int i = 1; i<=n; i++) parent[i] = i;
		
		long maxCost = 0;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			que.add(new Load(a, b, cost));
			
			maxCost+=cost;
		}
		
		long sum = 0;
		int cnt = 0;
		while(!que.isEmpty()) {
			Load load = que.poll();
			if(!isParent(load.a, load.b)) {
				union(load.a, load.b);
				sum+=load.cost;
				cnt++;
			}
		}
		
		
		if(cnt == n-1) {
			System.out.println(maxCost-sum);
		}
		else System.out.println(-1);
	}
	
	private static void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		parent[ap] = bp;
	}
	private static boolean isParent(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(ap == bp) return true;
		
		return false;
	}
	private static int find(int vertex) {
		if(parent[vertex] == vertex) {
			return vertex;
		}
		
		return parent[vertex] = find(parent[vertex]);
	}

}
