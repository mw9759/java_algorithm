package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pro12 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[m][n];
		for(int i = 0; i< m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution(n,m,arr));
	}

	private static int solution(int n, int m, int[][] arr) {
		int answer = 0;
		int arr1[][] = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j< n; j++) {
				int x = arr[i][j];
				arr1[i][x-1] = j+1;
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				boolean mento = true;
				boolean menti = true;
				for(int k = 0; k<m; k++) {
					if(arr1[k][i]>arr1[k][j]) {
						mento = false;
						break;
					}
				}
				for(int k = 0; k<m; k++) {
					if(arr1[k][i]<arr1[k][j]) {
						menti = false;
						break;
					}
				}
				if(mento || menti) answer++;
			}
		}
		return answer;
	}

}
