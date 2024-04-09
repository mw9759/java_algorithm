package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {
	
	static int n, m; 
	static int arr[][];
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(x, y, dir);
		System.out.println(answer);
	}

	private static void clean(int x, int y, int dir) {
		if(arr[x][y] == 0) {
			arr[x][y] = 2;
			answer++;
		}
		
		boolean canClean = false;
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 벽검증
			if(arr[nx][ny] != 0) continue;
			
			canClean = true;
		}
		// 청소되지 않은 칸이 없다.
		if(!canClean) {
			// 뒷칸 이동 검증
			canBack(x, y, dir);
			return;
		}
		
		// 청소가능 방향틀기
		changeDir(x, y, dir);
		
		return;
	}

	private static void changeDir(int x, int y, int dir) {
		int nx = x;
		int ny = y;
		// 북-> 서
		if(dir == 0) {
			dir = 3;
			ny--;
		}
		// 동 -> 북
		else if(dir == 1) {
			dir = 0;
			nx--;
		}
		// 남 -> 동
		else if(dir == 2) {
			dir = 1;
			ny++;
		}
		// 서 -> 남
		else if(dir == 3) {
			dir = 2;
			nx++;
		}
		
		// 청소가 불가능한 곳이라면 처음으로
		if(arr[nx][ny] != 0) {
			clean(x, y, dir);
		}
		// 청소가능 한 칸 전진 
		else {
			clean(nx, ny, dir);
		}
	}

	private static void canBack(int x, int y, int dir) {
		int nx = x;
		int ny = y;
		// 북-> 남
		if(dir == 0) nx++;
		// 동 -> 서
		else if(dir == 1) ny--;
		// 남 -> 북
		else if(dir == 2) nx--;
		// 서 -> 동
		else if(dir == 3) ny++;
		
		// 이동불가시 작동멈춤
		if(arr[nx][ny] == 1) return;
		
		// 가능시
		clean(nx, ny, dir);
	}
}
