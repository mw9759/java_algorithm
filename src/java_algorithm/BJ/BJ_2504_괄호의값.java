package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ_2504_괄호의값 {

	static ArrayList<Character> open = new ArrayList<>();
	static char[] str;
	static Stack<Character> stack = new Stack<>();
	static int answer = 0;
	static Stack<Integer> values = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();
		
		open.add('(');
		open.add('[');
		
		for(int i = 0; i<str.length; i++) {
			char c = str[i];
			// 여는 괄호 : 스택에 추가
			if(open.contains(c)) {
				stack.add(c);
			}
			
			// 닫는 괄호 : 직전 괄호 확인 및 점수산정
			else {
				//빈 스택일 경우
				if(stack.isEmpty()) {
					answer = 0;
					break;
				};
				int sum = 0;
				while(!stack.isEmpty()) {
					
					// 직전 괄호 '(' 와 짝
					if(stack.peek() == '(' && c == ')') {
						stack.pop();
						if(sum == 0) {
							stack.add('n');
							values.add(2);
						}
						else {
							sum *= 2;
							stack.add('n');
							values.add(sum);
							sum = 0;
						}
						
						break;
					}
					
					// 직전 괄호 '[' 와 짝
					else if(stack.peek() == '[' && c == ']') {
						stack.pop();
						if(sum == 0) {
							stack.add('n');
							values.add(3);
						}
						else {
							sum *= 3;
							stack.add('n');
							values.add(sum);
							sum = 0;
						}
							
						break;
					}
					
					// 숫자의 경우
					else if(stack.peek() == 'n'){
						stack.pop();
						sum += values.pop();
					}
					
					else {
						System.out.println(0);
						return;
					}
				}
				if(sum>0) {
					break;
				}
			}
			
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek() == 'n') {
				stack.pop();
				answer += values.pop();
			}
			else {
				answer = 0;
				break;
			}
		}
		System.out.println(answer);
	}
	
	

}
/**
 *
 *
 *   6561
 */