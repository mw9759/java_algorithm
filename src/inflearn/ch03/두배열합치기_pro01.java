package inflearn.ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 두배열합치기_pro01 {
	static int n;
	static int arrN[];
	static int m;
	static int arrM[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arrN = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());
		arrM = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i : solution()) {
			System.out.print(i +" ");
		}
	}
	static List<Integer> solution() {
		List<Integer> answer = new ArrayList<>();
		int p1 = 0;
		int p2 = 0;
		while(p1<n && p2<m) {
			if(arrN[p1] < arrM[p2]) answer.add(arrN[p1++]);
			else answer.add(arrM[p2++]);
		}
		while(p1<n) answer.add(arrN[p1++]);
		while(p2<m) answer.add(arrM[p2++]);
		return answer;
	}
//	static int[] solution() {
//		int answer[] = new int[n+m];
//		for(int i = 0; i<n; i++) {
//			answer[i] = arrN[i];
//		}
//		
//		for(int i = 0; i<m; i++) {
//			answer[i+n] = arrM[i];
//		}
//		Arrays.sort(answer);
//		return answer;
//	}

}

