package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {
	
	static int n, m, ungrow = 0;
	static int[][] tomato;
	static Queue<Integer> que = new LinkedList<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		tomato = new int[n+1][m+1];
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=m; j++) {
				int a = Integer.parseInt(st.nextToken());
				tomato[i][j] = a;
				if(a == 1) {
					que.add(i); // 세로축 인덱스
					que.add(j);	// 가로축 인덱스
				}
				else if(a == 0) ungrow++;
			}
		}
		solution();
		if(ungrow != 0) day = -1;
		System.out.println(day);
	}
	static int day = 0;
	private static void solution() {
		while(!que.isEmpty()) {
			if(ungrow == 0) return; // 토마토 전부 익음.
			int cnt = que.size()/2;// 해당일에 1인 애들 모두 써야하기에 세로가로인덱스 뽑는 횟수
			for(int i = 0; i<cnt; i++) {
				int a = que.poll();
				int b = que.poll();
				if(tomato[a][b] == 1) { 
					//상부
					if(a>1 && tomato[a-1][b] == 0) {
						tomato[a-1][b] = 1; // 인접 안익은 토바토 익게 만듬
						ungrow--; // 안익은 토마토 개수 줄이기
						que.add(a-1);
						que.add(b);
					}
					//하부
					if(a<n && tomato[a+1][b] == 0) {
						tomato[a+1][b] = 1;
						ungrow--;
						que.add(a+1);
						que.add(b);
					}
					//좌측
					if(b>1 && tomato[a][b-1] == 0) {
						tomato[a][b-1] =1;
						ungrow--;
						que.add(a);
						que.add(b-1);
					}
					//우측
					if(b<m && tomato[a][b+1] == 0) {
						tomato[a][b+1] =1;
						ungrow--;
						que.add(a);
						que.add(b+1);
					}
				}
			}
			day++;
		}
	}
	

}
