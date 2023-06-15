package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {
	static int n, m;
	static int arr[][];
	static int virusPC[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1]; // pc별 연결정보 담을 배열
		virusPC = new int[n+1]; //바이러스 여부 담을 배열
		virusPC[1] = 1; //초기 바이러스 pc초기화 : 방문체크
		
		//입력
		m = Integer.parseInt(br.readLine()); //열결관계 수
		for(int i = 0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); //시작 pc
			int where = Integer.parseInt(st.nextToken());//도착 pc
			// 양방향 연결이기에 뒤집어서도 초기화 해준다.
			arr[from][where] = 1; 
			arr[where][from] = 1;
		}
		// 메서드 호출
		solution(1);
		// 출력변수 초기화
		int answer = 0;
		// 총 감염 pc 개수 구하기
		for(int i = 2; i<=n; i++) { // 1번pc는 이미 감염 되었음으로 2번pc부터 확인
			if(virusPC[i] == 1) answer++;
		}
		//출력
		System.out.println(answer);
	}
	private static void solution(int x) {
		if(virusPC[x] == 1) {// 만약 감염된 pc라면
			for(int i = 1; i<=n; i++) { //모든 pc검증
				if(arr[x][i] == 1 && virusPC[i] == 0) { // 해당 pc가 연결관계이고, 감염이 안된 pc라면
					virusPC[i] = 1; // 감염시키고
					solution(i);  // 감염시킨 pc가 다시 다른 pc에 감염을 시킴: 재귀호출
				}
			}
		}
	}

}
