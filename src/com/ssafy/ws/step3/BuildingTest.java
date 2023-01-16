package com.ssafy.ws.step3;

import java.util.*;
import java.io.*;
/**
 * B구획의 빌딩 최고 높이 구하기
 */ 
public class BuildingTest {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < test_case+1; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			char arr[][] = new char[n][n];
			
			for(int i = 0; i < n; i++) {
				String input = br.readLine();
				arr[i] = input.toCharArray();
			}
			
			int max_floor = 2;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					//빌딩일 경우
					int check = 0;
					if(arr[i][j] == 'B') {
						//우측
						if(j < n-1) {
							if(arr[i][j+1]=='G') {
								check--;
							}
							else
								check++;
							//우측_상단 검증이 필요한 경우
							if(i>0) {
								if(arr[i-1][j+1]=='G') {
									check--;
								}
								else
									check++;
							}
							else
								check++;
							//우측_하단 검증이 필요한 경우
							if(i<n-1) {
								if(arr[i+1][j+1]=='G') {
									check--;
								}
								else
									check++;
							}
							else
								check++;
						}
						//검증이 필요 없는 경우+우측 상/하단도 검증할 필요가 없음.
						else
							check += 3;
						
						//좌측
						//좌측 검증이 필요한경우
						if(j > 0) {
							if(arr[i][j-1]=='G') {
								check--;
							}
							else//검증 했는데 b인경우
								check++;
							//좌측_상단 검증이 필요한 경우
							if(i>0) {
								if(arr[i-1][j-1]=='G') {
									check--;
								}
								else
									check++;
							}
							else
								check++;
							//좌측_하단 검증이 필요한 경우
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
						//검증이 필요 없는 경우+좌측 상/하단도 검증할 필요가 없음.
						else
							check += 3;
						
						//상단 검증이 필요한 경우
						if(i > 0) {
							if(arr[i-1][j] == 'G') {
								check--;
							}
							else
								check++;
						}else
							check++;
						
						//하단 검증이 필요한 경우
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
