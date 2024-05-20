package 순조부테스트;

import java.util.Arrays;

/*
 * 부분집합 구하기
 * 5까지의 부분집합들 출력 및 개수 출력
 */
public class 부분집합 {
	static boolean visited[];
	static int count = 0;
	public static void main(String[] args) {
		int n = 5;
		visited = new boolean[n];
		부분집합연습(0);
		System.out.println("총 개수는? "+count);
	}
	
	private static void 부분집합연습(int cnt) {
		if(cnt == 5) {
			count++;
			for(int i = 0; i<5; i++) {
				if(visited[i] == true) {
					System.out.print(i+1);
					System.out.print(" ");
				}
			}
			System.out.println();
			return;
		}
		visited[cnt] = true;
		부분집합연습(cnt+1);
		visited[cnt] = false;
		부분집합연습(cnt+1);
		
	}
}
