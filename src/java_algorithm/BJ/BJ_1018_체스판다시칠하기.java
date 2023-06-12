package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018_체스판다시칠하기 {
	
	static int n,m;
	static char map[][];
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i<=n-8; i++) {
			for(int j = 0; j<=m-8; j++) {
				solution(i,j);
				
			}
		}
		
		System.out.println(answer);
	}
	
	static void solution(int x, int y) {
		int changeCnt = 0;
		char color = 'W';
		
		for(int i = x; i<x+8; i++) {
			
			for(int j = y; j<y+8; j++) {
				if(map[i][j] != color) {
					changeCnt++;
				}
				
				color = color == 'W' ? 'B':'W';
			}
			color = color == 'W' ? 'B':'W';
		}
		
		changeCnt = Math.min(changeCnt, 64-changeCnt);
		answer = Math.min(answer, changeCnt);
	}
}
