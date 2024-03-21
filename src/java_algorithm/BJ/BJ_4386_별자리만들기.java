package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4386_별자리만들기 {

	static class Line implements Comparable<Line>{
		int a;
		int b;
		double cost;
		
		public Line(int a, int b, double cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Line o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	
	static int n;
	static int parent[];
	static double star[][];
	static PriorityQueue<Line> que = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		star = new double[n+1][2]; // 별개수 , 좌표(x,y)
		parent = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st;
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			star[i][0] = x;
			star[i][1] = y;
		}
		
		for(int i = 1; i<n; i++) {
			for(int j = i+1; j<=n; j++) {
				calDis(i, j);
			}
		}
		
		double result = 0;
		while(!que.isEmpty()) {
			Line line = que.poll();
			
			if(!isParent(line.a, line.b)) {
				union(line.a, line.b);
				result += line.cost;
			}
		}
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(result));
	}

	private static void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		parent[ap] = bp;
	}

	private static boolean isParent(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		if(ap == bp) return true; 
		
		return false;
	}

	private static int find(int vertex) {
		if(parent[vertex] == vertex) {
			return vertex;
		}
		
		return parent[vertex] = find(parent[vertex]);
	}

	private static void calDis(int as, int bs) {
		double w = star[as][0] - star[bs][0];
		double h = star[as][1] - star[bs][1];
		
		que.add(new Line(as, bs, Math.sqrt(w*w + h*h)));
	}

}
