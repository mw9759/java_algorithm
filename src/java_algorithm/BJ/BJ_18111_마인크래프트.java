package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18111_마인크래프트 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n][m];
		
		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		int minTime = Integer.MAX_VALUE;
		int height = 0;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				minValue = Math.min(minValue, arr[i][j]);
				maxValue = Math.max(maxValue, arr[i][j]);
			}
		}
		
		for(int i = minValue; i<=maxValue; i++) {
			if(i > 256) break;
			int time = 0;
			int block = b;
			for(int j = 0; j<n; j++) {
				for(int k = 0; k<m; k++) {
					if(arr[j][k] < i) {
						time += i-arr[j][k];
						block -= i-arr[j][k];
					}
					else if(arr[j][k] > i) {
						time += 2*(arr[j][k]-i);
						block += arr[j][k]-i;
					}
				}
			}
			// 만약 블록이 -이면 평탄화 불가 높이
			if(block < 0) continue;
			//만약 최소시간이 같은 경우
			if(minTime == time) {
				// 높이를 비교해서 더 높은 땅을 출력
				height = height>i ? height:i;
			}
			// 다른경우 최소시간과 그 높이
			else {
				minTime = Integer.min(minTime, time);
				if(minTime == time) height = i;
			}
		}
		
		System.out.println(minTime+" "+height);
	}

}
