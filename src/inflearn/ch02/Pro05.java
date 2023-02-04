package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro05 {
	private static int solution(int n) {
		int answer = 0;
		int arr[] = new int[n+1];
		for(int i = 2; i<n+1; i++) {
			if(arr[i] == 0) {
				answer++;
				for(int j = i; j<n+1;j=j+i) arr[j] = 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(solution(N));
	}
}
