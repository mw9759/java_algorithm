package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		
		System.out.println(sb);
	}
 
	// 상한 = 초과 -> 아래 끌어올리기
	static int upperBound(int arr[], int key) {
		int lo = 0;
		int hi = arr.length;
		
		// lo와 hi가 같아질 때까지 반복
		while(lo<hi) {
			int mid = (lo+hi)/2;
			
			// key가 mid 위치의 값보다 작다면
			if(key<arr[mid]) {
				hi = mid;
			}
			else {
				lo = mid+1;
			}
		}
		
		return lo;
	}
	
	// 하한 = 이상 -> 위 끌어내리기
	static int lowerBound(int arr[], int key) {
		int lo = 0;
		int hi = arr.length;
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			
			if(key<=arr[mid]) {
				hi = mid;
			}
			else {
				lo = mid+1;
			}
		}
		return lo;
	}

}
