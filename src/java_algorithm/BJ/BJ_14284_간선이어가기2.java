package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14284_간선이어가기2 {

	static class Line implements Comparable<Line>{
		int to;
		int cost;
		
		public Line(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Line o) {
			return this.cost - o.cost;
		}
	}
	
	static int n, m;
	static int dist[];
	static ArrayList<ArrayList<Line>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		list = new ArrayList<>();
		for(int i = 0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Line(to, cost));
			list.get(to).add(new Line(from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int finish = Integer.parseInt(st.nextToken());
		
		System.out.println(solution(start, finish));
	}
	private static int solution(int start, int finish) {
		PriorityQueue<Line> que = new PriorityQueue<>();
		que.add(new Line(start, 0));
		dist[start] = 0;
		
		while(!que.isEmpty()) {
			Line now = que.poll();
			
			if(dist[now.to] < now.cost) continue;
			
			if(now.to == finish) break;
			
			for(Line next : list.get(now.to)) {
				if(dist[next.to] > dist[now.to] + next.cost) {
					dist[next.to]= dist[now.to] + next.cost;
					que.add(new Line(next.to, dist[next.to]));
				}
			}
		}
		return dist[finish];
	}

}
