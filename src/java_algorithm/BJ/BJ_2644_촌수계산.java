package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2644_촌수계산 {

	static int n; // 총 인원수
	static int x, y; // 촌수관계를 구해야 할 대상
	static int m; // 관계의 개수
	static List<Integer> p[]; // 부모 관계
	static List<Integer> c[]; // 자식 관계
	static boolean flag = false; // 촌수유무
	static int visited[]; // 방문여부
	
	public static void main(String[] args) throws Exception{
		// 입력값 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		p = new ArrayList[n+1];
		c = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) {
			p[i] = new ArrayList<>();
			c[i] = new ArrayList<>();
		}
		
		visited = new int[n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// a의 부모 b 입력
			p[a].add(b);
			// b의 자식 a 입력
			c[b].add(a);
		}
		
		visited[x] = 1;
		solution(x, 0);
		
		if(!flag) System.out.println(-1);
	}
	
	public static void solution(int now, int cost) {
		if(now == y) {
			System.out.println(cost);
			flag = true;
			return;
		}
		
		// 부모 체크
		if(!p[now].isEmpty()) {
			for(int j : p[now]) {
				if(visited[j] == 1) continue;
				
				visited[j] = 1;
				solution(j, cost+1);
				visited[j] = 0;
			}
		}
		
		// 자식 체크
		if(!c[now].isEmpty()) {
			for(int j : c[now]) {
				if(visited[j] == 1) continue;
				
				visited[j] = 1;
				solution(j, cost+1);
				visited[j] = 0;
			}
		}
	}
}
