package com.ssafy.hw.step2;

import java.io.*;
import java.util.Scanner;

public class Bridge_P {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		// n * n ũ�� �迭 ���� ( ���� )
		int[][] map = new int[n][n];
		
		// ���� ���� �Է� �ޱ�
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = 0 ; j < n; j++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// �ִ밪 ����
		int maxDistance = 0;
		
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = 0 ; j < n ; j++ ) {
				
				// ���� ��ġ�� ������ �˻�
				if ( map[i][j] == 1 ) {
					
					// ���̸� ���� ��ġ�κ��� ���Ž�� �Ͽ� ���� �Ǵ� ���ο� �ִ� ���� �Ÿ� ����, �ִ밪 ����
					
					// ������ 1���� �˻�
					for (int d = 1; d < n-j ; d++) {
						if ( map[i][j+d] == 1 ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					// ������ 1���� �˻�
					for (int d = 1; d <= j; d++) {
						if ( map[i][j-d] == 1 ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					// ������ 1���� �˻�
					for (int d = 1; d <= i ; d++) {
						if ( map[i-d][j] == 1 ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					// ������ 1���� �˻�
					for (int d = 1; d < n-i ; d++) {
						if ( map[i+d][j] == 1 ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
				}
			}
		}
		
		System.out.println(maxDistance);

	}
}
