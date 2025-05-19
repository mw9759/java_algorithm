package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11000_강의실배정 {

	static int n;
	static int arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// 시작 시간 기준 정렬
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
       
//		Arrays.sort(arr,(o1,o2)->{
////			if(o1[1] == o2[1]) {
////				return Integer.compare(o1[0], o2[0]);
////			}
//			return Integer.compare(o1[1], o2[0]);
//		});
//		14
//		25
//		36
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(arr[0][1]);
		
		for(int i = 1; i<n; i++) {
			if(arr[i][0] >= pq.peek()) {
				pq.poll();
			}
			pq.offer(arr[i][1]);
		}
		
		System.out.println(pq.size());
	}

}
