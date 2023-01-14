package java_algorithm.swea;

import java.util.*;
import java.io.*;

public class swea_1974_230114 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //���� ���Ͱ��� �����ڷ� �ν�
	
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
		{
        	int x_y[][] = new int[9][9];
        
	        for(int j=0; j<9; j++) {
	            StringTokenizer st = new StringTokenizer(br.readLine(), " "); //��ũ�������� ����ϸ� ���ڿ��� ��ū���� �Ͽ� ���� �ҷ��´�.
	            for(int k=0; k<9; k++) 
	            	x_y[j][k] = Integer.parseInt(st.nextToken());
	        }
	        //x�� ����
	        int answer_x = 1;
	        for(int i = 0; i < 9; i++) {
	        	int counter[] = new int[10];
	        	for(int j = 0; j < 9; j++) {
	        		counter[x_y[i][j]]++;
	        	}
	        	for(int k = 1; k < 10; k++) {
	        		if(counter[k] != 1) {
	        			answer_x = 0;
	        			break;
	        		}
	        	if(answer_x == 0)
	        		break;
	        	}
	        }
	        //x�� ������ answer_x = 0�϶�(x�࿡ ������ ������) �׳� �ٷ� ���� �������
	        if(answer_x != 1) {
	        	System.out.println("#"+test_case+" "+ 0);
	        	continue;
	        }
	        
	        //y�� ����
	        int answer_y = 1;
	        for(int i = 0; i < 9; i++) {
	        	int counter[] = new int[10];
	        	int[] arr_y = new int[9];
	        	for(int j = 0; j < 9; j++) //y�� ���� �迭�� �ֱ�
	        		arr_y[j] = x_y[j][i];
	        	
	        	for(int k = 0; k < 9; k++) //y���� �ִ� �迭���� �ش� ���� �ε����� �����Ͽ� �� �ε������� ++, �� �� ���� 1������ �ִٸ� 11111111�̷����� �Ǿ����.
	        		counter[arr_y[k]]++;
	        	
	        	for(int l = 1; l < 10; l++) {
	        		if(counter[l] != 1) {
	        			answer_y = 0;
	        			break;
	        		}
	        	}
	        	if(answer_y == 0)
	        		break;
	        }
	        //y�� ������ answer_y = 0�϶�(y�࿡ ������ ������) �׳� �ٷ� ���� �������
	        if(answer_y != 1) {
	        	System.out.println("#"+test_case+" "+ 0);
	        	continue;
	        }
	        
	        //33 ����
	        int answer_33 = 1;
	        for(int i = 0; i<9; i+=3) {
	        	for(int j = 0; j < 9; j+=3) {
	        		int[] counter = new int[10];
	        		int[] arr_33 = new int[9];
	        		int indx = 0;
	        		for(int k = 0; k < 3; k++) {
	        			for(int l = 0; l < 3; l++) {
	        				arr_33[indx] = x_y[k+i][l+j];
	        				indx++;
	        			}
	        		}
	        		
	        		for(int m = 0; m < 9; m++) 
	        			counter[arr_33[m]]++;
	        		for(int n = 1; n < 10; n++) {
	        			if(counter[n] != 1) {
	        				answer_33 = 0;
	        				break;
	        			}
	        		}
	        		if(answer_33 == 0)
	        			break;
	        	}
	        }
	        
	        System.out.println("#"+test_case+" "+ (answer_x*answer_y*answer_33));
	        
		}
        
	}

}
