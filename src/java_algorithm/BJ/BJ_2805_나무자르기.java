package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805_나무자르기 {

	static int n,m;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		int min = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		//Arrays.sort(arr);
		// 이분 탐색 (upper bound)
		
		while(min<max) {
			int mid = (min+max)/2;
			long sum = 0;
			for(int i = 0; i<n; i++) {
				if(arr[i]-mid>0) sum += arr[i]-mid;
			}
			
			if(sum < m) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
	}
}
