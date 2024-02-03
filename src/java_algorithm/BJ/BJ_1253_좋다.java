package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1253_좋다 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int zeroCnt = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		
		int answer = 0;
		
		for(int i = 0; i<n; i++) {
			
			int lo = 0;
			int hi = n-1;
			
			while(lo < hi) {
				
				int sum = arr[lo] + arr[hi];
				
				// good인 숫자 발견시
				if(sum == arr[i]) {
					if(i == lo) { // 자신이 lo 와 같다면 lo 올림
						lo++;
						continue;
					}
					else if(i == hi) { // 자신이 hi와 같다면 hi 올림
						hi--;
						continue;
					}
					else { // 이게 아니라면 good이다.
						answer++;
						break;
					}
				}
				
				// good이 아닐시
				// lo 올림
				if(sum < arr[i]) { 
					lo++;
				}
				// hi 내림
				else {
					hi--;
				}
				
			}
		}
		System.out.println(answer);
	}
}
// -10 -6 -5 -4 -1 0 4 9 10
