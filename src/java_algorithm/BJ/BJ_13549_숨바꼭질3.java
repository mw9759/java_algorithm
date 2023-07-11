package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2{
	int point;
	int time;
	
	public Point2(int point, int time){
		this.point = point;
		this.time = time;
	}
}

public class BJ_13549_숨바꼭질3 {
	
	static int n, k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		Queue<Point2> que = new ArrayDeque<Point2>();
		int arr[] = new int[100001];
		arr[n] = 1;
		que.add(new Point2(n, 1));
		
		while(!que.isEmpty()) {
			int point = que.peek().point;
			int time = que.poll().time;
			
			if(point+1<=100000 && point+1>=0) {
				if(arr[point+1] == 0 || arr[point+1]>time+1) {
					que.add(new Point2(point+1, time+1));
					arr[point+1] = time+1;
				}
			}
			
			if(point-1 >= 0 && point-1<=100000) {
				if(arr[point-1] == 0 || arr[point-1] > time+1) {
					que.add(new Point2(point-1, time+1));
					arr[point-1] = time+1;
				}
			}
			if(point*2<=100000 && point*2>=0) {
				if(arr[point*2] == 0 || arr[point*2] > time) {
					que.add(new Point2(point*2, time));
					arr[point*2] = time;
				}
			}
		}
		
		System.out.println(arr[k]-1);
	}
	

}
