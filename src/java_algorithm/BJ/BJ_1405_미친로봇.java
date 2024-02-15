package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1405_미친로봇 {
	
	static int n;
	static double answer;
	static int arr[][], visit[][], dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};
	static double rate[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[30][30];
		visit = new int[30][30];
		answer = 0;
		rate = new double[4];
		
		for(int i = 0; i<4; i++) {
			rate[i] = Double.parseDouble(st.nextToken()) * 0.01;
		}
		
		visit[15][15] = 1;
		dfs(15, 15, 0, 1);

		System.out.println(answer);
	}
	private static void dfs(int x, int y, int cnt, double result) {
		if(cnt == n) {
			answer += result;
			return;
		}
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(visit[nx][ny] == 0) {
				visit[nx][ny] = 1;
				dfs(nx, ny, cnt+1, result*rate[i]);
				visit[nx][ny] = 0;
			}
		}
	}

}
