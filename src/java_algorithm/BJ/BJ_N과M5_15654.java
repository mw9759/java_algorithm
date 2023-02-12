package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_N과M5_15654 {
	static int n; //n값 선언
	static int m; //m값 선언
	static int arr[]; //입력받은 n개의 정수 담을 배열
	static boolean visited[]; //기존 조합원이 포함 했나 확인. 포함했으면 패스.
	static int in[]; //m개의 정수 담을 배열
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //초기화
		m = Integer.parseInt(st.nextToken()); //초기화
		arr= new int[n]; //초기화
		visited= new boolean[n]; //초기화
		in= new int[m]; //초기화
		st = new StringTokenizer(br.readLine()); // 새로 한줄 불러오기
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); //사전순으로 출력해야 하기 때문에 미리 정렬.,
		
		solution(0); //메서드 호출
		System.out.println(sb); //출력
	}
	
	public static void solution(int cnt) {
		if(cnt == m) {
			for(int i : in) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		//순서는 의미있고, 조합안에 같은 조합원이 있으면 안된다.
		for(int i = 0; i<n; i++) {
			if(!visited[i]) {
				in[cnt] = arr[i]; // 조합에 조합원 추가 
				visited[i] = true; // 포함 했음을 표시
				solution(cnt +1); // 재귀호출
				visited[i] = false; // 다 돌고나서 해당 조합원 내보냐기
			}
		}
	}
}
