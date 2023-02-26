package 순조부테스트;

import java.util.Arrays;

/*
 * 중복이있는 순열뽑기
 * &&&
 * 중복이없는 순열뽁기
 */
public class 순열테스트 {
	
	static int arr[], count = 0, visited[];
	public static void main(String[] args) {
		int n = 5;
		arr = new int[n];
		visited = new int[n+1];
//		중복있는순열(0);
//		System.out.println("총 몇개? "+count);
		count = 0;
		중복없는순열(0);
		System.out.println("총 몇개? "+count);
	}
	private static void 중복있는순열(int cnt) {
		if(cnt ==5) {
			count++;
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = 1; i<=5; i++) {
			arr[cnt] = i;
			중복있는순열(cnt+1);
		}
	}
	
	private static void 중복없는순열(int cnt) {
		if(cnt ==5) {
			count++;
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = 1; i<=5; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				arr[cnt] = i;
				중복없는순열(cnt+1);
				visited[i] = 0;
			}
			
		}
	}
}
