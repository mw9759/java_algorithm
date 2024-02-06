package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2589_보물섬 {

	static int n,m;
	static char arr[][];
	static int min[][];
	static int answer;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		min = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
		}
        
		answer = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				char c = arr[i][j];
				if(c == 'L') {
					// 최소값 담을 배열 초기화
					min = new int[n][m];
					//fillMaxValue();
					// 최소값 구하기
					bfs(i, j);
					// 초소값 중 최대값 구하기
					int max = findMaxValue();
					// 최대값 검증 및 초기화
					answer = Math.max(answer, max);
				}
			}
		}
		System.out.println(answer);
		
	}

	// 최소값중 최대값 구하기
	public static int findMaxValue() {
		int findMax = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				findMax = Math.max(findMax, min[i][j]);
			}
		}
		return findMax;
	}
	
	// 배열 초기화
	public static void fillMaxValue() {
		// 최소경로값 담을 배열 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(min[i], -1);
        }
	}
	
	public static void bfs(int a, int b) {
		int visit[][] = new int[n][m];
		Queue<int[]> que = new ArrayDeque<int[]>();
		
		que.add(new int[] {a, b, 0});
		visit[a][b] = 1;
		
		while(!que.isEmpty()) {
			int data[] = que.poll();
			int x = data[0];
			int y = data[1];
			int t = data[2];
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue; // 범위를 벗어나거나
				if(visit[nx][ny] == 1 || arr[nx][ny] == 'W') continue; // 방문했던 곳 or 물가일 경우 
				visit[nx][ny] = 1;
				
				min[nx][ny] = t+1;
				//if(min[nx][ny] == -1) min[nx][ny] = t+1;
				//else min[nx][ny] = Math.min(min[nx][ny], t+1);
				que.add(new int[] {nx, ny, t+1});
			}
		}
	}

}
