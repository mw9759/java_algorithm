package inflearn.ch01;

import java.util.Scanner;

public class Pr04 {
	public static String solution(String str) {
		String answer = "";
		//for(int i = str.length()-1; i >=0; i--) {
		//	answer += str.charAt(i);
		//}
		String tmp = new StringBuilder(str).reverse().toString();
		answer = tmp;
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i = 0; i < tc; i++) {
			String str = sc.next();
			System.out.println(solution(str));
		}
	}

}
