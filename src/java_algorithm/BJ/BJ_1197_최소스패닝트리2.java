package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리2 {

	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int score;
		
		public Edge(int x, int y, int score) {
			this.x = x;
			this.y = y;
			this.score = score;
		}
		@Override
		public int compareTo(Edge o) {
			return this.score - o.score;
		}
	}
	
	static int v, e;
	static int parent[];
	static PriorityQueue<Edge> que;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[v+1];
		
		for(int i = 1; i<v+1; i++) {
			parent[i] = i;
		}
		
		que = new PriorityQueue<>();
		
		for(int i = 0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			que.add(new Edge(x, y, score));
		}
		
		int result = 0;
		while(!que.isEmpty()) {
			Edge edge = que.poll();
			
			if(!isParent(edge.x, edge.y)) {
				union(edge.x, edge.y);
				result += edge.score;
			}
		}
		
		System.out.println(result);
	}
	private static void union(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		
		parent[xp] = yp;
	}
	private static boolean isParent(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx == ny) return true;
		
		return false;
	}
	private static int find(int vertex) {
		if(parent[vertex] == vertex) {
			return vertex;
		}
		
		return parent[vertex] = find(parent[vertex]);
	}

}
