package com.ssafy.ws.step3;

import java.util.*;
import java.io.*;
/**
 * B구획의 빌딩 최고 높이 구하기
 */ 
public class BuildingTestDemo {

   public static void main(String[] args) throws Exception{
	   int [][] deltas = {{-1, -1},{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1}};
	      
	      Scanner sc = new Scanner(System.in);
	      int T = sc.nextInt();
	      
	      // input data -> matrix
	      for(int i = 0; i < T; i++) {
	         int N = sc.nextInt();
	         char [][] matrix = new char[N][N];
	         for(int x = 0; x < N; x++) {
	            char str = sc.nextLine().charAt(0);
	            for(int y = 0; y < N; y++) {
	               matrix[x][y] += str;
	            }
	         }
	         
	         //check and sum
	         int sum = 0;
	         for(int r = 0; r < matrix.length; r++) {
	            for(int c = 0; c < matrix[0].length; c++) {
	               if(matrix[r][c] == 'B') {
	                  for(int j = 0; j < N;j++) {
	                     int nr = r + deltas[j][0];
	                     int nc = c + deltas[j][1];
	                     if(nr >= 0 && nr <matrix[0].length && nc >= 0 && nc < matrix[0].length) {
	                        if (matrix[nr][nc] == 'B') {
	                           sum += 1;
	                        }
	                        else if(matrix[nr][nc] == 'G') {
	                           sum += 2;
	                        }
	                     int max = 0;
	                     if(sum >= max) {
	                        max = sum;
	                     }
	                     
	                     }
	                  }
	               }
	            }
	         }
	         System.out.println(matrix);
	      }
	   

	
      
   }
}