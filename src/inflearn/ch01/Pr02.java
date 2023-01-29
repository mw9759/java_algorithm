package inflearn.ch01;

import java.util.Scanner;

public class Pr02 {
	public String solution(String str) {
		String answer = "";
		for(char x : str.toCharArray()) {
			if(Character.isLowerCase(x)) {
				answer += Character.toUpperCase(x);
			} else {
				answer += Character.toLowerCase(x);
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Pr02 t = new Pr02();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(t.solution(str));
		
	}

}
