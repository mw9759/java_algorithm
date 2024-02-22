package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1613_역사 {

	static int n, k, s;
	static int arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		
		for(int i = 0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[l][h] = -1;
			arr[h][l] = 1;
		}
		
		for(int m = 1; m<=n; m++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					// ik: -1(i->k)  kj: -1(k->j) ==> i->j 
					if(arr[i][m] == -1 && arr[m][j] == -1) {
						arr[i][j] = -1;
						arr[j][i] = 1;
					}
					// ik: 1(i<-k) kj: 1(k<-j) ==> i<-j
					else if(arr[i][m] == 1 && arr[m][j] == 1) {
						arr[i][j] = 1;
						arr[j][i] = -1;
					}
				}
			}
		}
		
		s = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<s; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			sb.append(arr[l][h]).append("\n");
		}
		System.out.println(sb);
	}

}
