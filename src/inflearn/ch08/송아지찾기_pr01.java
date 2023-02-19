package inflearn.ch08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기_pr01 {
	
	static int man;// 사람 위치
	static int cow;// 송아지 위치
	static int visited[] = new int[10001];
	static Queue<Integer> qu = new LinkedList<Integer>(); 
	static int arr[] = {1,-1,5};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		man = sc.nextInt();
		cow = sc.nextInt();
		
		System.out.println(solution());
		
	}

	private static int solution() {
		int answer = 0;
		visited[man] = 1;
		qu.add(man);
		
		while(!qu.isEmpty()) {
			int len = qu.size();
			for(int i = 0; i<len; i++) {
				int x = qu.poll();
				for(int j = 0; j<3; j++) {
					int xn = x + arr[j];
					if(xn>=1 && xn<=10001 && visited[xn]==0) {
						if(xn == cow) return answer +1;
						qu.add(xn);
						visited[xn] = 1;
					}
				}
			}
			answer++;
		}
		
		return answer;
	}

}
