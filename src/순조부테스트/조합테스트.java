package 순조부테스트;

import java.util.Arrays;

/*
 * 중복이있는 조합뽑기
 * &&&
 * 중복이없는 조합뽁기
 * 12345 중에 3개 뽑기
 */
public class 조합테스트 {
	static int arr[], count = 0;
	public static void main(String[] args) {
		int n = 5;
		arr = new int[3];
		중복있는조합(0,1);
		System.out.println("총 개수? "+count);
		count = 0;
		중복없는조합(0,1);
		System.out.println("총 개수? "+count);
	}
	private static void 중복있는조합(int cnt, int start) {
		if(cnt == 3) {
			count++;
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = start; i<=2; i++) {
			arr[cnt] = i;
			중복있는조합(cnt+1, i);
		}
	}
	
	private static void 중복없는조합(int cnt, int start) {
		if(cnt == 3) {
			count++;
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = start; i<=5; i++) {
			arr[cnt] = i;
			중복없는조합(cnt+1, i+1);
		}
	}

}
