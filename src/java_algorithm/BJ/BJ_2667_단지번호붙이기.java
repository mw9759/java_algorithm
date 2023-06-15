package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2667_단지번호붙이기 {

	static int n;
	static int arr[][];
	static int danji = 2;
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		//입력받기
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<n; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		// 단지 나누기
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j] == 1) {
					solution(i,j);
					danji++;
				}
			}
		}
		//단지별 집의수
		int cnt[] = new int[danji];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j]<2) continue;
				cnt[arr[i][j]]++;
			}
		}
		
		Arrays.sort(cnt);
		//출력
		System.out.println(danji-2);
		for(int i = 2; i<danji; i++) {
			System.out.println(cnt[i]);
		}
	}
	
	public static void solution(int x, int y) {
		if(arr[x][y] == 1) {
			arr[x][y] = danji;
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n || arr[nx][ny] != 1) continue;
				
				solution(nx, ny);
			}
		}
	}

}
