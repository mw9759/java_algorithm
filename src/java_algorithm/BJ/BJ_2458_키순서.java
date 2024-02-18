package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2458_키순서 {

	static int n, m;
	static List<Integer> listTall[];
	static List<Integer> listShort[];
	static int visit[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		listTall = new ArrayList[n+1];
		listShort = new ArrayList[n+1];
		visit = new int[n+1];
		
		for(int i = 0; i<=n; i++) {
			listTall[i] = new ArrayList<>();
			listShort[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			listTall[s].add(t);
			listShort[t].add(s);
		}
		
		int answer = 0;
		
		for(int i = 1; i<=n; i++) {
			visit = new int[n+1];
			int tallCnt = dfsTall(i)-1;
			visit = new int[n+1];
			int shortCnt = dfsShort(i)-1;
			if(tallCnt+shortCnt == n-1) answer++;
		}
		
		System.out.println(answer);
	}
	private static int dfsTall(int x) {

		visit[x] = 1;
		int ac = 1;
		for(int next : listTall[x]) {
			//System.out.println("x: "+x+" next: "+next);
			if(visit[next] == 1) continue;
			int c = dfsTall(next);
			ac += c;
		}
		return ac;
	}
	
	private static int dfsShort(int x) {
		visit[x] = 1;
		int ac = 1;
		for(int next : listShort[x]) {
			//System.out.println("x: "+x+" next: "+next);
			if(visit[next] == 1) continue;
			int c = dfsShort(next);
			ac += c;
		}
		return ac;
	}
}
