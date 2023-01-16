package com.ssafy.ws.step3;

/**
 * 모래시계 모양의 숫자 출력하는 클래스
 */
public class DigitTest2 {

	public static void main(String[] args) {
		int arr[][] = new int[5][5];
		
		int indx = 0;
		int count = 1;
		for(int i = 0; i < 5; i++) {
			for(int j = indx; j < 5-indx; j++) {
				arr[i][j] = count;
				count++;
			}
			if(i<2)
				indx++;
			else
				indx--;
		}
		
		//출력
		int idx = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[i][j] == 0)
					System.out.print("   ");
				else if(arr[i][j] >= 10)
					System.out.print(arr[i][j] + " ");
				else
					System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		 
	}
}
