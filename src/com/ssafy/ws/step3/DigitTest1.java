package com.ssafy.ws.step3;
/**
 * �����ﰢ�� ����� ���� ����ϴ� Ŭ����
 */
public class DigitTest1 {

	public static void main(String[] args) {
		int arr[][] = new int[5][5];
		int d = 0;
		int count = 1;
		for(int i = 0; i < 5; i++) {
			for(int j = d; j <5; j++) {
				arr[i][j] = count;
				count++;
			}
			d++;
		}
		//���
		int k = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = k; j < 5; j++) {
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
