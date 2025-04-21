package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_13913_숨바꼭질4 {

	
	static int N, K;
	static int from[] = new int[100001];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		solution();
		
		Stack<Integer> path = new Stack<>();
		for(int i = K; i != N; i = from[i]) {
			path.push(i);
		}
		path.push(N);
		
		System.out.println(path.size()-1);
		while(!path.isEmpty()) {
			System.out.print(path.pop() + " ");
		}
	}

	public static void solution() {
		Queue<Integer> que = new LinkedList<Integer>();
		int visited[] = new int[100001];
		visited[N] = 1;
		que.add(N);
		
		while(!que.isEmpty()) {
			
			int now = que.poll();
			
			int nextMoves[] = {now+1, now-1, now*2};
			for(int next : nextMoves) {
				if(next >= 0 && next <= 100000 && visited[next] == 0) {
					visited[next] = 1;
					from[next] = now;
					
					que.add(next);
					
					if(next == K) {
						return;
					}
				}
			}
		}
	}
}
