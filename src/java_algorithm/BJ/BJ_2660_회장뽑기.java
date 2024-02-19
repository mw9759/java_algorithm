package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2660_회장뽑기 {

	static int n, arr[][], maxVal[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 회원 수
		arr = new int[n+1][n+1]; // 회원간 친구관계 담을 배열
		maxVal = new int[n+1]; // 각 회원의 점수를 담을 배열 : 최고 점수가 본인의 점수
		
		int INF = 51; // 최댓값 설정. 회원수 최대 50 이기에 51로 설정
		
		// 초기값 설정 : 본인을 제외한 모든 관계에 최고점 설정.
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if (i != j) {
                    arr[i][j] = INF;
                }
			}
		}
		// 입력 처리
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(s == -1 && e == -1) break;
			
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		// 플로이드 워셜
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j]) {// i와 j가 직접 친구가 아니라면
						arr[i][j] = arr[i][k] + arr[k][j]; // 만약 i,k의 값이 있고, k,j값이 있다면 건너건너 친구인 값이 들어감. 
					}
				}
			}
		}
		//출력처리
		int min = INF; // 회장이 될 수 있는 최소 점수
		int cnt = 0; // 후보 수 
		for(int i = 1; i<=n; i++) {
			int score = 0; // 나의 점수
			for(int j = 1; j<=n; j++) {
				if(arr[i][j] != INF) {
					score = Math.max(score, arr[i][j]); // 최댓값이 나의 점수 : 건너건너 아는 친구의 징검다리가 많을때
				}
			}
			maxVal[i] = score; // 값 담아두기.
			min = Math.min(min, score); // 회장이 될 수 있는 최소점수 초기화
		}
		
		List<Integer> list = new ArrayList<Integer>(); // 후보 담을 배열
		
		for(int i = 1; i<=n; i++) {
			if(maxVal[i] == min) { // 각 회원의 점수가 회장 조건의 점수면
				cnt++; // 후보수 ++
				list.add(i); // 후보 담기.
			}
		}
		
		System.out.println(min+" "+cnt); // 조건과 후보 수 출력
		// 후보 출력
		for(int i : list) {
			System.out.print(i+" ");
		}
	}
}
