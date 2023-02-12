package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_N과M7_15656 {
	static int n; //n값 선언
	static int m; //m값 선언
	static int arr[]; //입력받은 n개의 정수 담을 배열
	static int in[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //초기화
		m = Integer.parseInt(st.nextToken()); //초기화
		arr= new int[n]; //초기화
		in = new int[m]; // 초기화
		
		st = new StringTokenizer(br.readLine()); // 새로 한줄 불러오기
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		solution(0);
		System.out.println(sb);
	}
	private static void solution(int cnt) {
		if( cnt == m ) {
			 for(int i: in) sb.append(i).append(" ");
			 sb.append("\n");
			 return;
		 }
		
		for(int i = 0; i<n; i++) {
			 in[cnt] = arr[i];
			 solution(cnt+1);
		 }
	}

}
