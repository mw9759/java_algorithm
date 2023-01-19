package ssafy.algorithm;
import java.util.*;
import java.io.*;

public class Robot {

public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("src/inputRobot.txt")); // 파일 불러오기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //파일 읽어오는 객체 생성
    
    int tc = Integer.parseInt(br.readLine()); //객체를 통해 텍스트 한줄 불러와 변수에 할당.(테스트케이스 개수)
    
    for(int testCase = 1; testCase < tc+1; testCase++) { //테스트 케이스용 반복문 
        int n = Integer.parseInt(br.readLine()); //배열 길이 받아와 변수에 할당.
        String arr[][] = new String[n][n]; //불러온 배열 길이로 2차원 배열 생성.
        
        /* 2차원 배열에 데이터 할당**/
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken();
            }
        }
        
        /* 카운트 변수 선언 및 배열 돌리면서 로봇 찾기**/
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                //만약 A로봇일 경우 
                if(arr[i][j].equals("A")) { // 해당 값이 A라면
                    for(int a = j+1; a < n; a++) { //다음 값부터 돌리기 위해 +1
                        if(arr[i][a].equals("S")) { //만약 S를 만난다면
                            count++;                // 카운트 +1
                        }else {                 //S가 아니라면
                            break;                //반북문 탈출
                        }
                    }
                }
                
                //만약 B로봇일 경우
                if(arr[i][j].equals("B")) {
                    //우측이동
                    for(int b = j+1; b < n; b++) {
                        if(arr[i][b].equals("S")) {
                            count++;
                        }else {
                            break;
                        }
                    }
                    
                    //좌측이동
                    for(int b = j-1; b>=0; b--) {
                        if(arr[i][b].equals("S")) {
                            count++;
                        }else {
                            break;
                        }
                    }
                }
                
                //만약 C로봇일 경우
                if(arr[i][j].equals("C")) {
                    //우측이동
                    for(int c = j+1; c < n; c++) {
                        if(arr[i][c].equals("S")) {
                            count++;
                        }else {
                            break;
                        }
                    }
                    
                    //좌측이동
                    for(int c = j-1; c>=0; c--) {
                        if(arr[i][c].equals("S")) {
                            count++;
                        }else {
                            break;
                        }
                    }
                    
                    //상측이동
                    for(int c = i + 1; c < n; c++) {
                        if(arr[c][j].equals("S")) {
                            count++;
                        }else {
                            break;
                        }
                    }
                    
                    //하측이동
                    for(int c = i-1; c>=0; c--) {
                        if(arr[c][j].equals("S")) {
                            count++;
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("#"+testCase+" "+count); //정답 출력문
    }
}
}