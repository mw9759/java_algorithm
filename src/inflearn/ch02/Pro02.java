package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro02 {
	public static int solution(int n, int[] arr) {
		int answer = 0;
		int maxHeight = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i]>maxHeight) {
				answer++;
				maxHeight = arr[i];
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(n, arr));
	}

}
