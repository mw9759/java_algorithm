package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_10423_전기가부족해 {

	static class Cable implements Comparable<Cable>{
		int a;
		int b;
		int cost;
		public Cable(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Cable o) {
			return this.cost-o.cost;
		}
	}
	
	static int n, m, k;
	static int parent[], isCenter[];
	static PriorityQueue<Cable> que = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		isCenter = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<k; i++) {
			isCenter[Integer.parseInt(st.nextToken())] = 1;
		}
		
		for(int i = 1; i<n+1; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			que.add(new Cable(a, b, cost));
		}
		
		int result = 0;
		while(!que.isEmpty()) {
			Cable c = que.poll();
			
			if(!isParent(c.a, c.b)) {
				union(c.a, c.b);
				result += c.cost;
			}
		}
		
		System.out.println(result);
	}

	private static void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(isCenter[ap] == 1) {
			parent[bp] = ap;
			return;
		}
		
		parent[ap] = bp;
	}

	private static boolean isParent(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(ap == bp) return true;
		// 둘이 연결되어있지 않은데 둘 다 발전소와 연결된 상태라면
		else if(isCenter[ap] == 1 && isCenter[bp] == 1) {
			return true;
		}
		return false;
	}

	private static int find(int vertex) {
		if(parent[vertex] == vertex) {
			return vertex;
		}
		
		return parent[vertex] = find(parent[vertex]);
	}

}// 2 | 3 | 4 | 
