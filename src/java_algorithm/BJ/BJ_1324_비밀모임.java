package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1324_비밀모임 {

	static class Road implements Comparable<Road>{
		int to;
		int cost;
		
		public Road(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Road o) {
			return this.cost - o.cost;
		}
	}
	
	static int n, m, k;
	static int freindsDir[];
	static int record[][];
	static ArrayList<ArrayList<Road>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			record = new int[n+1][n+1];
			
			for(int i = 0; i<=n; i++) 
				list.add(new ArrayList<>());
			
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				list.get(from).add(new Road(to, cost));
				list.get(to).add(new Road(from, cost));
			}
			
			k = Integer.parseInt(br.readLine());
			freindsDir = new int[k];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<k; i++) {
				freindsDir[i] = Integer.parseInt(st.nextToken());
			}
			
			int minSum = Integer.MAX_VALUE;
			int answer = 0;
			for(int i = 1; i<=n; i++) {
				int sum = 0; // i번째 방에서 모이기로 했을때의 최소값의 합.
				for(int j = 0; j<k; j++) {
					if(record[freindsDir[j]][i] == 0)
						sum += solution(freindsDir[j], i);
					else sum += record[freindsDir[j]][i];
				}
				if(minSum > sum) {
					minSum = sum;
					answer = i;
				}
			}
			
			System.out.println(answer);
		}
	}
	private static int solution(int start, int end) {
		int dist[] = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Road> que = new PriorityQueue<>();
		que.add(new Road(start, 0));
		
		while(!que.isEmpty()) {
			Road now = que.poll();
			for(Road next : list.get(now.to)) {
				if(dist[next.to] > dist[now.to] + next.cost) {
					dist[next.to] = dist[now.to] + next.cost;
					record[start][next.to] = dist[next.to];
					que.add(new Road(next.to, dist[next.to]));
				}
			}
		}
		
		record[start][end] = dist[end];
		return dist[end];
	}

}
