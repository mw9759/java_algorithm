package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_1715_카드정렬하기 {

	static int n;
	static PriorityQueue<Integer> que;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		que = new PriorityQueue<>();
		
		for(int i = 0; i<n; i++) {
			que.add(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		while(!que.isEmpty()) {
			int sum = que.poll();
			
			if(que.isEmpty()) {
				break;
			}
			sum += que.poll();
			que.add(sum);
			answer += sum;
		}
		System.out.println(answer);
	}

}
