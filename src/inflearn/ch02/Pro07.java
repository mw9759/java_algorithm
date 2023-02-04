package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro07 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, int[] arr) {
		int answer = 0;
		int stack = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] == 1) {
				stack++;
				answer += stack;
			}else {
				stack = 0;
			}
		}
		return answer;
	}

}
