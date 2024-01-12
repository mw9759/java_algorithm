package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int source;
	int destination;
	int weight;
	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge e) {
		return this.weight - e.weight;
	}
}

public class BJ_1647_도시분할계획 {

	static int n,m;
	static int[] parent;
	static PriorityQueue<Edge> que = new PriorityQueue<>();
	static int result;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		result = 0;
		max = 0;
		
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int source = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			que.add(new Edge(source, destination, weight));
		}
		
		while(!que.isEmpty()) {
			Edge edge = que.poll();
			
			if(!isParent(edge.source, edge.destination)) {
				union(edge.source, edge.destination);
				result += edge.weight;
				max = edge.weight;
			}
		}
		
		System.out.println(result - max);
		
	}
	
	public static int find(int vertex) {
		if(parent[vertex] == vertex) {
			return vertex;
		}
		return parent[vertex] = find(parent[vertex]);
	}
	
	public static boolean isParent(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		
		if(xp != yp) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void union(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		
		parent[xp] = yp;
	}
}
