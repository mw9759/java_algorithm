package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro10 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+2][n+2];
		for(int i = 1; i< n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<n+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution(n,arr));
	}

	private static int solution1(int n, int[][] arr) {
		int answer = 0;
		for(int i = 1; i<n+1;i++) {
			for(int j = 1; j<n+1; j++){
				if(arr[i][j] > arr[i-1][j] && arr[i][j] > arr[i][j+1]
						&& arr[i][j] > arr[i+1][j] && arr[i][j] > arr[i][j-1])
					answer++;
			}
		}
		return answer;
	}
	private static int solution(int n, int[][] arr) {
		int answer = 0;
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		for(int i = 1; i<n+1;i++) {
			for(int j = 1; j<n+1; j++){
				boolean flag = true;
				for(int k = 0; k<4; k++) {
					if(arr[i+dx[k]][j+dy[k]]>= arr[i][j]) {
						flag = false;
						break;
					}
				}
				if(flag) answer++;
			}
		}
		return answer;
	}
	
	

}
