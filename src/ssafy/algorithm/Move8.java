package ssafy.algorithm;

import java.io.*;
import java.util.*;

public class Move8 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/inputmove.txt")); // 파일 불러오기
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //파일 읽어오는 객체 생성
	    
	    int tc = Integer.parseInt(br.readLine());
	    for(int testCase = 1; testCase < tc+1; testCase++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int x = Integer.parseInt(st.nextToken());//배열x축 길이
	        int y = Integer.parseInt(st.nextToken());//배열y축 길이
	        int n = Integer.parseInt(st.nextToken());//참가자 수s
	        int arr[][] = new int[x][y];// 배열 생성
	        /* 배열에 데이터 할당.**/
	        for(int i = 0; i < x; i++) {
	        	st = new StringTokenizer(br.readLine()); 
	        	for(int j = 0; j < y; j++) {
	        		arr[i][j] = Integer.parseInt(st.nextToken());
	        	}
	        }
	        
	        /* 참가자 수만큼 데이터 불러오기**/
	        int user[][] = new int[n][3]; //0번인덱스: 시작x좌표 | 1번 인덱스: 시작y좌표 | 3번 인덱스: 이동횟수
	        for(int i = 0; i < n; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	user[i][0] = Integer.parseInt(st.nextToken())-1; // i번째 참가자 x좌표값 저장
	        	user[i][1] = Integer.parseInt(st.nextToken())-1; // i번째 참가자 y좌표값 저장
	        	user[i][2] = Integer.parseInt(st.nextToken()); // i번째 참가자 이동횟수 저장
	        }
	        
	        int sum = -1000*n; // 상금의 합 초기값 : 참가자수 x참가비용.
	        /* 참가자별 이동**/
	        for(int player = 0; player < n; player++) { //참가자 수만큼 반복
	        	int px = user[player][0];// 참가자의 x좌표값
	        	int py = user[player][1];// 참가자의 y좌표값
	        	for(int c = 0; c < user[player][2]; c++) { // 참가자의 이동 개수
	        		
	        		/* 현재 좌표 인덱스 문제 있을시 반복문 탈출**/
	        		if(px < 0 || py>=y || px>=x || py<0)
	        			break;
	        		
		        	/* 앞자리수가 1이라면-상단**/
			        if(arr[px][py]/10 == 1) {
			        	px -= arr[px][py]%10;
			        }
		        	/* 앞자리수가 2라면-우측상단**/
		        	else if(arr[px][py]/10 == 2) {
		        		int d = arr[px][py]%10;
		        		px -= d;
		        		py += d;
		        	}
		        	
		        	/* 앞자리수가 3이라면-우측**/
		        	else if(arr[px][py]/10 == 3) {
		        		py += arr[px][py]%10;
		        	}
		        	
		        	/* 앞자리수가 4라면-우측하단**/
		        	else if(arr[px][py]/10 == 4) {
		        		int d = arr[px][py]%10;
		        		px += d;
		        		py += d;
		        	}
		        	
		        	/* 앞자리수가 5라면-하단**/
		        	else if(arr[px][py]/10 == 5) {
		        		px += arr[px][py]%10;
		        	}
		        	
		        	/* 앞자리수가 6이라면-좌측하단**/
		        	else if(arr[px][py]/10 == 6) {
		        		int d = arr[px][py]%10;
		        		px += d;
		        		py -= d;
		        	}
		        	
		        	/* 앞자리수가 7이라면-좌측**/
		        	else if(arr[px][py]/10 == 7) {
		        		py -= arr[px][py]%10;
		        	}
		        	
		        	/* 앞자리수가 8이라면-좌측상단**/
		        	else{
		        		int d = arr[px][py]%10;
		        		px -= d;
		        		py -= d;
		        	}
	        	}
	        	/* 플레이어별 for문 다 돌고or 탈출했을때 좌표 인덱스 조건 만족하면 상금추가 **/
	        	if(px>=0 && py>=0 && px<x && py<y) {
	        		sum += arr[px][py]*100;
	        	}
	        }
	        System.out.println("#"+testCase+" " + sum);
	    }
	}
}
