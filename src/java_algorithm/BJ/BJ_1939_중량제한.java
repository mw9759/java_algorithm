package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int d;
	int w;
	public Node(int d, int w) {
		this.d = d;
		this.w = w;
	}
}
public class BJ_1939_중량제한 {
	
	static int n, m, start, finish;
	static List<Node> list[];
	static int[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		
		for(int i = 0; i<n+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		int lo = Integer.MAX_VALUE;
		int hi = Integer.MIN_VALUE;
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			lo = Math.min(lo, c);
			hi = Math.max(hi, c);
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		finish = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			visit = new int[n+1];
			
			if(bfs(mid)) {
				lo = mid + 1;
				answer = mid;
			}
			else {
				hi = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
	private static boolean bfs(int mid) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(start);
		visit[start] = 1;
		
		while(!que.isEmpty()) {
			int s = que.poll();
			
			if(s == finish) return true;
			
			for(int i = 0; i<list[s].size(); i++) {
				if(list[s].get(i).w >= mid && visit[list[s].get(i).d] == 0) {
					visit[list[s].get(i).d] = 1;
					que.add(list[s].get(i).d);
				}
			}
		}
		
		return false;
	}	
	
}
