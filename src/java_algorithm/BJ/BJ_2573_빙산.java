package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {

	static int n, m, arr[][], visited[][];
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static List<int[]> list;
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
				int l = Integer.parseInt(st.nextToken());
				arr[i][j] = l;
			}
		}
		
		boolean isSeparate = false;
		int answer = 0;
		while(!isSeparate) {
			// 빙산의 개수
			int bingCnt = 0;
			// 녹을 예정인 빙산들 초기화
		    list = new ArrayList<>();
			// 1년치 빙산 녹음
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(arr[i][j] != 0) {
						findMelting(i, j);
					}
					if(arr[i][j]>0) bingCnt++;
				}
			}
			
			// 예정 빙산 높이 차감.
			for(int[] b : list) {
				if(arr[b[0]][b[1]]>0) arr[b[0]][b[1]]--;
			}
			
			// 분리 여부 확인
			int cnt = 0;
			visited = new int[n][m];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					// 해당 지역이 빙산이고 첫방문이면 여부 확인 조건.
					if(arr[i][j] != 0 && visited[i][j] == 0) {
						checkSep(i, j);
						cnt++;
					}
				}
			}
			answer++;
			if(cnt>1) isSeparate = true;
			else if(bingCnt == 0) {
				answer = 0;
				break;
			}
		}
		
		System.out.println(answer);
	}

	private static void findMelting(int x, int y) {
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 바다체크
			if(arr[nx][ny] != 0) continue;
			// 바다라면 해당지역 저장. 복수 가능.
			list.add(new int[] {x, y});
		}		
	}

	private static boolean checkSep(int a, int b) {
		Queue<int[]> que = new ArrayDeque<int[]>();
		visited[a][b] = 1;
		que.add(new int[] {a, b});
		
		while(!que.isEmpty()) {
			int[] xy = que.poll();
			int x = xy[0];
			int y = xy[1];
			
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 범위체크
				if(nx<0 || nx>=n || ny <0 || ny>=m)continue;
				// 빙산인지
				if(arr[nx][ny] == 0) continue;
				// 방문했던 곳인지
				if(visited[nx][ny] == 1) continue;
				visited[nx][ny] = 1;
				que.add(new int[] {nx, ny});
			}
		}
		return false;
	}

}
