package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2473_세용액 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int answers[] = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		long minAbs = Long.MAX_VALUE;
		
		for(int i = 0; i<n; i++) { // 3개의 포인터를 돌리기엔 효율성이 없기에 하나를 고정.
			int lo = 0;
			int hi = n-1;
			
			int isZero = 0;
			
			while(lo < hi) {
				if(i == lo) { // 최소값이 고정된 값이랑 같다면 ++
					lo++;
					continue;
				}
				else if(i == hi) { // 최댓값이 고정된 값이랑 같다면 --
					hi--;
					continue;
				}
				// 자료형 맞춰줘야 정확한 값이 들어가기에 맞춰줘야함.
				long sum = (long)arr[i] + arr[lo] + arr[hi]; 
				
				// 합의 절댓값이 최소 절댓값보다 작거나 같으면 저장 및 초기화
				if(Math.abs(sum) <= minAbs) {
					minAbs = Math.abs(sum);
					answers[0] = arr[lo];
					answers[1] = arr[i];
					answers[2] = arr[hi];
				}
				// 0일땐 정답이기에 탈출
				if(sum == 0) {
					isZero = 1;
					break;
				}
				// 음수일 경우 최소값 ++
				else if(sum < 0) {
					lo++;
				}
				// 양수일 경우 최댓값 --
				else {
					hi--;
				}
			}
			
			if(isZero == 1) break;
		}
		
		Arrays.sort(answers);
		
		for(int i = 0; i<3; i++) {
			System.out.print(answers[i] + " ");
		}
	}

}
