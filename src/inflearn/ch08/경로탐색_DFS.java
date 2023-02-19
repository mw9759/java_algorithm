package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 경로탐색_DFS {

	static int n;
	static int m;
	static int[][] arr;
	static int ch[];
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		ch = new int[n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] =1;
		}
		ch[1] = 1;
		solution(1);
		System.out.println(answer);
	}
	
	private static void solution(int cnt) {
		if(cnt == n) {
			answer++;
			return;
		}
		
		for(int i = 1; i<=n; i++) {
			if(arr[cnt][i] == 1 && ch[i] == 0) {
				ch[i] = 1;
				solution(i);
				ch[i] = 0;
			}
		}
	}

}
/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
 */
