package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_카드1_2161 {
	
	static int n;
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		solution();
		System.out.println(sb);
	}
	
	private static void solution() {
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		while(q.size()>1) {
			sb.append(q.poll()).append(" ");
			q.add(q.poll());
		}
		sb.append(q.peek());
	}
}
