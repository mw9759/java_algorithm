package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17835_면접보는승진이네 {

	static class Node implements Comparable<Node>{

		int to;
		long cost;
		
		public Node(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	static int n, m, k;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int endNodes[];
	static long dist[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 노드 수
		m = Integer.parseInt(st.nextToken()); // 간선 수
		k = Integer.parseInt(st.nextToken()); // 목표지점 수
		
		endNodes = new int[k]; // 목표지점들.
		dist = new long[n+1]; // 각 출발지에서 도착지까지의 최단거리 : dist[도착지번호] 가 구하고자 하는것.
		
		// list 초기화 : 노드 수만큼
		for(int i = 0; i<=n; i++) {
			list.add(new ArrayList<Node>());
		}
		
		// 간선 입력
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(to).add(new Node(from, cost));
		}
		
		// 목적지(면접장) 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<k; i++) {
			int end = Integer.parseInt(st.nextToken());
			endNodes[i] = end;
		}
		
		solution();
		long max = 0;
		int node = 0;
		// 최대 값 및 노드 구하기
		for(int j = 1; j<=n; j++) {
			if(max < dist[j]) {
				max = dist[j];
				node = j;
			}
			else if(dist[j] == max) {
				node = node>j?j:node;
			}
		}
		
		
		System.out.println(node);
		System.out.println(max);
	}
	private static void solution() {
		Arrays.fill(dist, Long.MAX_VALUE);
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		for(int i = 0; i<k; i++) {
			que.add(new Node(endNodes[i], 0));
			dist[endNodes[i]] = 0;
		}
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			// 패스조건 : 현재가 최소값 아님.
			if(dist[now.to] < now.cost) continue;
			
			// 최소거리 탐색
			for(Node next : list.get(now.to)) {
				if(dist[next.to] > dist[now.to] + next.cost) {
					dist[next.to] = dist[now.to] + next.cost;
					que.add(new Node(next.to, dist[next.to]));
				}
			}
		}
	}

}
