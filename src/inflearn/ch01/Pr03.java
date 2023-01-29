package inflearn.ch01;

import java.util.Scanner;

public class Pr03 {
	public static String solution(String[] arr) {
		String answer = "";
		for(int i = 0; i < arr.length; i++) {
			if(answer.length()< arr[i].length()) {
				answer = arr[i];
			}
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String arr[] = str.split(" ");
		System.out.println(solution(arr));
	}

}
