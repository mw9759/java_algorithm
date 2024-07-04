package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3079_입국심사 {

	static long n,m;
	static long arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		arr = new long[(int) n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long lo = arr[0]; // 최저로 걸릴 수 있는 시간.
		long hi = arr[(int) (n-1)]*m; // 최대로 걸릴 수 있는 시간.
		long answer = 0;
		
		while(lo<=hi) {
			long mid = (lo+hi)/2;
			long cnt = 0;
			
			for(int i = 0; i<n; i++) {
				cnt += mid/arr[i];
				if(cnt>m) break;
			}
			
			if(cnt < m) lo = mid+1;
			else {
				hi = mid-1;
				answer = mid;
			}
		}
		
		System.out.println(answer);
	}

}
