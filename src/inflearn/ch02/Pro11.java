package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro11 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][6];
		for(int i = 1; i<= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<6; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, int[][] arr) {
		int answer = 0;
		int count = 0;
		for(int i = 1; i <= n; i++) {
			int cnt = 0;
			for(int j = 1; j <= n; j++) {
				for(int k = 1; k<6; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if(cnt>count) {
				count = cnt;
				answer = i;
			}
		}
		return answer;
	}

}
