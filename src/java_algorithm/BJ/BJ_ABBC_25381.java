package java_algorithm.BJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_ABBC_25381 {

	static String s; //문자열 담을 변수
	static Queue<Integer> aQ = new LinkedList<Integer>(); //A가 올때 해당 인덱스 담을 스택
	static Queue<Integer> bQ = new LinkedList<Integer>(); //B가 올때 해당 인덱스 담을 스택
	static int count; // 총 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		
		solution(); //메서드 호출
		System.out.println(count); //출력
	}

	private static void solution() {
		//문자열의 길이만큼 반복하며 
		for(int i  = 0; i < s.length(); i++) { 
			if(s.charAt(i) == 'A') aQ.add(i); // A이면 A큐에 인덱스 담기
			else if(s.charAt(i) == 'B') bQ.add(i); // B이면 B큐에 인덱스 담기
			else { 								// C일때
				if(!bQ.isEmpty()&&i>bQ.peek()) { // B큐가 비어있지 않고, B가 C보다 앞에 있다면(인덱스비교)
					count++; //카운트 ++
					bQ.remove(); // B큐의 맨앞 삭제 =? C랑 조합되었기 때문.
				}
			}
		}
		
		while(!aQ.isEmpty() && !bQ.isEmpty()) { // A큐와 B큐 모두 비어있지 않다면 계속 반복=> 하나라도 비면 탈출
			if(aQ.peek() < bQ.peek()) {  // 인덱스 비교 A가 B보다 앞에있다면
				count++; 				//카운트++
				aQ.remove();			//A큐 맨앞 삭제
				bQ.remove();			//B큐 맨앞 삭제
			} else {
				bQ.remove();			//B큐가 A큐보다 앞에있으므로 B큐만 삭제=>이제 쓸일이 없다.
			}
		}
	}
}
