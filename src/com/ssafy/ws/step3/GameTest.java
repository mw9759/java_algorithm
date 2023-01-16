package com.ssafy.ws.step3;

import java.util.Scanner;

/**
 * 가위,바위,보 게임을 하는 클래스
 */
public class GameTest {

	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 입력하세요: ");
		int lv =sc.nextInt();
		int count = 0;
		
		if(lv == 1)
			count = 5;
		else if(lv == 2)
			count = 3;
		else
			count = 1;
		//가위 = 1 , 바위 = 2, 보 = 3
		int user_win = 0;
		int com_win = 0;
		int user_type = 0;
		for(int i = 0; i < count; i++) {
			if(user_win>count/2 || com_win>count/2)
				break;
			System.out.print("가위바위보 중 하나 입력: ");
			String user = sc.next();
			
			if(user == "가위")
				user_type = 1;
			else if(user == "바위")
				user_type = 2;
			else
				user_type = 3;
			int com_type = (int)(Math.random()*3)+1;
			if(user_type == 1) {
				if(com_type ==2) {
					com_win++;
					System.out.println("졌습니다!!");
				}
				else if(com_type == 3) {
					user_win++;
					System.out.println("이겼습니다!!");
				}
				else {
					System.out.println("비겼습니다!!");
					i--;
				}
			}
			else if(user_type == 2) {
				if(com_type ==3) {
					com_win++;
					System.out.println("졌습니다!!");
				}
				else if(com_type == 1) {
					user_win++;
					System.out.println("이겼습니다!!");
				}
				else {
					System.out.println("비겼습니다!!");
					i--;
				}
			}
			else{
				if(com_type ==1) {
					com_win++;
					System.out.println("졌습니다!!");
				}
				else if(com_type == 2) {
					user_win++;
					System.out.println("이겼습니다!!");
				}
				else {
					System.out.println("비겼습니다!!");
					i--;
				}
			}
		}
		if(user_win > com_win)
			System.out.println("###유저 승!!!");
		else if(user_win < com_win)
			System.out.println("###컴퓨터 승!!!");
		else
			System.out.println("###비겼습니다!!!");
		
	}
}
