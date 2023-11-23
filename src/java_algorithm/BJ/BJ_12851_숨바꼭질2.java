package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Point_2 {
	int x;
	int time;
	public Point_2(int x, int time) {
		this.x= x;
		this.time = time;
	}
}
public class BJ_12851_숨바꼭질2 {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		if(n>=k) {
			System.out.println(n-k);
			System.out.println(1);
			return;
		}
		int visited[] = new int[100001];
		Queue<Point_2> que = new ArrayDeque<Point_2>();
		visited[n] = 1;
		que.add(new Point_2(n, 0));
		int minTime = Integer.MAX_VALUE;
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int x = que.peek().x;
			int time = que.poll().time;
			
			if (minTime < time) break;
			
			if(x == k) {
				minTime = visited[x];
				cnt++;
			}
			
			if(x+1<100001 && x+1>=0) {
				if(visited[x+1]==0 || visited[x+1]==time+1) {
					que.add(new Point_2(x+1,time+1));
					visited[x+1] = time+1;
				}
			}
			
			if(x-1<100001 && x-1>=0) {
				if(visited[x-1]==0 || visited[x-1]==time+1) {
					que.add(new Point_2(x-1,time+1));
					visited[x-1] = time+1;
				}
			}
			
			if(x*2<100001 && x*2>=0) {
				if(visited[x*2]==0 || visited[x*2]==time+1) {
					que.add(new Point_2(x*2,time+1));
					visited[x*2] = time+1;
				}
			}
		}
		System.out.println(minTime);
		System.out.println(cnt);
	}

}
