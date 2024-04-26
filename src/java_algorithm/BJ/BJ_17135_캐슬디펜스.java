package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {

	static int n, m, d; 
	static int map[][], archer[];
	static int maxValue = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 맵의 새로 길이
		m = Integer.parseInt(st.nextToken()); // 맵의 가로 길이
		d = Integer.parseInt(st.nextToken()); // 궁수의 사거리
		map = new int[n][m]; // 초기 맵
		archer = new int[3]; // 궁수 조합
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setArcher(0, 0);
		
		System.out.println(maxValue);
	}

	private static void setArcher(int cnt, int start) {
		if(cnt == 3) {
			// 주어진 조합으로 디펜스
			maxValue = Math.max(maxValue, battle());
			return;
		}
		
		for(int i = start; i<m; i++) {
			archer[cnt] = i;
			setArcher(cnt+1, i+1);
		}
	}

	private static int battle() {
		int count = 0;
		int status[][] = new int[n][m];
		
		// 성 앞 라인이 line인 상황에서 사수가 arch일때 사거리가 leng일 경우
		for(int line = n; line>0; line--) {//현재 성앞 라인
			for(int arch : archer) { // 현재 사수
				for(int leng = 1; leng<=d; leng++) { // 현재 사거리.
					int result = canAttack(status, leng, line, arch);
					if(result == 1) { // 공격 가능: 다음 사수 검증.
						
						count++;
						break;
					}
					else if(result == 0) { // 공격한적 또공격
						
						break;
					}
				}
			}
		}
		return count;
	}

	private static int canAttack(int[][] status, int d, int line, int arch) {
		int archX = line;
		// 범위지정 2중for문 검증 ==> 각 위치는 매번 거리 검증해야함.
		for(int i = arch-d; i<=arch+d; i++) {
			for(int j = line-1; j>=line-1-d; j--) {
				if(i<0 || i>=m || j<0 || j>=n) continue;
				if(map[j][i] == 0) continue;
				if(Math.abs(i-arch)+Math.abs(j-line) != d) continue;
				if(status[j][i] == 0) {
					status[j][i] = line;
					return 1;
				}
				else if(status[j][i] == line) return 0;
			}
		}
		return -1;
		
		// x축을 d에 맞게 설정--> 세로축에 쓴 거리만큼 뺀 거리가 x축 위치가 됨.==>거리 검증 필요없음
//		int nn;
//	      for(int nm=arch-d;nm<=arch+d;nm++){
//	         nn = line-(d-Math.abs(nm-arch));
//	         if(nn<0 || nn >= line || nm <0 || nm >= m) continue;
//	         if(map[nn][nm]==0) continue;
//	         if(status[nn][nm] == 0){
//	            status[nn][nm] = line;
//	            return 1;
//	         }else if(status[nn][nm] == line) return 0;
//	      }
//	 
//	      return -1;
	}

}
