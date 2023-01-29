package inflearn.ch01;

import java.util.Scanner;

public class Pr10 {
	public static int[] solution(String str, char c) {
		int arr[] = new int[str.length()];
		int d = 101;
		for(int i = 0; i < arr.length; i++) {
			if(str.charAt(i) == c) {
				d = 0;
				arr[i] = d;
			}else {
				d++;
				arr[i] = d;
			}
		}
		
		d = 101;
		for(int i = arr.length-1; i>=0; i--) {
			if(str.charAt(i) == c) {
				d = 0;
				arr[i] = d;
			}else {
				d++;
				if(arr[i]>d)
					arr[i] = d;
			}
		}
		
		return arr;
		/*for(int i = 0; i < str.length(); i++) {
			int count_min = 100;
			if(!(str.charAt(i)==c.charAt(0))) {
				int count_r = 0;
				for(int j = i+1; j < str.length(); j++) {
					count_r++;
					if(str.charAt(j)==c.charAt(0)) {
						count_min = Math.min(count_r, count_min);
					}
				}
				
				int count_l = 0;
				for(int k = i-1; k>=0; k--) {
					count_l++;
					if(str.charAt(k)==c.charAt(0)) {
						count_min = Math.min(count_l, count_min);
					}
				}
				
				System.out.print(count_min+ " ");
			}else {
				System.out.print(0+ " ");
			}
		}
		*/
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = sc.next().charAt(0);
		for(int x : solution(str, c)) {
			System.out.print(x+ " ");
		}
		
	}

}
