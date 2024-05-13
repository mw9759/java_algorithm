package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17472_다리만들기2 {

	static class Bridge implements Comparable<Bridge>{
		int x;
		int y;
		int cost;
		
		public Bridge(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Bridge o) {
			return this.cost - o.cost;
		}
		
		@Override
		public String toString() {
			return "x : " + x + " y : " + y + " cost : " + cost;
		}
	}
	static int n, m;
	static int map[][], isBridge[][][], parent[];
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
	static PriorityQueue<Bridge> que = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		isBridge = new int[n][m][4];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 구분
		int islandNum = 2; // 섬번호
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 1) {
					map[i][j] = islandNum;
					separates(i, j, islandNum++);
				}
			}
		}
		
		// 섬번호만큼 초기화.
		parent = new int[islandNum];
		for(int i = 2; i<islandNum; i++) parent[i] = i;
		
		//다리 놓기
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] != 0) {
					isBridge(i, j);
				}
			}
		}
		int result = 0;
		int cnt = 0;
		while(!que.isEmpty()) {
			Bridge bridge = que.poll();
			
			if(!isParent(bridge.x, bridge.y)) {
				cnt++;
				union(bridge.x, bridge.y);
				result += bridge.cost;
			}
		}
		if(cnt != islandNum-3) result = -1;
		
		System.out.println(result);
		
	}
	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		parent[px] = py;
	}
	private static boolean isParent(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px == py) return true;
		return false;
	}
	
	private static int find(int vertex) {
		if(parent[vertex] == vertex) return vertex;
		
		return parent[vertex] = find(parent[vertex]);
	}
	
	private static void isBridge(int x, int y) {
		//4방 탐색 : 다리를 놓을 수 있는 조건 --> 바다인가.
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] != 0) continue;
			if(isBridge[x][y][i] == 1) continue; // 이미 해당지역 해당 방향에 다리가 놓여진 경우.
			// 다리 놓기.
			setBridge(x, y, i);
		}
	}
	
	private static void setBridge(int x, int y, int dir) {
		Queue<Bridge> now = new ArrayDeque<>();
		now.add(new Bridge(x, y, 0));
		while(!now.isEmpty()) {
			Bridge b = now.poll();
			
			int nx = b.x + dx[dir];
			int ny = b.y + dy[dir];
			if(nx<0 || nx>=n || ny<0 || ny>=m) return;
			if(map[nx][ny] == map[x][y]) return;
			
			
			// 다른 섬 도착
			if(map[nx][ny] != 0) {
				if(b.cost<2) return;
				que.add(new Bridge(map[x][y], map[nx][ny], b.cost));
				isBridge[x][y][dir] = 1;
				switch (dir) {
				case 0:
					isBridge[nx][ny][2] = 1;
					break;
				case 1:
					isBridge[nx][ny][3] = 1;
					break;
				case 2:
					isBridge[nx][ny][0] = 1;
					break;
				default:
					isBridge[nx][ny][1] = 1;
					break;
				}
				return;
			}
			// 강
			else if(map[nx][ny] == 0) {
				now.add(new Bridge(nx, ny, b.cost+1));
			}
			
		}
	}
	private static void separates(int x, int y, int islandNum) {
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] != 1) continue;
			map[nx][ny] = islandNum;
			separates(nx, ny, islandNum);
		}
	}

}
