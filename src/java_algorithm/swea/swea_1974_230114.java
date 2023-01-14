package java_algorithm.swea;

import java.util.*;
import java.io.*;

public class swea_1974_230114 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //오직 엔터값을 구분자로 인식
	
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
		{
        	int x_y[][] = new int[9][9];
        
	        for(int j=0; j<9; j++) {
	            StringTokenizer st = new StringTokenizer(br.readLine(), " "); //토크나이저를 사용하면 문자열을 토큰으로 하여 값을 불러온다.
	            for(int k=0; k<9; k++) 
	            	x_y[j][k] = Integer.parseInt(st.nextToken());
	        }
	        //x축 검증
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
	        //x축 검증후 answer_x = 0일때(x축에 문제가 있을때) 그냥 바로 다음 스도쿠로
	        if(answer_x != 1) {
	        	System.out.println("#"+test_case+" "+ 0);
	        	continue;
	        }
	        
	        //y축 검증
	        int answer_y = 1;
	        for(int i = 0; i < 9; i++) {
	        	int counter[] = new int[10];
	        	int[] arr_y = new int[9];
	        	for(int j = 0; j < 9; j++) //y축 값만 배열에 넣기
	        		arr_y[j] = x_y[j][i];
	        	
	        	for(int k = 0; k < 9; k++) //y값만 있는 배열에서 해당 값을 인덱스로 정의하여 그 인덱스값을 ++, 즉 각 값이 1개씩만 있다면 11111111이런식이 되어야함.
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
	        //y축 검증후 answer_y = 0일때(y축에 문제가 있을때) 그냥 바로 다음 스도쿠로
	        if(answer_y != 1) {
	        	System.out.println("#"+test_case+" "+ 0);
	        	continue;
	        }
	        
	        //33 검증
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
