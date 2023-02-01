package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro03 {
	public static void solution(int n, int[] arrA, int[] arrB) {
		for(int i = 0; i < n; i++) {
			if(arrA[i] == arrB[i]) 
				System.out.println("D");
			else if(arrA[i] == 1 && arrB[i] == 3) 
				System.out.println("A");
			else if(arrA[i] == 2 && arrB[i] == 1) 
				System.out.println("A");
			else if(arrA[i] == 3 && arrB[i] == 2) 
				System.out.println("A");
			else
				System.out.println("B");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int arrA[] = new int[n];
		int arrB[] = new int[n];
		for(int i = 0; i < n; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
			arrB[i] = Integer.parseInt(st1.nextToken());
		}
		solution(n, arrA, arrB);
	}

}
