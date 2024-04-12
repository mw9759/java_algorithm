package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15684_사다리조작 {

	static int n, m, h;
	static int arr[][];
	static int answer = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h+1][n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arr[from][to] = to+1;
			arr[from][to+1] = to;
		}
		
		for(int i = 0; i<4; i++) {
			addLine(0, i);
			if(answer != -1) break;
		}
		System.out.println(answer);
	}
	
	public static void addLine(int cnt, int goal) {
		if(cnt == goal) {
			if(check()) {
				answer = cnt;
			}
			return;
		}
		
		for(int i = 1; i<n; i++) {
			for(int j = 1; j<=h; j++) {
				//추가 가능한 상황인지
				if(arr[j][i] != 0) continue; // 본인: 연결상태
				if(arr[j][i+1] != 0) continue; // 우측 이미 연결상태
				
				arr[j][i] = i+1;
				arr[j][i+1] = i;
				
				addLine(cnt+1, goal);
				
				arr[j][i] = 0;
				arr[j][i+1] = 0;
			}
		}
	}
	
	public static boolean check() {
		boolean flag = true;
		
		for(int i = 1; i<n+1; i++) {
			int depth = 1;
			int now = i;
			
			while(depth != h) {
				
				if(arr[depth][now] == 0) {
					depth++;
				
					continue;
				}
				now = arr[depth][now];
				depth++;
				
			}
			if(arr[depth][now] != 0) now = arr[depth][now];
			flag = i==now;
			if(!flag) return false;
		}
		return flag;
	}
}
