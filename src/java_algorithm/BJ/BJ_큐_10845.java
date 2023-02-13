package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_큐_10845 {
	static int n;
	static BufferedReader br;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int lastIn;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		solution();
	}
	private static void solution() throws IOException {
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				lastIn = Integer.parseInt(st.nextToken()); 
				q.add(lastIn);
			}
			else if(str.equals("pop")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.poll());
			}
			else if(str.equals("size")) System.out.println(q.size());
			else if(str.equals("empty")) {
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(str.equals("front")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
			}
			else if(str.equals("back")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(lastIn);
			}
		}
	}
	

}
