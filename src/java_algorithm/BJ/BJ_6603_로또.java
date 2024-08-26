package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.sound.midi.SysexMessage;

public class BJ_6603_로또 {
	
	
	static int k;
	static int arr[];
	static int numbers[];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0) break;
			
			arr = new int[k];
			for(int i = 0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			numbers = new int[k];
			
			solution(0,0);
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	private static void solution(int cnt, int start) {
		if(cnt == 6) {
			for(int i = 0; i<6; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<k; i++) {
			numbers[cnt] = arr[i];
			solution(cnt+1, i+1);
		}
	}

	

}
/*
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34 
0
 */
