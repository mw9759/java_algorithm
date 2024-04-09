package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노 {
	
	static int n, m, arr[][], visited[][];
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				// dfs로 가능 테트로미노
				visited[i][j] = 1;
				dfs(i, j, 1, arr[i][j]);

				// 불가능 테트로미노
				solution(i, j);
				visited[i][j] = 0;
			}
		}
		
		System.out.println(result);
	}

	private static void solution(int x, int y) {
		for(int i = 0; i<4; i++) {
			int sum = arr[x][y];
			for(int j = 0; j<4; j++) {
				if(j == i) continue;
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				// 범위 밖
				if(nx<0 || nx>=n || ny<0 || ny>=m) break;
				
				sum += arr[nx][ny];
			}
			result = Math.max(result, sum);
		}
	}

	private static void dfs(int x, int y, int cnt, int sum) {
		// 4칸 다 방문했을 경우
		if(cnt == 4) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=n || ny<0 || ny>=m) continue; // 범위 밖
			if(visited[nx][ny] == 1) continue; // 이미 지나옴
			
			// 이동 가능 지역 처리
			visited[nx][ny] = 1;
			dfs(nx, ny, cnt+1, sum+arr[nx][ny]);
			visited[nx][ny] = 0;
		}
	}
}
