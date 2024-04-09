package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18223_민준이와마산그리고건우 {

	static class Node implements Comparable<Node>{
		int num;
		int cost;
		
		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int v, e, p;
	static int dist[], preNode[];
	static List<ArrayList<Node>> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken()); // 노드개수
		e = Integer.parseInt(st.nextToken()); // 간선개수
		p = Integer.parseInt(st.nextToken()); // 건우위치
		dist = new int[v+1];
		preNode = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		list = new ArrayList<>();
		for(int i = 0; i<=v; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to, cost));
			list.get(to).add(new Node(from, cost));
		}
		// 우선 최단거리 구하기.
		int minValue = solution(1, v);
		
		// 건후가 있나
		int end = v;
		while(preNode[end] != 0) {
			if(preNode[end] == p) {
				System.out.println("SAVE HIM");
				return;
			}
			end = preNode[end];
		}
		
		// 없는경우 1->건우 최단거리 + 건구->v 최단거리가 == 미리구한 최단거리와 같은지 확인
		Arrays.fill(dist, Integer.MAX_VALUE);
		int minToGun = solution(1, p);
		int minGunToF = solution(p, v);
		if(minToGun+minGunToF == minValue)System.out.println("SAVE HIM");
		else System.out.println("GOOD BYE");
	}

	private static int solution(int start, int finish) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.add(new Node(start, 0));
		dist[start] = 0;
		boolean isSave = false;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(dist[now.num] < now.cost) continue;
			
			if(now.num == finish) break;
			
			for(Node next : list.get(now.num)) {
				if(dist[next.num] > next.cost + dist[now.num]) {
					dist[next.num] = next.cost + dist[now.num];
					preNode[next.num] = now.num;
					que.add(new Node(next.num, dist[next.num]));
				}
			}
		}
		
		return dist[finish];
	}
}
