package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_11779_손민우 {
	
	static class City implements Comparable<City>{
		int to;
		int weight;
		
		public City(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(City o) {
			return this.weight - o.weight;
		}
		
	}
	
	static int n, m;
	static List<ArrayList<City>> arr;
	static int dist[], preCity[];
	static int start, end;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		for(int i = 0; i<=n; i++) {
			arr.add(new ArrayList<City>());
		}
		
		dist = new int[n+1];
		preCity = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		StringTokenizer st;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			arr.get(from).add(new City(to, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		solution(start);
		System.out.println(dist[end]);
		
		int cnt = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while(preCity[end] != 0) {
			cnt+=1;
			stack.push(preCity[end]);
			end = preCity[end];
		}
		System.out.println(cnt);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
	}

	private static void solution(int start) {
		PriorityQueue<City> que = new PriorityQueue<>();
		que.add(new City(start, 0));
		dist[start] = 0;
		
		while(!que.isEmpty()) {
			City curCity = que.poll();
			int cur = curCity.to;
			if(dist[cur] < curCity.weight) continue;
			
			for(City next : arr.get(cur)) {
				if(dist[next.to] > dist[cur]+next.weight) {
					dist[next.to] = dist[cur] + next.weight;
					preCity[next.to] = cur;
					que.add(new City(next.to, dist[next.to]));
				}
			}
		}
	}
}
