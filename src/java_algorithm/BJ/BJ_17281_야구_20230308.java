package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17281_야구_20230308 {
	static int n;
	static int arr[][], visited[], numbers[];
	static int player4, score, answer;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][9];
		answer = 0;
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i[]:arr) {
			score = 0;
			list = new ArrayList<Integer>();
			visited = new int[8];
			numbers = new int[8];
			for(int j = 0; j<9; j++) {
				if(j == 0) {
					player4 = i[j];
					continue;
				}
				list.add(i[j]);
			}
			solution();
			answer += score;
		}
		System.out.println(answer);
		
	}
	private static void solution() {
		Collections.sort(list);
		for(int i = 0; i<8; i++) {
			if(list.get(0) == 0) {
				list.remove(0);
				list.add(0);
			}
		}
//		System.out.println(list);
		int sum = getScore();
//		System.out.println(sum);
		score = Math.max(score, sum);
	}
//	private static void solution(int cnt) {
//		if(cnt == 8) {
//			int sum = getScore();
//			score = Math.max(score, sum);
//			return;
//		}
//		
//		for(int i = 0; i<8; i++) {
//			if(visited[i] == 0) {
//				visited[i] = 1;
//				numbers[cnt] = list.get(i);
//				solution(cnt+1);
//				visited[i] = 0;
//			}
//		}
//	}
	static Queue<Integer> ru;
	private static int getScore() {
		int sum = 0;
		int out = 0;
		ru = new LinkedList<Integer>();
		ru.add(0);
		ru.add(0);
		ru.add(0);
		while(out < 3) {
			
			for(int i = 0; i<3; i++) {
				if(list.get(i) == 0) {
					out++;
					if(out == 3) return sum;
					continue;
				}
				sum = go(list.get(i),sum);
			}
			if(player4 == 0) {
				out++;
				if(out == 3) return sum;
			}
			else sum = go(player4,sum);
			
			for(int i = 3; i<8; i++) {
				if(list.get(i) == 0) {
					out++;
					if(out == 3) return sum;
				}
				sum = go(list.get(i),sum);
			}
		}
		return sum;
	}
	
	private static int go(int num, int sum) {
		if(num == 1) {
			int k = ru.poll();
			if(k == 1) sum++;
			ru.add(1);
		}
		
		else if(num == 2) {
			int k = ru.poll();
			if(k == 1) sum++;
			ru.add(1);
			k = ru.poll();
			if(k == 1) sum++;
			ru.add(0);
		}
		
		else if(num == 3) {
			int k = ru.poll();
			if(k == 1) sum++;
			ru.add(1);
			k = ru.poll();
			if(k == 1) sum++;
			ru.add(0);
			k = ru.poll();
			if(k == 1) sum++;
			ru.add(0);
		}
		
		else if(num == 4) {
			int k = ru.poll();
			if(k == 1) sum++;
			k = ru.poll();
			if(k == 1) sum++;
			k = ru.poll();
			if(k == 1) sum++;
			sum++;
			ru.add(0);
			ru.add(0);
			ru.add(0);
		}
		return sum;
	}
}
