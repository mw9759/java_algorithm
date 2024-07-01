package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치 {
	
	static int n, m;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		// 거리를 기준으로 이분탐색.--> 거리가 2일떄 설치 개수, 거리가 3일때 설치 개수 등
		
		int lo = 1; // 최소거리
		int hi = arr[n-1] - arr[0]+1;// 최대거리 : 마지막 집 위치와 첫 집의 위치간 거리 차이
		// --> +1을 하는 이유는 거리 차이가 홀수인 경우 (lo+hi)/2 과정에서 손실이 일어날 수 있기에 +1을 해줘서 범위를 보장해준다.
		
		while(lo<hi) {
			
			int mid = (lo+hi)/2;
			
			
			if(canSet(mid) < m) { 
				/**
				 * mid거리만큼 설치한다면 m개 미만으로 설치.
				 * --> hi를 줄여서 거리를 줄여야 함.
				 */
				hi = mid;
			}
			
			else {
				/**
				 * m보다 크거나 같다면 최소값을 찾아야 함.
				 * --> lo를 키워야 함.
				 */
				lo = mid+1;
			}
		
		}
		
		/**
		 * upper bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로 
		 * 1을 빼준 값이 조건을 만족하는 최댓값이 된다.
		 * lo<hi가 탈출 조건이기에 lo값은 쓸 수 없는 값이다. 그렇기에 -1을 해줘야 한다.
		 */
		System.out.println(lo-1);
	}
	private static int canSet(int mid) {
		// 첫 번 째 집은 설치한다
		int cnt = 1;
		int lastHouse = arr[0];
		
		for(int i = 1; i<n; i++) {
			/**
			 * 현재 집의 위치와 직전에 설치했던 집의 위치간 거리가
			 * 최소거리mid보다 크거나 같을때 공유기 설치 개수++
			 * lastHouse갱신.
			 */
			if(arr[i] - lastHouse >= mid) {
				cnt++;
				lastHouse = arr[i];
			}
		}
		return cnt;
	}
}
