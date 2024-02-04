package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15810_풍선공장 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		
		long minTime = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			minTime = Math.min(arr[i], minTime);
		}
		
		long lo = 0;
		long hi = minTime*m;
		
		while(lo+1<hi) {
			long mid = (lo+hi)/2;
			int cnt = 0;
			for(int i = 0; i<n; i++) {
				cnt += mid/arr[i];
			}
			
			if(cnt<m) {
				lo = mid;
			}
			else {
				hi = mid;
			}
		}
		System.out.println(hi);
	}

}
