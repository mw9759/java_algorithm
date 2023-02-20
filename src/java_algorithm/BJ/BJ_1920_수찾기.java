package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기 {
	//풀이 1
//	static int arr[];
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		arr = new int[n];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 0; i<n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(arr);
//		int m = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		
//		for(int i = 0; i<m; i++) {
//			int start = 0;
//			int end = n-1;
//			int mid = 0;
//			int numberM = Integer.parseInt(st.nextToken());
//			int answer = 0;
//			while(start<=end) {
//				mid = (start+end)/2;
//				if(arr[mid] == numberM) {
//					answer = 1;
//					System.out.println(answer);
//					break;
//				}
//				else if(arr[mid]<numberM) start = mid+1;
//				else end = mid-1;
//			}
//			if(answer == 0) System.out.println(0);
//		}
//		
//	}
	//풀이2
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.parallelSort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			System.out.println(Arrays.binarySearch(arr, Integer.parseInt(st.nextToken()))<0 ? 0:1);
		}
	}
}
