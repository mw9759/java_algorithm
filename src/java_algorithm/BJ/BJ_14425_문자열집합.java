package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_14425_문자열집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		int answer = 0;
		for(int i = 0; i<n; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i<m; i++) {
			if(set.contains(br.readLine())) answer++;
		}
		
		System.out.println(answer);
	}

}
