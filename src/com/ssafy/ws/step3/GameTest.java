package com.ssafy.ws.step3;

import java.util.Scanner;

/**
 * ����,����,�� ������ �ϴ� Ŭ����
 */
public class GameTest {

	public static void main(String[] args) {
		System.out.println("���������� ������ �����մϴ�. �Ʒ� ���� �� �ϳ��� ������.");
		System.out.println("1. 5�� 3��");
		System.out.println("2. 3�� 2��");
		System.out.println("3. 1�� 1��");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȣ�� �Է��ϼ���: ");
		int lv =sc.nextInt();
		int count = 0;
		
		if(lv == 1)
			count = 5;
		else if(lv == 2)
			count = 3;
		else
			count = 1;
		//���� = 1 , ���� = 2, �� = 3
		int user_win = 0;
		int com_win = 0;
		int user_type = 0;
		for(int i = 0; i < count; i++) {
			if(user_win>count/2 || com_win>count/2)
				break;
			System.out.print("���������� �� �ϳ� �Է�: ");
			String user = sc.next();
			
			if(user == "����")
				user_type = 1;
			else if(user == "����")
				user_type = 2;
			else
				user_type = 3;
			int com_type = (int)(Math.random()*3)+1;
			if(user_type == 1) {
				if(com_type ==2) {
					com_win++;
					System.out.println("�����ϴ�!!");
				}
				else if(com_type == 3) {
					user_win++;
					System.out.println("�̰���ϴ�!!");
				}
				else {
					System.out.println("�����ϴ�!!");
					i--;
				}
			}
			else if(user_type == 2) {
				if(com_type ==3) {
					com_win++;
					System.out.println("�����ϴ�!!");
				}
				else if(com_type == 1) {
					user_win++;
					System.out.println("�̰���ϴ�!!");
				}
				else {
					System.out.println("�����ϴ�!!");
					i--;
				}
			}
			else{
				if(com_type ==1) {
					com_win++;
					System.out.println("�����ϴ�!!");
				}
				else if(com_type == 2) {
					user_win++;
					System.out.println("�̰���ϴ�!!");
				}
				else {
					System.out.println("�����ϴ�!!");
					i--;
				}
			}
		}
		if(user_win > com_win)
			System.out.println("###���� ��!!!");
		else if(user_win < com_win)
			System.out.println("###��ǻ�� ��!!!");
		else
			System.out.println("###�����ϴ�!!!");
		
	}
}
