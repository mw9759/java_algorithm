package inflearn.ch01;

import java.util.Scanner;

public class Pr09 {
	public static int solution(String str) {
		/*
		int answer = 0;
		for(char x : str.toCharArray()) {
			if(x >= 48 && x<=57) answer = answer*10+(x-48);
		}
		return answer;
		*/
		
		String answer = "";
		for(char s : str.toCharArray()) {
			if(Character.isDigit(s)) {
				answer += s;
			}
		}
		return Integer.parseInt(answer);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
	}

}
