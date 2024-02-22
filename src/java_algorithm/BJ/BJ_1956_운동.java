package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1956_운동 {

	static int v, e;
	static int arr[][], visit[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		arr = new int[v+1][v+1];
		visit = new int[v+1][v+1];
		
		for(int i = 0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			arr[start][finish] = len;
		}
		
		for(int k = 1; k<=v; k++) {
			for(int i = 1; i<=v; i++) {
				for(int j = 1; j<=v; j++) {
					if(arr[i][k] > 0 && arr[k][j] > 0) {
						if(arr[i][j] == 0) arr[i][j] = arr[i][k] + arr[k][j];
						else {
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
						}
					}
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = 1; i<=v; i++) {
			if(arr[i][i] == 0) continue;
			answer = Math.min(answer, arr[i][i]);
		}
		answer = answer == Integer.MAX_VALUE ? -1 : answer;
		System.out.println(answer);
	}

}
