package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10282_해킹 {

	static class Computer implements Comparable<Computer>{
		int follow;
		int time;
		
		public Computer(int follow, int time) {
			this.follow = follow;
			this.time = time;
		}

		@Override
		public int compareTo(Computer o) {
			return this.time - o.time;
		}
	}
	
	static int n, d, c;
	static List<ArrayList<Computer>> arr;
	static int dist[], visit[];
	static int maxTime, totalCnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			dist = new int[n+1];
			visit = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			arr = new ArrayList<>();
			for(int i = 0; i<=n; i++) {
				arr.add(new ArrayList<Computer>());
			}
			
			for(int i = 0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				// a -> b a가 b의존. b감염시 a감염.
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				arr.get(b).add(new Computer(a, s)); // b 감염시 감염 옮을 컴퓨터들을 담는다.
			}
			maxTime = 0;
			solution();
			
			totalCnt = 0;
			for(int i = 1; i<=n; i++) {
				if(visit[i] == 1) {
					maxTime = Math.max(maxTime, dist[i]);
					totalCnt++;
				}
			}
			System.out.println(totalCnt + " " + maxTime);
		}
		
	}
	private static void solution() {
		PriorityQueue<Computer> que = new PriorityQueue<>();
		que.add(new Computer(c, 0));
		dist[c] = 0;
		visit[c] = 1;
		
		while(!que.isEmpty()) {
			Computer nowCom = que.poll();
			int now = nowCom.follow;
			if(dist[now] < nowCom.time) continue;
			
			for(Computer next : arr.get(now)) {
				if(dist[next.follow] > dist[now] + next.time) {
					dist[next.follow] = dist[now] + next.time;
					visit[next.follow] = 1;
					que.add(new Computer(next.follow, dist[next.follow]));
				}
			}
		}
	}

}
