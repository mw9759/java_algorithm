package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_9019_DSLR {
	
	static int from[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());

		for(int i = 0; i<tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A, B;
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			from = new int[10000];
			solution(A, B);
			
			Stack<Integer> stack = new Stack<>();
			for(int j = B; j != A; j = from[j]) {
				stack.push(j);
			}
			
			int now = A;
			while(!stack.isEmpty()) {
				int next = stack.pop();
				
				System.out.print(cal(now, next));
				now = next;
			}
			System.out.println();
		}
	}

	private static char cal(int now, int next) {
		
		//D
		int nextD = now*2;
		if(nextD>9999) nextD %= 10000;
		if(nextD == next) return 'D';
		
		//S
		int nextS = now -1;
		if(now == 0) nextS = 9999;
		if(nextS == next) return 'S';
		
		//L 1234->2341
		int nextL = now*10;
		nextL = nextL%10000 + nextL/10000;
		if(nextL == next) return 'L';
				
		//R 1 -> 1000
	    int nextR = now/10 + (now%10)*1000;
		if(nextR == next) return 'R';
	    
		return ' ';
	}

	private static void solution(int a, int b) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(a);
		int visited[] = new int[10000];
		visited[a] = 1;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now == b) return;
			
			//D
			int nextD = now*2;
			if(nextD>9999) nextD %= 10000;
			if(visited[nextD] == 0) {
				que.add(nextD);
				visited[nextD] = 1;
				from[nextD] = now;
			}
			
			//S
			int nextS = now-1;
			if(now == 0) nextS = 9999;
			if(visited[nextS] == 0) {
				que.add(nextS);
				visited[nextS] = 1;
				from[nextS] = now;
			}
			
			//L 1234->2341
			int nextL = now*10;
			nextL = nextL%10000 + nextL/10000;
			if(visited[nextL] == 0) {
				que.add(nextL);
				visited[nextL] = 1;
				from[nextL] = now;
			}
			
			//R 1 -> 1000
		    int nextR = now/10 + (now%10)*1000;
		    if(visited[nextR] == 0) {
		    	que.add(nextR);
		    	visited[nextR] = 1;
		    	from[nextR] = now;
		    }
		}
		
	}
	

}
