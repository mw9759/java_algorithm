package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1005_ACMCRAFT {
	
	static class Node{
		int from;
		int to;
		int total;
		
		public Node(int from, int to, int total) {
			this.from = from;
			this.to = to;
			this.total = total;
		}
		
	}
	
	static int n, k, p;
	static int times[];
	static ArrayList<Integer>[] next;
	static int beforeCnt[];
	static int dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			times = new int[n+1];
			dp = new int[n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=n; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			
			next = new ArrayList[n+1];
			beforeCnt = new int[n+1];
			for(int i = 0; i<=n; i++) {
				next[i] = new ArrayList<>();
			}
			
			for(int i = 0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				next[from].add(to);
				beforeCnt[to] += 1;
			}
			p = Integer.parseInt(br.readLine());
			
			Queue<Node> que = new ArrayDeque<>();
			for(int i = 1; i<=n; i++) {
				if(beforeCnt[i] == 0) {
					dp[i] = times[i];
					for(int to : next[i]) {
						dp[to] = Math.max(dp[to], dp[i] + times[to]);
						que.add(new Node(beforeCnt[i], to, dp[i] + times[to]));
					}
				}
			}
			int answer = 0;
			
			while(!que.isEmpty()) {
				Node now = que.poll();
				for(int next : next[now.to]) {
					if(dp[next] < dp[now.to]+times[next]) {
						dp[next] = dp[now.to] + times[next];
						que.add(new Node(now.to, next, dp[next]));
					}
				}
			}
			answer = dp[p];
			System.out.println(answer);
		}
	}
	
}
/*
 
1
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4


*/