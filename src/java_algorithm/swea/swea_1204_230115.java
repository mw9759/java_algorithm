package java_algorithm.swea;

import java.util.*;
import java.io.*;
public class swea_1204_230115 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			int grade[] = new int[1000];
			//������ �ҷ�����
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 1000; i++) {
				grade[i] = Integer.parseInt(st.nextToken());
			}
			//������ �󵵼� ����
			int count_grade[] = new int[101];
			for(int i = 0; i < 1000; i++) {
				count_grade[grade[i]]++;
			}
			//�ֺ�&�ִ����� ���ϱ�-> ���� �������� ����
			int many_gr = 0;
			int max_gr = 0;
			for(int i = 0; i < 101; i++) {
				if(count_grade[i]>=many_gr) {
					many_gr = count_grade[i];
					max_gr = i;
				}
			}
			
			
			System.out.println("#"+tc+" "+max_gr);
		}
	}

}
