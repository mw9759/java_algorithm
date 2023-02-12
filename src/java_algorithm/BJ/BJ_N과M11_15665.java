package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_N과M11_15665 {
	static int n,m; // 총 배열의 길이 n, 뽑아야할 수열의 길이m
	static int arr[]; //n개의 정수가 담길 배열
	static int in[]; //m개의 조합원이 담길 배열
	static StringBuilder sb = new StringBuilder(); //출력문 담을 스트링빌더.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //n값 초기화
		m = Integer.parseInt(st.nextToken()); //m값 초기화
		
		arr = new int[n]; //배열 n길이로 초기화
		in = new int[m]; //배열 m길이로 초기화
		
		//n개의 정수 담을 배열에 입력.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//오름차순으로 출력해야 하기 때문에 미리 정렬.
		Arrays.sort(arr);
		//메서드 호출
		solution(0); //in배열에 넣을 index변수, 반복문 시작 index
		//출력
		System.out.println(sb);
	}
	
	private static void solution(int cnt) {
		//만약 m만큼 배열이 찼다면
		//in에 들어있는 m개의 조합원 출력문에 추가.
		if(cnt == m) {
			for(int i: in) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		int last = 0;//직전에 담은 조합원 담을 변수
		for(int i = 0; i<n; i++) {
			if(last !=arr[i]) { //만약 직전 조합원이랑 다른 수이면
				last = arr[i];  //직전 조합원 현재 조합원 수로 초기화
				in[cnt] = arr[i]; // 현재 수 배열에 초기화
				solution(cnt+1); //다음 재귀.
			}
		}
	}

}
