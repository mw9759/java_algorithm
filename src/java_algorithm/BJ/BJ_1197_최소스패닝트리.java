package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리 {

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
	static PriorityQueue<Edge> que;
	static int parent[];
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
				System.out.println(edge.x+"와 "+edge.y+"는 간선연결 가능.");
				union(edge.x, edge.y);
				result += edge.score;
			}
		}
		System.out.println(result);
	}
	private static void union(int x, int y) {
		System.out.println(x+"와"+y+"를 연결해야하니 부모를 같게 만든다.");
		int xp = find(x);
		int yp = find(y);
		System.out.println("각 부모는"+xp+"와"+yp+"이다.");
		System.out.println("parent[xp]의 기존값은 " + parent[xp]+"이다.");
		parent[xp] = yp;
		System.out.println("parent[xp] = yp 해줘서 " + parent[xp]+"이다.");
	}
	private static boolean isParent(int x, int y) {
		System.out.println(x+"와"+y+"는 연결 가능한가?");
		int nx = find(x);
		int ny = find(y);
		System.out.println(x+"와"+y+"는 부모가 "+nx+"와"+ny+" 이였다.");
		if(nx == ny) {
			System.out.println("서로 같음으로 이미 연결되어있다. 새로 연결 불가능");
			return true; // 이미 연결되있음. 넘어감.
		}
		System.out.println("서로 다름으로 새로 연결 가능하다.");
		return false; // 연결 가능한 간선이다.
	}
	private static int find(int vertex) {
		System.out.println(vertex+"의 부모노드는?");
		if(parent[vertex] == vertex) {
			System.out.println(vertex+"인 자신이였다.");
			return parent[vertex];
		}
		System.out.println(parent[vertex]+"임으로 다시 찾는다.");
		return parent[vertex] = find(parent[vertex]);
	}

}
