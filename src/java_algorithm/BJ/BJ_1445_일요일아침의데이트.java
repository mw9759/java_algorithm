package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1445_일요일아침의데이트 {
	
	static class Spot implements Comparable<Spot>{
		int x;
		int y;
		int gCnt;
		int ngCnt;
		
		public Spot(int x, int y, int gCnt, int ngCnt) {
			this.x = x;
			this.y = y;
			this.gCnt = gCnt;
			this.ngCnt = ngCnt;
		}
		
		@Override
		public int compareTo(Spot o) {
			if(this.gCnt == o.gCnt) {
				return this.ngCnt - o.ngCnt;
			}
			return this.gCnt - o.gCnt;
		}
	}
	
	static int n, m;
	static char map[][];
	static int sx, sy, ex, ey;
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}, dist[][][];
	static int answer1 = 10, answer2 = 10;
	static PriorityQueue<Spot> que = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		dist = new int[n][m][2];
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<m; j++) {
				char c = str.charAt(j);
				if(c == 'S') {
					sx = i;
					sy = j;
				}
				else if(c == 'F') {
					ex = i;
					ey = j;
				}
				
				map[i][j] = c;
				dist[i][j][0] = Integer.MAX_VALUE;
				dist[i][j][1] = Integer.MAX_VALUE;
			}
		}
		solution();
		System.out.println(answer1+" "+answer2);
	}
	
	public static void solution() {
		que.add(new Spot(sx, sy, 0, 0));
		dist[sx][sy][0] = 0; // 쓰레기 직접 지나간 횟수
		dist[sx][sy][1] = 0; // 쓰레시 옆으로 지나간 횟수
		
		while(!que.isEmpty()) {
			Spot now = que.poll();
			if(now.x == ex && now.y == ey) {
				answer1 = now.gCnt;
				answer2 = now.ngCnt;
				return;
			}
			
			for(int i = 0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				
				if(nx == ex && ny ==ey) {
					answer1 = now.gCnt;
					answer2 = now.ngCnt;
					return;
				}
				
				int gCnt = 0;
				int ngCnt = 0;
				
				if(map[nx][ny] == 'g') gCnt = 1;
				else if(map[nx][ny] == 'n') ngCnt = 1;
				else ngCnt = check(nx, ny) ? 1:0;
				
				if(dist[nx][ny][0] > dist[now.x][now.y][0]+gCnt && 
						dist[nx][ny][1] > dist[now.x][now.y][1]+ngCnt) {
					dist[nx][ny][0] = dist[now.x][now.y][0]+gCnt;
					dist[nx][ny][1] = dist[now.x][now.y][1]+ngCnt;
					que.add(new Spot(nx, ny, dist[nx][ny][0], dist[nx][ny][1]));
				}
			}
		}
	}
	
	// 쓰레기 옆인지 확인. 옆이라면 map에 n삽입.
	public static boolean check(int x, int y) { 
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
			if(map[nx][ny] == 'g') {
				map[x][y] = 'n';
				return true;
			}
		}
		return false;
	}
}
