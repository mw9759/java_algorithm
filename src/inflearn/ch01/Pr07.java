package inflearn.ch01;

import java.util.Scanner;

public class Pr07 {
	public static String solution(String str) {
		String answer = "";
		str = str.toUpperCase();
		int lt = 0;
		int rt = str.length()-1;
		while(lt<rt) {
			if(str.charAt(lt) != str.charAt(rt)) {
				answer = "NO";
				break;
			}
			answer = "YES";
			lt++;
			rt--;
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
	}

}
