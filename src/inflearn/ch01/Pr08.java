package inflearn.ch01;

import java.util.Scanner;

public class Pr08 {
	public static String solution(String str) {
		String answer = "NO";
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp = new StringBuilder(str).reverse().toString();
		if(str.equals(tmp)) answer = "YES";
		/*
		String s = "";
		for(char ts : str.toCharArray()) {
			if(Character.isAlphabetic(ts)) {
				s += ts;
			}
		}
		String rs = new StringBuilder(s).reverse().toString();
		if(s.equalsIgnoreCase(rs)) return "YES";
		*/
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
	}

}
