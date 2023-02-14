package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_쉬운계단수_10844 {
	static int n;
	static long mod = 1000000000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		//solution();
		long arr[][] = new long[n+1][10];
		
		//첫번째 자리수 먼저 넣기
		for(int i = 1; i<10; i++) {
			arr[1][i] = 1;
		}
		
		//두번째 자리수부터 끝까지
		for(int i = 2; i<=n; i++) {
			
			for(int j = 0; j<10; j++) {
				if(j == 0) {//0이면 1만 이전에 올수 있음.
					arr[i][0] = arr[i-1][1] %mod;
				}
				//9이면 이전수는 8뿐이다.
				else if(j == 9) arr[i][9] = arr[i-1][8]%mod;
				
				else {
					arr[i][j] = (arr[i-1][j-1]+arr[i-1][j+1])%mod;
				}
			}
		}
		
		// 각 자릿값마다의 경우의 수를 모두 더해준다. 
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += arr[n][i];
		}
				
		System.out.println(result % mod);
	}
}
