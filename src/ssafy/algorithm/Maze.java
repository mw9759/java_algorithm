package ssafy.algorithm;

import java.io.*;
import java.util.*;

public class Maze {

public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("src/inputmaze.txt")); // 파일 불러오기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //파일 읽어오는 객체 생성
    
    int tc = Integer.parseInt(br.readLine());
    for(int testCase = 1; testCase < tc+1; testCase++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());//배열의 길이
        int sp_x = Integer.parseInt(st.nextToken());//출발점 x좌표
        int sp_y = Integer.parseInt(st.nextToken());//출발점 x좌표
        int bpCount = Integer.parseInt(st.nextToken());//범퍼 개수
        
        /* 점퍼의 좌표**/
        int arr[][] = new int[bpCount][2]; //점퍼 좌표가 들어갈 배열 생성
        st = new StringTokenizer(br.readLine()); //txt 다음라인 불러오기
        for(int i = 0; i < bpCount; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        int moveCount = Integer.parseInt(br.readLine()); // 이동지시 개수 담기.
        
        /* 이동지시와 칸수 불러오기**/
        int arr2[][] = new int[moveCount][2]; // 5개의 이동지시.(이동방향, 이동칸수)
        st = new StringTokenizer(br.readLine()); // txt 다음라인 불러오기
        for(int i = 0; i < moveCount; i++) {
        	for(int j = 0; j < 2; j++) {
        		arr2[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        //n*n 배열 생성
        int maze[][] = new int[n][n];
        
        //점퍼 위치에 1넣기
        for(int i = 0; i < bpCount; i++) {
        	if(arr[i][0]<n && arr[i][1]<n) { // 범퍼 좌표가 n*n 배열 안에 있을 수 있다면
        	maze[arr[i][0]][arr[i][1]] = 1; 
        	}
        }

        //위치 이동
        for(int i = 0; i < moveCount; i++) {
        	//1(위로 이동일때)
        	if(arr2[i][0]==1) {
        		if(sp_x-arr2[i][1] >= 0) {
        			sp_x -= arr2[i][1];
        		} else {
        			sp_x = 0;
        			sp_y = 0;
        			break;
        		}
        		
        	}
        	
        	//2(우로 이동일때)
        	else if(arr2[i][0]==2) {
        		if(sp_y+arr2[i][1] < n) {
        			sp_y += arr2[i][1];
        		} else {
        			sp_x = 0;
        			sp_y = 0;
        			break;
        		}
        	}
        	
        	//3(아래로 이동일때)
        	else if(arr2[i][0]==3) {
        		if(sp_x + arr2[i][1] < n) {
        			sp_x += arr2[i][1];
        		} else {
        			sp_x = 0;
        			sp_y = 0;
        			break;
        		}
        	}
        	
        	//4(좌로 이동일때)
        	else {
        		if(sp_y - arr2[i][1] >= 0) {
        			sp_y -= arr2[i][1];
        		} else {
        			sp_x = 0;
        			sp_y = 0;
        			break;
        		}
        	}
        	
        	//이동 후 도착지가 점퍼지점인지 확인
        	if(maze[sp_x][sp_y] ==1) {
        		sp_x = 0;
        		sp_y = 0;
        		break;
        	}
        }
        
        System.out.println(sp_x+ " " +sp_y);

        }
        /* 테스트케이스 개수 불러오기**/

    }

}