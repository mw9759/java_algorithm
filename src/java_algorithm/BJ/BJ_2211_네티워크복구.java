package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2211_네티워크복구 {
	
	static class Computer implements Comparable<Computer>{
		int pair;
		int time;
		
		public Computer(int pair, int time) {
			this.pair = pair;
			this.time = time;
		}

		@Override
		public int compareTo(Computer o) {
			return this.time - o.time;
		}
	}
	static int n, m;
	static List<ArrayList<Computer>> arr;
	static int dist[], preCom[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		arr = new ArrayList<>();
		
		for(int i = 0; i<=n; i++) {
			arr.add(new ArrayList<Computer>());
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			arr.get(com1).add(new Computer(com2, t));
			arr.get(com2).add(new Computer(com1, t));
		}
		
		preCom = new int[n+1];
		for(int i = 2; i<=n; i++) {
			solution(i);
		}
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++) {
			if(preCom[i] != 0) {
				cnt++;
				sb.append(i + " " + preCom[i]).append("\n");
			}
		}
		
		System.out.println(cnt + "\n" + sb.toString());
	}

	private static void solution(int goal) {
		PriorityQueue<Computer> que = new PriorityQueue<>();
		que.add(new Computer(1, 0));
		dist[1] = 0;
		
		while(!que.isEmpty()) {
			Computer now = que.poll();
			if(now.time < dist[now.pair]) continue;
			if(now.pair == goal) {
				
				//return;
			}
			
			for(Computer next : arr.get(now.pair)) {
				if(dist[next.pair] > dist[now.pair] + next.time) {
					dist[next.pair] = dist[now.pair] + next.time;
					preCom[next.pair] = now.pair;
					que.add(new Computer(next.pair, dist[next.pair]));
				}
			}
		}
	}

}
