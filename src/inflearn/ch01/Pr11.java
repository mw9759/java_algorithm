package inflearn.ch01;

import java.util.Scanner;

public class Pr11 {
	public static String solution(String str) {
		String answer = "";
		str = str+ " ";
		int cnt = 1;
		for(int i = 0; i < str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				cnt++;
			}else {
				answer+=str.charAt(i);
				if(cnt>1) answer+=cnt;
				cnt = 1;
			}
		}
		return answer;
		/*
		String answer = "";
		char stack = ' ';
		int count = 1;
		for(char s : str.toCharArray()) {
			if(stack == ' ' || stack != s) {
				if(count>=2) {
					answer+=count;
					count = 1;
				}
				stack = s;
				answer+=s;
			} else {
				count++;
			}
		}
		if(count >= 2) answer += count;
		return answer;
		*/
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
	}

}
