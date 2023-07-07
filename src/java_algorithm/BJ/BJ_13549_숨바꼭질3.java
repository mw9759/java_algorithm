package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 implements Comparable<Point2>{
	int point;
	int time;
	
	public Point2(int point, int time){
		this.point = point;
		this.time = time;
	}

	@Override
	public int compareTo(Point2 o) {
		return this.time-o.time;
	}

}

public class BJ_13549_숨바꼭질3 {
	
	static int n, k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
//		int x = n;
//		while(x<=k) {
//			if(x==k) {
//				System.out.println(0);
//				return;
//			}
//			x *= 2;
//		}
		
		Queue<Point2> que = new PriorityQueue<Point2>();
		int arr[] = new int[100001];
		arr[n] = 1;
		que.add(new Point2(n, 0));
		
		while(!que.isEmpty()) {
			int point = que.peek().point;
			int time = que.poll().time;
			
			if(point == k) {
				System.out.println(time);
				return;
			}
			
			if(point-1 >= 0 && arr[point-1] == 0) {
				que.add(new Point2(point-1, time+1));
				arr[point-1] = 1;
			}
			if(point+1<=100000 && arr[point+1] == 0) {
				que.add(new Point2(point+1, time+1));
				arr[point+1] = 1;
			}
			if(point*2<=100000 && arr[point*2] == 0) {
				que.add(new Point2(point*2, time));
				arr[point*2] = 1;
			}
		}
	}
	
	private static boolean check(int point) {
		while(point<=k) {
			if(point==k) {
				return true;
			}
			point *= 2;
		}
		return false;
	}

}
