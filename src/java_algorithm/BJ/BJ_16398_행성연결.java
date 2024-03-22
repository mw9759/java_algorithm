package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16398_행성연결 {

	static class Flow implements Comparable<Flow>{
		int a;
		int b;
		int cost;
		public Flow(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Flow o) {
			return this.cost - o.cost;
		}
	}
	
	static int n;
	static int parent[];
	static PriorityQueue<Flow> que = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	
		StringTokenizer st;
		parent = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if(i==j) continue;
				que.add(new Flow(i, j, cost));
			}
		}
		
		long result = 0;
		while(!que.isEmpty()) {
			Flow flow = que.poll();
			
			if(!isParent(flow.a, flow.b)) {
				union(flow.a, flow.b);
				result += flow.cost;
			}
		}
		
		System.out.println(result);
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
