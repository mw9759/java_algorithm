package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point1600{
	int horseMovingCnt;
	int allMovingCnt;
	int x;
	int y;
	
	public Point1600(int horseMovingCnt, int allMovingCnt, int x, int y) {
		this.horseMovingCnt = horseMovingCnt;
		this.allMovingCnt = allMovingCnt;
		this.x = x;
		this.y = y;
	}
}

public class BJ_1600_말이되고픈원숭이 {
	
	static int k, n, m, arr[][], visit1[][][];
	static int[] dx = {0, 1, 0, -1, -2, -1, 1, 2, 2, 1, -1, -2}, 
			  	 dy = {1, 0, -1, 0, 1, 2, 2, 1, -1, -2, -2, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit1 = new int[n][m][k+1]; // 해당 좌표에 말이동을 몇번한 이동 기록인지 함께 검증.
		//-> 말이동으로 방문한 지역이 다른 bfs에서 말이동 없이 와야하는 지역일때 방문 기록이 있으면 오답을 초래함으로
		// 말이동이 몇 번 했는지 함께 검증. 
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = bfs();
		
		System.out.println(answer);
		
	}
	private static int bfs() {
		Queue<Point1600> que = new ArrayDeque<Point1600>();
		visit1[0][0][0] = 1;
		que.add(new Point1600(0,0,0,0));
		
		while(!que.isEmpty()) {
			Point1600 p = que.poll();
			int x = p.x;
			int y = p.y;
			int hCnt = p.horseMovingCnt;
			int aCnt = p.allMovingCnt;
			
			if(x == n-1 && y == m-1) {
				return aCnt;
			}
			
			// 이동체크 : 말 이동이 남았으면 0~11(4방+말8방), 말 이동이 없으면 0~3(4방)
			int end = 4;
			if(hCnt < k) end = 12;   
			for(int i = 0; i<end; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
//				System.out.println("x: "+x+" y: "+ y+ " hc: "+ hCnt+ " ac: " + aCnt
//						+" end: "+ end+ " i: "+ i + " nx: "+ nx+ " ny: " + ny);
				// 범위 체크
				if(nx < 0 || nx >=n || ny < 0 || ny >= m) continue;
				
				// 장애물체크 :도착지가 장애물(4방+말8방)
				if(arr[nx][ny] == 1) {
					
					continue;
				}
				
				// 4방 탐색 로직
				if(i<4) {
					if(visit1[nx][ny][hCnt] == 1)continue;
					visit1[nx][ny][hCnt] = 1;
					que.add(new Point1600(hCnt, aCnt + 1, nx, ny));
				}
				
				// 말8방 탐색 로직
				else {
					if(visit1[nx][ny][hCnt+1] == 1)continue;
					visit1[nx][ny][hCnt+1] = 1;
					que.add(new Point1600(hCnt + 1, aCnt + 1, nx, ny));
				}
			}
			
		}
		
		return -1;
	}
	
}
