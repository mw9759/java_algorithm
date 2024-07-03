package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1477_휴게소세우기 {

	static int n, m, l;
	static int arr[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		arr = new int[n+2]; // 휴게소의 위치를 담을 배열 : 첫 휴게소와 마지막 휴게소의 위치간 거리를 알아야 하기 때문에 0과 l을 추가해야함.
		arr[0] = 0;
		arr[n+1] = l;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 이분탐색을 위한 오름차순 정렬
		
		int lo = 1; // 휴게소간 최소간격는 1
		int hi = l; // 휴게소간 최대간격는 l
		int answer = 0; // 조건을 만족할 때마다 정답 초기화 --> 최댓값의 최솟값을 구해야 하기 떄문에 최소값은 점점 작아지다 범위를 벗어날 예정.
		
		while(lo<=hi) {
			int mid = (lo+hi)/2; // 설치하고자 하는 간격
			int cnt = 0; // 현재 mid간격 기준 설치 가능한 휴게소 개수
			
			for(int i = 1; i<=n+1; i++) {
				int len = arr[i] - arr[i-1]; // 휴게소간 간격
				cnt += len/mid; // 현재 구간 len에서 mid간격으로 설치 가능한 개수만큼 추가.
				if(len%mid == 0) cnt--; // 나머지가 없다면 마지막 구간, 즉 이미 설치된 arr[i]에 대한 설치 가능이 카운팅 됬기에 다시 뺴줌.
			}
			
			// 설치할 휴게소보다 많이 설치 가능할 경우 lo를 증가해 간격을 올려줌.
			if(cnt > m) lo = mid+1;
			
			// 설치할 휴게소와 같거나 적을경우 hi를 줄여 간격을 줄여줌.
			else { 
				hi = mid-1;
				//answer초기화
				answer = mid;
			}
		}
		
		System.out.println(answer);
	}

}
