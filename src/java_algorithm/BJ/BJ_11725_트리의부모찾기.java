package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11725_트리의부모찾기 {

	static int n; // 노드 수
	static List<Integer>[] list; // 노드 인접관계 담을 배열
	static int[] visit; // 인접관계 체크 여부
	static int[] listParent; // 부모관계 담을 배열
	
	public static void main(String[] args) throws Exception{
		// 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		listParent = new int[n+1];
		visit = new int[n+1];

		// 배열 초기화
		for(int i = 0; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		// 입력받기
		for(int i = 1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[f].add(b);
			list[b].add(f);
		}
		// 함수호출 : 루트(1)으로 시작 -> 1의 자식 탐색-> 탐색한 자식의 자식 탐색 
		dfs(1);
		
		// 출력
		for(int i = 2; i<=n; i++) {
			System.out.println(listParent[i]);
		}
		
	}
	
	public static void dfs(int index) {
		visit[index] = 1; // 방문 처리
		for(int i : list[index]) { // 보유 자식 체크
			if(visit[i] == 0) { // 방문 기록 없으면
				listParent[i] = index; // 이 자식의 부모는 나다.
				dfs(i); // 자식의 자식 찾기 호출
			}
		}
	}
	
//	public static void dfs(int start, int now, int parent) {
//		if(now == 1) {
//			if(parent != 0) {
//				answer = parent;
//				listParent[start] = parent;
//			}
//			else answer =  1;
//			return;
//		}
//		
//		for(int i : list[now]) {
//			if(visit[i] == 1) continue;
//			
//			if(i == 1) {
//				dfs(start, 1, parent);
//				return;
//			}
//			else {
//				if(listParent[i] != 0) {
//					dfs(start, listParent[1], parent == 0 ? listParent[1]:parent);
//				}
//				visit[i] = 1;
//				dfs(start, i, parent == 0 ? i:parent);
//			}
//		}
//	}

}
