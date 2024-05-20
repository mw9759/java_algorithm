package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17396_백도어 {

	static class Edge implements Comparable<Edge>{
		int to;
		long cost;
		
		public Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	static int n, m;
	static int isWard[];
	static long dist[];
	static ArrayList<ArrayList<Edge>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i = 0; i<n; i++) list.add(new ArrayList<>());
		isWard = new int[n];
		dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) isWard[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(check(from, to)) {
				list.get(from).add(new Edge(to, cost));
				list.get(to).add(new Edge(from, cost));
			}
		}
		
		solution(0, n-1);
		long answer = dist[n-1] == Long.MAX_VALUE? -1 : dist[n-1];
		System.out.println(answer);
	}
	private static void solution(int start, int end) {
		PriorityQueue<Edge> que = new PriorityQueue<>();
		boolean visited[] = new boolean[n];
		que.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!que.isEmpty()) {
			Edge now = que.poll();
			int cur = now.to;
			
			if(!visited[cur]) {
				visited[cur] = true;
				
				for(Edge next : list.get(cur)) {
					if(!visited[next.to] && dist[next.to] > dist[cur] + next.cost) {
						dist[next.to] = dist[cur] + next.cost;
						que.add(new Edge(next.to, dist[next.to]));
					}
				}
			}
		}
	}
	
	private static boolean check(int from, int to) {
		boolean canMove = true;
		
		if(isWard[from] == 1 && from != n-1) 
			canMove = false;
		if(isWard[to] == 1 && to != n-1)
			canMove = false;
		
		return canMove;
	}

}

//5 7
//0 0 0 1 1
//0 1 7
//0 2 2
//1 2 4
//1 3 3
//1 4 6
//2 3 2
//3 4 1