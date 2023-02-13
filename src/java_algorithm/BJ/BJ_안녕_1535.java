package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_안녕_1535 {
	
	static int n; // 사람수 선언
	static int hp[]; //체력 담을 배열
	static int happy[]; // 행복 담을 배열
	static boolean isSelected[]; // 부분집합을 꾸리는데 해당 요소가 쓰였는지 확인할 배열
	static int max_happy = 0; //최대 행복지수=>정답
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//초기화
		n = Integer.parseInt(br.readLine());
		hp = new int[n]; 
		happy = new int[n];
		isSelected = new boolean[n];
		//문자열 불러오기 and 해당 값 배열에 저장
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			hp[i] = Integer.parseInt(st1.nextToken());
			happy[i] = Integer.parseInt(st2.nextToken());
		}
		//메서드 호출
		solution(0);
		//정답 출력
		System.out.println(max_happy);
	}
	private static void solution(int cnt) {
		if(cnt == n) { // n번만큼 재귀가 돌면->부분집합이 완성되면
			int happyPoint = 0; // 해당 집합의 행복지수 누적합
			int deathPoint = 0;	// 해당 집합의 소모체력 누적합
			for(int i = 0; i<n; i++) {
				if(isSelected[i]) { // n번만큼 돌면서 해당 값이 true라면 => 부분집합에 포함된다면.
					happyPoint += happy[i]; // 누적합
					deathPoint += hp[i];	// 누적합
				}
			}
			//만약 총 소모 체력이 100이하라면(안죽는다면) 최대 행복지수 초기화. 
			if(deathPoint<100) max_happy = max_happy<=happyPoint ? happyPoint:max_happy;
			return;
		}
		
		isSelected[cnt] = true; // 해당 조합원을 사용함
		solution(cnt+1);		// 다음 인덱스로 재귀
		isSelected[cnt] = false;	// 해당 조합원을 안사용
		solution(cnt+1);			// 다음 인덱스로 재귀
	}

}
