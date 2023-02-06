package java.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_색종이_10163 {
	
	static int N;
	static int[] ans;//색종이의 count 계산 자료 구조//ans[1] =>3의 의미는 1번 색종이가 3개 <= 빈도수 배열
	static int[][] map = new int[1001][1001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = new int[N+1];
		
		// N개의 색종이 좌표 구성이 주어진다.
		// 행 번호 기준으로 1부터 n개까지 색종이를 map에 표현
		for(int n = 1; n<= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int i = y; i< y+h; i++) {
				for(int j = x; j<x+w;j++) {
					map[i][j] = n;//색종이 번호 == 행의번호 == 0제외 1부터 
				}
			}
		}
		
		//빈도수 체크
		// 몇 번 색종이가 몇 번 나타나는지
		for(int i = 0; i < 1001; i++) {
			for(int j = 0; j < 1001; j++) {
				ans[ map[i][j] ]++; //색종이의 번호.//0번체크?
			}
		}
		
		//출력
		for(int i = 0; i<= N; i++) {
			System.out.println(ans[i]);
		}
	}

}
