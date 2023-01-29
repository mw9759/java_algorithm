package inflearn.ch01;

import java.util.Scanner;

public class Pr12 {
	public static String solution(int len, String str) {
		String answer = "";
		for(int i = 0; i < len; i++) {
			String tmp = str.substring(0,7).replace('#', '1').replace('*', '0');
			int num = Integer.parseInt(tmp, 2);
			str = str.substring(7);
			answer += (char)num;
			/*
			int sum = 0;
			for(int j = i*7, d = 6; j<i*7+7; j++) {
				if(str.charAt(j) == '#') sum += Math.pow(2, d--);
				else d--;
			}
			char a = (char)sum;
			answer+=a;
			*/
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		String str = sc.next();
		System.out.println(solution(c, str));
	}

}
