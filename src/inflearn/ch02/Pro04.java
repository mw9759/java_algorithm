package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro04 {
	//배열 사용
	private static int[] solution(int s) {
		int answer[] = new int[s];
		answer[0] = 1;
		answer[1] = 1;
		for(int i = 2; i < s; i++) {
			answer[i] = answer[i-1]+answer[i-2];
		}
		return answer;
	}
	
	//손코딩
	private static void solution1(int s) {
		int a = 1;
		int b = 1;
		System.out.print(a+ " "+b+" ");
		for(int i = 2; i < s; i++) {
			int c = a + b;
			System.out.print(c+" ");
			a = b;
			b = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		for(int i : solution(s))
			System.out.print(i+" ");
		System.out.println();
		solution1(s);
	}
}