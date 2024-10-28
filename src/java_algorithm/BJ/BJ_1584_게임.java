package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author yoyoy
 * 풀이 : 4방탐색 다익스트라
 */
public class BJ_1584_게임 {

	static class Node implements Comparable<Node>{
		int x;
		int y;
		int hp;
		
		public Node(int x, int y, int hp) {
			this.x = x;
			this.y = y;
			this.hp = hp;
		}

		@Override
		public int compareTo(Node o) {
			return this.hp-o.hp;
		}
	}
	
	static int cntE, cntD;
	static int map[][];
	static int dist[][];
	static int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		cntE = Integer.parseInt(br.readLine());
		
		map = new int[501][501];
		dist = new int[501][501];
		for(int i = 0; i<=500; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		StringTokenizer st;
		for(int i = 0; i<cntE; i++)
			set(new StringTokenizer(br.readLine()), 1);
		
		cntD = Integer.parseInt(br.readLine());
		for(int i = 0; i<cntD; i++)
			set(new StringTokenizer(br.readLine()), 2);
		
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.add(new Node(0, 0, 0));
		dist[0][0] = 0;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(dist[now.x][now.y] < now.hp) continue;
			
			if(now.x == 500 && now.y == 500) break;
			
			for(int i = 0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx<0 || ny<0 || nx>500 || ny>500) continue;
				int nhp = 0;
				
				if(map[nx][ny] == 1) 
					nhp = 1;
				
				else if(map[nx][ny] == 2) continue; 
					
				
				if(dist[nx][ny] > dist[now.x][now.y] + nhp) {
					dist[nx][ny] = dist[now.x][now.y] + nhp;
					que.add(new Node(nx, ny, dist[nx][ny]));
				}
			}
		}
		if(dist[500][500] < Integer.MAX_VALUE)
			System.out.println(dist[500][500]);
		else System.out.println(-1);
	}
	
	public static void set(StringTokenizer st, int type) {
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		if(x1 > x2) {
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		
		if(y1 > y2) {
			int temp = y1;
			y1 = y2;
			y2 = temp;
		}
		
		for(int i = x1; i<=x2; i++) {
			for(int j = y1; j<=y2; j++) {
				map[i][j] = type;
			}
		}
	}
}
