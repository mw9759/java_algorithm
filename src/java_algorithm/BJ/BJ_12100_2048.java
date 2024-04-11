package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_12100_2048 {

	static int n;
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0, arr);
		System.out.println(answer);
		//for(int i = 0; i<n; i++) System.out.println(Arrays.toString(arr[i]));
		//int arr2[][] = move(3, arr);
		//System.out.println("-==============-===");
		//for(int i = 0; i<n; i++) System.out.println(Arrays.toString(arr[i]));
	} 
	private static void solution(int cnt, int[][] map) {
		if(cnt == 5) {
			findMax(map);
			return;
		}
		
		for(int i = 0; i<4; i++) {
			int[][] copyArray = new int[n][];
			for(int k = 0; k<n; k++) {
				copyArray[k] = map[k].clone();
			}
			int result[][] = move(i, copyArray);
			solution(cnt+1, result);
		}
	}
	
	private static int[][] move(int dir, int[][] map) {
		
		// 윗방향 처리
		if(dir == 0) {
			Stack<Integer> stack = new Stack<>();
			
			for(int i = 0; i<n; i++) {
				boolean canSum = true;
				for(int j = 0; j<n; j++) {
					if(map[j][i] == 0) continue;
					if(!stack.isEmpty() && stack.peek() == map[j][i] && canSum) {
						stack.add(stack.pop()+map[j][i]);
						canSum = false;
					}
					else {
						stack.add(map[j][i]);
						canSum = true;
					}
				}
				for(int j = 0; j<n; j++) {
					if(!stack.isEmpty()) {
						map[j][i] = stack.firstElement();
						stack.remove(0);
					}
					else map[j][i] = 0;
				}
				
				stack.clear();
			}
		}
		
		// 왼방향 처리
		if(dir == 1) {
			Stack<Integer> stack = new Stack<>();
			
			for(int i = 0; i<n; i++) {
				boolean canSum = true;
				for(int j = 0; j<n; j++) {
					if(map[i][j] == 0) continue;
					if(!stack.isEmpty() && stack.peek() == map[i][j] && canSum) {
						stack.add(stack.pop()+map[i][j]);
						canSum = false;
					}
					else {
						stack.add(map[i][j]);
						canSum = true;
					}
				}
				for(int j = 0; j<n; j++) {
					if(!stack.isEmpty()) {
						map[i][j] = stack.firstElement();
						stack.remove(0);
					}
					else map[i][j] = 0;
				}
				
				stack.clear();
			}
		}
		
		// 아래방향 처리
		if(dir == 2) {
			Stack<Integer> stack = new Stack<>();
			
			for(int i = n-1; i>=0; i--) {
				boolean canSum = true;
				for(int j = n-1; j>=0; j--) {
					if(map[j][i] == 0) continue;
					if(!stack.isEmpty() && stack.peek() == map[j][i] && canSum) {
						stack.add(stack.pop()+map[j][i]);
						canSum = false;
					}
					else {
						stack.add(map[j][i]);
						canSum = true;
					}
				}
				for(int j = n-1; j>=0; j--) {
					if(!stack.isEmpty()) {
						map[j][i] = stack.firstElement();
						stack.remove(0);
					}
					else map[j][i] = 0;
				}
				
				stack.clear();
			}
		}
		// 오른방향 처리
		if(dir == 3) {
			Stack<Integer> stack = new Stack<>();
			
			for(int i = n-1; i>=0; i--) {
				boolean canSum = true;
				for(int j = n-1; j>=0; j--) {
					if(map[i][j] == 0) continue;
					if(!stack.isEmpty() && stack.peek() == map[i][j] && canSum) {
						stack.add(stack.pop()+map[i][j]);
						canSum = false;
					}
					else {
						stack.add(map[i][j]);
						canSum = true;
					}
				}
				for(int j = n-1; j>=0; j--) {
					if(!stack.isEmpty()) {
						map[i][j] = stack.firstElement();
						stack.remove(0);
					}
					else map[i][j] = 0;
				}
				
				stack.clear();
			}
		}
		return map;
	}
	private static void findMax(int[][] map) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				answer = Math.max(answer, map[i][j]);
			}
		}
	}

}
