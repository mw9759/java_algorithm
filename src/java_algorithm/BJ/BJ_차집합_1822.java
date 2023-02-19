package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_차집합_1822 {
	
	static int nA;
	static int nB;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nA = Integer.parseInt(st.nextToken());
		nB = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> ts = new TreeSet<Integer>(); // 중복허용x 자동 내림차순 정렬.
		//A 집합 입력 저장,
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<nA; i++) ts.add(Integer.parseInt(st.nextToken()));
		
		//B 집합 입력받으며 A집합에 이미 포함되어있다면 A집합에서 삭제.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<nB; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(ts.contains(a)) ts.remove(a);
		}
		
		//출력
		System.out.println(ts.size());
		for(int i : ts) System.out.print(i + " ");
	}

}
