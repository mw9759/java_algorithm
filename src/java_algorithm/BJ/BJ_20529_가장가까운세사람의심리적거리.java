package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20529_가장가까운세사람의심리적거리 {
	
	static int n;
	static char[][] mbti;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<tc; t++) {
			n = Integer.parseInt(br.readLine());
			int score = 0;
			mbti = new char[n][4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<n; i++) {
				mbti[i] = st.nextToken().toCharArray();
			}
			
			for(int i = 0; i<n; i++) {
				if(i == n-1) break;
				for(int j = i+1; j<n; j++) {
					score += check(i,j);
				}
			}
			System.out.println(score);
		}
		
	}
	
	private static int check(int f, int b) {
		int score = 0;
		for(int i = 0; i<4; i++) {
			if(mbti[f][i] != mbti[b][i]) {
				score+=1;
			}
		}
		return score;
	}

}
