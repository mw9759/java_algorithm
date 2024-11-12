package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_2251_물통 {

	static int visited[][][];
	static int mount[];
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		mount = new int[3];
		for(int i = 0; i<3; i++) mount[i] = Integer.parseInt(st.nextToken());
		
		visited = new int[mount[0]+1][mount[1]+1][mount[2]+1];
		
		dfs(0, 0, mount[2]);
		
		ArrayList<Integer> answer = new ArrayList<>(set);
		
		Collections.sort(answer);
		
		for(int i = 0; i<answer.size(); i++) {
			if(i == answer.size()-1) {
				System.out.print(answer.get(i));
				break;
			}
			System.out.print(answer.get(i) + " ");
		}
	}
	private static void dfs(int a, int b, int c) {
		if(visited[a][b][c] == 1) {
			return;
		}
		
		visited[a][b][c] = 1;
		if(a == 0) {
			set.add(c);
		}
		
		// a->b
		int can1 = mount[1] - b;
		if(a <= can1) dfs(0, a+b, c);
		else dfs(a-can1, can1+b, c);
		
		// a<-b
		int can2 = mount[0] -a;
		if(b <= can2) dfs(a+b, 0, c);
		else dfs(a+can2, b-can2, c);
		
		// b->c
		int can3 = mount[2] - c;
		if(b <= can3) dfs(a, 0, b+c);
		else dfs(a, b-can3, c+can3);
		
		// b<-c
		int can4 = mount[1] - b;
		if(c <= can4) dfs(a, b+c, 0);
		else dfs(a, b+can4, c-can4);
		
		// a->c
		int can5 = mount[2] - c;
		if(a <= can5) dfs(0, b, a+c);
		else dfs(a-can5, b, c+can5);
		
		// a<-c
		int can6 = mount[0] - a;
		if(c <= can6) dfs(a+c, b, 0);
		else dfs(a+can6, b, c-can6);
	}

}
