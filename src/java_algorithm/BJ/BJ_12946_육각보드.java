package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_12946_육각보드 {

	
	static int n, answer;
	static int arr[][], visit[][];
	static int[] dx = {-1, -1, 0, 1, 1, 0}, dy = {0, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new int[n][n];
		answer = 0;
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<n; j++) {
				if(str.charAt(j) == 'X') {
					arr[i][j] = 1;
				}
				visit[i][j] = -1;
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j] == 1 && visit[i][j] == -1) {
					dfs(i, j, 0);
				}
			}
		}
		
		System.out.println(answer);
	}
	private static void dfs(int x, int y, int color) {
		visit[x][y] = color;
		answer = Math.max(answer, 1);
		
		for(int i = 0; i<6; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
			
			if(arr[nx][ny] == 1 && visit[nx][ny] == -1) {
				dfs(nx, ny, 1-color);
				answer = Math.max(answer, 2);
			}
			
			// 만약 다음 좌표의 색이 현재 색과 같다면 다음좌표는 방문한 적이 있으며 다른색을 찾아야 함.
			// 현재 색은 이전 좌표의 색과는 다른 색임으로 다음좌표와 이전좌표 그리고 현재 좌표는 모두 인접함.
			// 따라서 3가지의 색이 필요한 경우이다.
			if(visit[nx][ny] == color) {
				answer = 3;
			}
		}
	}
}
