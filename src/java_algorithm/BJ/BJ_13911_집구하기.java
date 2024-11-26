package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13911_집구하기 {

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
	
	static int v, e;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int mc, mm; // 맥도날드 수, 맥도날스 최소거리조건
	static int sc, sm; // 스타벅스 수, 스타벅스 최소거리조건
	static int macs[], stas[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
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
		
		// 맥날--------------------------------------------------------------
		st = new StringTokenizer(br.readLine());
		mc = Integer.parseInt(st.nextToken());
		mm = Integer.parseInt(st.nextToken());
		macs = new int[mc];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<mc; i++) {
			macs[i] = Integer.parseInt(st.nextToken());
		}
		
		long resultMac[] = solution(1);
		
		// 스벅-------------------------------------------------------------
		st = new StringTokenizer(br.readLine());
		sc = Integer.parseInt(st.nextToken());
		sm = Integer.parseInt(st.nextToken());
		stas = new int[sc];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<sc; i++) {
			stas[i] = Integer.parseInt(st.nextToken());
		}
		
		long resultSta[] = solution(2);
		
		// 세권을 만족하며 최솟값의 경우 
		long answer = Long.MAX_VALUE;
		for(int i = 1; i<=v; i++) {
			if(resultMac[i] == 0 || resultSta[i] == 0) continue;
			if(resultMac[i] <= mm && resultSta[i] <= sm) {
				long sum = resultMac[i]+resultSta[i];
				answer = answer < sum ? answer : sum;
			}
		}
		
		System.out.println(answer != Long.MAX_VALUE ? answer : -1);
	}
	
	private static long[] solution(int type) {
		long dist[] = new long[v+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		if(type == 1) {
			for(int i = 0; i<mc; i++) {
				que.add(new Node(macs[i], 0));
				dist[macs[i]] = 0;
			}
		}
		else {
			for(int i = 0; i<sc; i++) {
				que.add(new Node(stas[i], 0));
				dist[stas[i]] = 0;
			}
		}
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(dist[now.to] < now.cost) continue;
			
			for(Node next : list.get(now.to)) {
				if(dist[next.to] > dist[now.to]+ next.cost) {
					dist[next.to]= dist[now.to]+next.cost;
					
					que.add(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		return dist;
	}

}
