package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14890_경사로 {

	static int n, l;
	static int map[][], runway[][]; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		for(int i = 0; i<n; i++) {
			
			int cnt = 1;
			boolean isDown = false;
			boolean canMove = true;
			for(int j = 0; j<n-1; j++) {
				
//				if(j == n-1) {
//					cnt++;
//					if(map[i][j] == map[i][j-1]) {
//						if(isDown) {
//							if(cnt==l) canMove = true;
//						}
//					}
//					else {
//						if(l == 1) canMove = true;
//						else canMove = false;
//					}
//					break;
//				}
				
				if(map[i][j] == map[i][j+1]) {
					cnt++;
					if(isDown) {
						if(cnt==l) {
							cnt = 0;
							isDown = false;
							canMove = true;
						}
					}
					continue;
				}
				
				// 더 커질경우
				if(map[i][j] < map[i][j+1]) {
					canMove = false;
					
					if(isDown) break;
					// 두칸이상 커졋다
					if(map[i][j+1] - map[i][j] > 1) break;
					
					if(cnt >= l) {
						cnt = 1;
						canMove = true;
						continue;
					}
					
					break;
				}
				
				// 더 작아질 경우
				if(map[i][j] > map[i][j+1]) {
					canMove = false;
					// 작아지는 중인데 다시 작아짐
					if(isDown) {
						canMove = false;
						break;
					}
					// 두칸이상 작아졋다
					if(map[i][j] - map[i][j+1] > 1) {
						canMove = false;
						break;
					}
					
					isDown = true;
					cnt=1;
					if(l == 1) {
						cnt = 0;
						canMove = true;
						isDown = false;
					}
				}
			}
			
			if(canMove) {
				//System.out.println(i);
				answer++;
			}
		}
		//System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		for(int j = 0; j<n; j++) {
			
			int cnt = 1;
			boolean isDown = false;
			boolean canMove = true;
			for(int i = 0; i<n-1; i++) {
//				if(i == n-1) {
//					if(map[i][j] == map[i-1][j]) {
//						cnt++;
//						if(isDown) {
//							if(cnt==l) canMove = true;
//						}
//					}
//					else {
//						if(l == 1) canMove = true;
//						else canMove = false;
//					}
//					break;
//				}
				if(map[i][j] == map[i+1][j]) {
					cnt++;
					if(isDown) {
						if(cnt==l) {
							cnt = 0;
							isDown = false;
							canMove = true;
						}
					}
					continue;
				}
				
				// 더 커질경우
				if(map[i][j] < map[i+1][j]) {
					canMove = false;
					
					if(isDown) break;
					// 두칸이상 커졋다
					if(map[i+1][j] - map[i][j] > 1) break;
					
					if(cnt >= l) {
						canMove = true;
						cnt = 1;
						continue;
					}
					
					break;
				}
				
				// 더 작아질 경우
				if(map[i][j] > map[i+1][j]) {
					canMove = false;
					// 작아지는 중인데 다시 작아짐
					if(isDown) {
						canMove = false;
						break;
					}
					// 두칸이상 작아졋다
					if(map[i][j] - map[i+1][j] > 1) {
						canMove = false;
						break;
					}
					
					isDown = true;
					cnt=1;
					if(l == 1) {
						cnt = 0;
						canMove = true;
						isDown = false;
					}
				}
			}
			
			if(canMove) {
				//System.out.println(j);
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	

}
