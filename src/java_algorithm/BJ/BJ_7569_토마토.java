package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_7569_토마토 {
	static class Tomato{
		int h;
		int l;
		int w;
		int day;
		
		public Tomato(int h, int l, int w, int day) {
			this.h = h;
			this.l = l;
			this.w = w;
			this.day = day;
		}
	}
	static int w, l, h;
	static int tmt[][][], visit[][][];
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		tmt = new int[h][l][w];
		visit = new int[h][l][w];
		
		ArrayDeque<Tomato> que = new ArrayDeque<>();
		int left = 0;
		for(int i = 0; i <h; i++) {
			for(int j = 0; j<l; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k<w; k++) {
					int val = Integer.parseInt(st.nextToken());
					if(val == 1) {
						que.add(new Tomato(i, j, k, 0));
						visit[i][j][k] = 1;
					}
					if(val == 0) left++;
					tmt[i][j][k] = val;
				}
			}
		}
		int answer = 0;
		while(!que.isEmpty()) {
			Tomato t= que.poll();
			
			if(tmt[t.h][t.l][t.w] == -1) {
				continue;
			}
			answer = t.day;
			// 4방
			for(int i = 0; i<4; i++) {
				int nx = t.l+dx[i];
				int ny = t.w+dy[i];
				
				if(nx<0 || ny<0 || nx>= l || ny>= w) continue;
				
				if(tmt[t.h][nx][ny] == 0) {
					tmt[t.h][nx][ny] = 1;
					que.add(new Tomato(t.h, nx, ny, t.day+1));
					left--;
				}
			}
			
			// 위
			int up = t.h+1;
			if(up < h && tmt[up][t.l][t.w] == 0) {
				tmt[up][t.l][t.w] = 1;
				que.add(new Tomato(up, t.l, t.w, t.day+1));
				left--;
			}
			
			// 아래
			int down = t.h-1;
			if(down >= 0 && tmt[down][t.l][t.w] == 0) {
				tmt[down][t.l][t.w] = 1;
				que.add(new Tomato(down, t.l, t.w, t.day+1));
				left--;
			}
		}
		
		System.out.println(left == 0 ? answer:-1);
		
	}

}
