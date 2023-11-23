package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2467_용액 {
	
	static int n; // 용액의 총 개수 
	static int arr[]; // 용액의 특성값 배열
	static int answer_x = 0, answer_y = 0, answer_min; // 용액 두개의 특성값, 특성값 최소 합
	public static void main(String[] args) throws Exception{
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer_min = Integer.MAX_VALUE; // 최소값 최대 int로 초기화
		int start = 0; // 투포인터 시작 좌표
		int finish = n-1; // 투포인터 끝 좌표
		
		while(start<finish) { // 시작 좌표가 끝 좌표보다 작을때만
			int sum = arr[start] + arr[finish]; // 좌표에 해당하는 용액 특성값의 합
			int abs_sum = Math.abs(sum); //특성값 합의 절대값
			if(sum == 0){ // 만약 합이 0 이면 두개의 용액 특성값을 담고 탈출 
				answer_x = arr[start]; 
				answer_y = arr[finish];
				break;
			}
			if(abs_sum <= answer_min) { // 절대값의 합이 최소값보다 작으면
				answer_min = abs_sum; // 최소값 초기화
				// 용액 두개의 특성값 담기.
				answer_x = arr[start]; 
				answer_y = arr[finish];
			}
			
			if(sum < 0) start += 1; // 만약 특성값의 합이 음수면 더 작은수를 줄여야 한다. 시작좌표값 증가.
			else finish -= 1; // 만약 양수면 더 큰 수를 줄여야 한다. 끝 좌표값 증가.
		}
		//출력.
		System.out.println(answer_x+" "+answer_y);
	}
}
