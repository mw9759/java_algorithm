package java_algorithm.BJ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
   static class Node {
      int x = 0;
      int y = 0;
      int day = 0;

      public Node(int x, int y, int day) {
         super();
         this.x = x;
         this.y = y;
         this.day = day;
      }
   }

   static int map[][];
   static int M, N;
   static int dx[] = { -1, 1, 0, 0 };
   static int dy[] = { 0, 0, -1, 1 };
   static Queue<Node> q = new LinkedList<Node>();
   static int answer;

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stubㄴ
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = null;

      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());

      map = new int[N][M];
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            if (map[i][j] == 1) {
               q.offer(new Node(i, j, 0));
            }
         }
      }
      bfs();
      bw.write("" + answer);
      bw.flush();
      bw.close();
      br.close();
   }

   private static boolean oob(int x, int y) {
      return (0 <= x && x < N && 0 <= y && y < M);
   }

   private static void bfs() {
      while (!q.isEmpty()) {
         Node now = q.poll();

         answer = now.day;
         for (int i = 0; i < 4; i++) {
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if (oob(nx, ny) 
            		&& map[nx][ny] == 0) {
               map[nx][ny] = 1;
               q.offer(new Node(nx, ny, now.day + 1));
            }
         }
      }
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (map[i][j] == 0) {
               answer = -1;
            }
         }
      }
   }

}
package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge2 implements Comparable<Edge2>{
	int source, destination, weight;
	
	public Edge2(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge2 E) {
		return this.weight - E.weight;
	}
}
public class BJ_1647_도시분할계획 {

	static int n, m;
	static PriorityQueue<Edge2> que = new PriorityQueue<Edge2>();;
	static int[] parent;
	static int result;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int source = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			que.add(new Edge2(source, destination, weight));
		}
		
		MST();
		System.out.println(result-max);
	}
	
	public static void MST(){
		
		while(!que.isEmpty()) {
			Edge2 edge = que.poll();
			
			//int x = find(edge.source);
			//int y = find(edge.destination);
			
			if(!isParent(edge.source, edge.destination)) {
				result += edge.weight;
				max = edge.weight;
				union(edge.source,edge.destination);
			}
		}
	}
	public static boolean isParent(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		
		if(xp!=yp) {
			return false;
		}
		return true;
	}
	
	public static int find(int vertex) {
		if(parent[vertex] == vertex) {
			return vertex;
		}
		return parent[vertex] = find(parent[vertex]);
	}
	
	public static void union(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		parent[yp] = xp;
	}

}
