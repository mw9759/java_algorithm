package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정_0313 {
	static int arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		//정렬 재정의-> 끝나는 시간기준 오름차순.->같다면 시작시간 오름차순
		//끝나는 시간이 빠르고 시작시간도 빠른순이기에 앞에서부터 조건에 맞는 회의시간을 하나씩 고를 수 있다. 1중 for문.
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});
		int answer = 0;
		int end_time = 0;
		for(int i = 0; i<n; i++) {
			
			if(end_time<=arr[i][0]) { // 앞의 회의가 끝나는 시간이 다음 회의의 시작시간과 같거나 크다면 조건 충족.
				end_time = arr[i][1];	// 회의의 끝나는 시간 최신화.
				answer++;	// 회의 개수 추가.
			}
		}
		System.out.println(answer);
	}

}
