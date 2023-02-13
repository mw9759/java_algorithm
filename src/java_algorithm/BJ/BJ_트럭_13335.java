package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_트럭_13335 {

	static int n; //총 트럭 수
	static int w; //다리의 길이
	static int L; //다리의 최대 하중
	static int arr[]; //트럭의 무게들
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//멤버변수 초기화
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[n];
		//arr배열에 트럭 무게 입력.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solution();
	}

	private static void solution() {
		int lastcnt = 0; // 마지막으로 들어간 트럭 인덱스
		int time = 0;  //총 걸린시간
		int nowW = 0; //현재 다리위의 무게
		int many = 0; //현재 다리위의 트럭 개수
		for(int i = 0; i< w; i++) {
			q.add(0);
		}
		int idx = 0; //arr인덱스
		while(!q.isEmpty()) {
			if(idx<n) {
				if(nowW+arr[idx]-q.peek()<=L && many<=w) {
					nowW+=arr[idx];
					q.add(arr[idx++]);
					many++;
				}else {
					q.add(0);
				}
			}
			if(q.peek() != 0) many-=1;
			nowW -=q.poll();
			time++;
		}
		System.out.println(time);
	}
		
	

}

