package inflearn.ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 공통원소구하기_pro02 {
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
		Arrays.sort(arrN);
		
		m = Integer.parseInt(br.readLine());
		arrM = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrM);
		
		for(int i : solution()) {
			System.out.print(i +" ");
		}
	}
	
	static List<Integer> solution(){
		List<Integer> answer = new ArrayList<>();
		int p1 = 0;      
		int p2 = 0;
		while(p1<n && p2<m) {
			if(arrN[p1] == arrM[p2]) {
				answer.add(arrN[p1++]);
				p2++;
			}
			else if(arrN[p1]>arrM[p2]) p2++;
			else p1++;
		}
		return answer;
	}
}
