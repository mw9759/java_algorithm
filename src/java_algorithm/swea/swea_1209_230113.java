package java_algorithm.swea;

import java.util.*;
import java.io.*;
public class swea_1209_230113 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case < T+1; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];
			//�ִ� ���� ����
			int answer = 0;
			
			//������ �޾ƿ��� + x�� ����
			for(int i = 0; i < 100; i++) {
				int sum = 0;
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					int temp = Integer.parseInt(st.nextToken());
					sum += temp;
					arr[i][j] = temp;
				}
				answer = Math.max(answer, sum);
			}
			
			//y�� ����
			for(int i = 0; i < 100; i++) {
				int sum = 0;
				for(int j = 0; j < 100; j++) {
					sum+=arr[j][i];
				}
				answer = Math.max(answer, sum);
			}
			
			//�밢�� ���� 2��
			int cross_1 = 0;
			int cross_2 = 0;
			for(int i = 0; i < 100; i++) {
				cross_1 += arr[i][i];
				cross_2 += arr[i][99-i];
			}
			answer = Math.max(answer, cross_1);
			answer = Math.max(answer, cross_2);
			if(cross_2 > answer)
				answer = cross_2;
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
