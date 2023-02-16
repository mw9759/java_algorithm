package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_평범한배낭_12865 {

	static int n, limit; // 물건의 갯수와 가방의 무게제한.
	static int weight[],value[]; //물건의 무게와 가치를 담을 배열
	static int dp[][]; // n개의 물건을 담았을때 최대 가치를 저장할 배열. 정답은 dp[n][limit]에 있는 셈이다.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		weight = new int[n+1];
		value = new int[n+1];
		dp = new int[n+1][limit+1];
		
		//물건의 무게와 가치 초기화.
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp[][]구현: n개의 물건을 사용했을때 최대 가치 담기.
		for(int i = 1; i<=n; i++) {
			
			for(int j = 1; j<=limit; j++) {
				
				if(j-weight[i] >=0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}
				else dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[n][limit]);
	}

}
