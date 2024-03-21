package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1922_네트워크연결 {

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
			return this.cost - o.cost;
		}
	}
	
	static int n, m;
	static int parent[];
	static PriorityQueue<Cable> que;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		
		for(int i = 1; i<n+1; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st;
		que = new PriorityQueue<Cable>();
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			que.add(new Cable(a, b, cost));
		}
		
		int result = 0;
		while(!que.isEmpty()) {
			Cable cable = que.poll();
			
			if(!isParent(cable.a, cable.b)) { // 연결 가능한 간선일때 : 부모 노드가 다르다.
				union(cable.a, cable.b);
				result += cable.cost;
			}
		}
		
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
		// 단순히 부모만 찾는게 아니라 최종 부모를 찾아서 통일해줘야함.
		int ap = find(a);
		int bp = find(b);
		
		parent[ap] = bp;
	}

	public static boolean isParent(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		if(ap == bp) return true;
		
		return false;
	}
	
	public static int find(int vertex) {
		if(parent[vertex] == vertex) {
			return parent[vertex];
		}
		return parent[vertex] = find(parent[vertex]);
	}

}
