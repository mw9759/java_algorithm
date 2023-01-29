package inflearn.ch01;

import java.util.Scanner;

public class Pr01 {
	public int solution(String str, char c) {
		int answer = 0;
		str = str.toUpperCase();
		c = Character.toUpperCase(c);
		//System.out.println(str+c);
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Pr01 p = new Pr01();
		Scanner kb = new Scanner(System.in);
	    String str = kb.next();
	    char c = kb.next().charAt(0);
	    System.out.println(p.solution(str, c));
	}

}
