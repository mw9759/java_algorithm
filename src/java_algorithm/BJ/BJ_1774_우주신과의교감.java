package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1774_우주신과의교감 {

	static class Line implements Comparable<Line>{
		int x;
		int y;
		double cost;
		
		public Line(int x, int y, double cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Line o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	
	static int n, m;
	static int map[][];
	static int parent[];
	static PriorityQueue<Line> que = new PriorityQueue<>();
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][2];
		parent = new int[n+1];
		
		list = new ArrayList<>();
		for(int i = 0; i<n+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[i][0] = x;
			map[i][1] = y;
		}

		// 거리구하기 = 우주신들간 통로 비용
		//findCost();
		
		// 이미 연결되어있는 구간초기화
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
		    union(x, y);
		}
		
		// 연결관계 정리
//		for(int i = 0; i<m; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			
//		    list.get(x).add(y);
//		    list.get(y).add(x);
//		}
		
		findCost();
		
		// 최단거리로 스패닝트리 구하기.
		double result = 0;
		while(!que.isEmpty()) {
			Line line = que.poll();
			
			if(!isParent(line.x, line.y)) {
				union(line.x, line.y);
				result += line.cost;
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
//		String formatedResult = String.format("%.2f", df.format(result));
		//double rounded = Math.round(result * 100.0) / 100.0; // 소수점 둘째 자리에서 반올림
		
		//System.out.println(df.format(result));
		//System.out.printf("%.2f", result);
		System.out.println(String.format("%.2f", result));
	}

	private static boolean isParent(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		
		if(xp == yp) return true;
		
		return false;
	}

	private static void union(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		
		if(xp != yp)
			parent[xp] = yp;
	}

	private static int find(int vertex) {
		if(parent[vertex] == vertex) 
			return vertex;
		
		return parent[vertex] = find(parent[vertex]);
	}

	private static void findCost() {
		for(int i = 1; i<n; i++) {
			for(int j = i+1; j<=n; j++) {
				double w = map[i][0] - map[j][0];
				double h = map[i][1] - map[j][1];
				
				double cost = 0;
				cost = Math.sqrt(w*w + h*h);
				//cost = Math.sqrt(Math.pow(w, 2)+Math.pow(h, 2));
//				if(!isLinked(i, j)) {
//				}
				
				que.add(new Line(i, j, cost));
			}
		}		
	}

//	private static boolean isLinked(int i, int j) {
//		for(int a : list.get(i)) {
//			if(a == j) return true;
//		}
//		return false;
//	}

}
