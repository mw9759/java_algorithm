package com.ssafy.ws.step3;

import java.util.*;
import java.io.*;
/**
 * B��ȹ�� ���� �ְ� ���� ���ϱ�
 */ 
public class BuildingTest {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//int test_case = Integer.parseInt(br.readLine());
		//for(int tc = 1; tc < test_case+1; tc++) {
		//	int n = Integer.parseInt(br.readLine());
			
		//	char arr[][] = new char[n][n];
			
		//	for(int i = 0; i < n; i++) {
		//		String input = br.readLine();
		//		arr[i] = input.toCharArray();
	//		}
			
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int tc  = 1; tc < test_case+1; tc++) {
			int n = sc.nextInt();
			char arr[][] = new char[n][n];
			for(int i = 0; i < n; i++) {
				String input = sc.next();
				arr[i] = input.toCharArray();
			}
			
			int max_floor = 2;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					//������ ���
					int check = 0;
					if(arr[i][j] == 'B') {
						//����
						if(j < n-1) {
							if(arr[i][j+1]=='G') {
								check--;
								break;
							}
							else
								check++;
							//����_��� ������ �ʿ��� ���
							if(i>0) {
								if(arr[i-1][j+1]=='G') {
									check--;
									break;
								}
								else
									check++;
							}
							else
								check++;
							//����_�ϴ� ������ �ʿ��� ���
							if(i<n-1) {
								if(arr[i+1][j+1]=='G') {
									check--;
									break;
								}
								else
									check++;
							}
							else
								check++;
						}
						//������ �ʿ� ���� ���+���� ��/�ϴܵ� ������ �ʿ䰡 ����.
						else
							check += 3;
						
						//����
						//���� ������ �ʿ��Ѱ��
						if(j > 0) {
							if(arr[i][j-1]=='G') {
								check--;
							}
							else//���� �ߴµ� b�ΰ��
								check++;
							//����_��� ������ �ʿ��� ���
							if(i>0) {
								if(arr[i-1][j-1]=='G') {
									check--;
								}
								else
									check++;
							}
							else
								check++;
							//����_�ϴ� ������ �ʿ��� ���
							if(i<n-1) {
								if(arr[i+1][j-1]=='G') {
									check--;
								}
								else
									check++;
							}
							else
								check++;
						}
						//������ �ʿ� ���� ���+���� ��/�ϴܵ� ������ �ʿ䰡 ����.
						else
							check += 3;
						
						//��� ������ �ʿ��� ���
						if(i > 0) {
							if(arr[i-1][j] == 'G') {
								check--;
							}
							else
								check++;
						}else
							check++;
						
						//�ϴ� ������ �ʿ��� ���
						if(i < n-1) {
							if(arr[i+1][j] == 'G') {
								check--;
							}
							else
								check++;
						}else
							check++;
					if(check == 8) {
						int count = -1;
						for(int k = 0; k < n; k++) {
							if(arr[i][k] == 'B')
								count++;
						}
						for(int l = 0; l < n; l++) {
							if(arr[l][j] == 'B')
								count++;
						}
						max_floor = Math.max(count, max_floor);
					}
						
					}
					
				}
			}
			System.out.println("#"+tc+" " + max_floor);
		}
		
	}
}
