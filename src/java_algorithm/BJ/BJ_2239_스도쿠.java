package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//스도쿠 빈칸의 좌표를 담을 객체.
class Point1{
	int x,y;
	Point1(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BJ_2239_스도쿠 {
	static int arr[][] = new int[10][10]; //스도쿠
	static List<Point1> point = new ArrayList<Point1>();// 빈칸의 좌표가 담긴 객체를 저장할 리스트.
	static boolean flag = false; // 스도쿠 완성 유무
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//초기 스도쿠 입력.
		for(int i = 1; i<= 9; i++) {
			String str = br.readLine();
			for(int j = 0; j<9; j++) {
				arr[i][j+1] = str.charAt(j)-'0';
				if(arr[i][j+1] == 0) { //빈칸일 경우 Point1객체에 좌표 담아 point 리스트에 담기.
					point.add(new Point1(i, j+1));
				}
			}
		}
		//메서드 호출
		sudoku(0);
		// 완성된 스도쿠 출력./
		for(int i = 1; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				System.out.print(arr[i][j]);
			}System.out.println();
		}
	}
	
	private static void sudoku(int idx) {
		//기저조건
		if(idx == point.size()) { // 빈칸을 모두 채웠을 때.
			flag = true; // 스도쿠 완성
			return; 
		}
		// 채울 스도쿠의 좌표
		int x = point.get(idx).x; 
		int y = point.get(idx).y;
		for(int i = 1; i<=9; i++) {
			//가로, 세로, 33 을 모두 만족할 때만 재귀.-> 만족하지 않으면 i가 9일땐 재귀 자동 종료.->따라서 기저조건 if문은 완성되었을 때만 돌아간다.
			if(checkX(x,i) && checkY(y,i) && check33((x-1)/3,(y-1)/3,i)) { 
				arr[x][y] = i; // 해당 좌표에 검증된 값 입력.
				sudoku(idx+1); // 다음 좌표로 다시 호출.
				if(flag) return; // 만약 위의 재귀를 돌며 스도쿠가 끝까지 완성된 경우 바로 종료.
				arr[x][y] = 0; // 완성이 안된경우 값이 잘못 들어감: 다시 0으로 만들어서 다른 값을 찾는다.
			}
		}
	}
	
	// x축 검증
	private static boolean checkX(int x, int num) {
		for(int i = 1; i<=9; i++) {
			if(arr[x][i] == num) return false;
		}
		return true;
	}
	//y축 검증
	private static boolean checkY(int y, int num) {
		for(int i = 1; i<=9; i++) {
			if(arr[i][y] == num) return false;
		}
		return true;
	}
	// 3*3구역 검증.
	private static boolean check33(int x, int y, int num) {
		if(x == 0) x = 1; 
		else if(x == 1) x = 4; 
		else if(x == 2) x = 7; 
		if(y == 0) y = 1;
		else if(y == 1) y = 4;
		else if(y == 2) y = 7;
		
		for(int i = x; i<x+3; i++) {
			for(int j = y; j<y+3; j++){
				if(arr[i][j]==num) return false;
			}
		}
		return true;
	}
}
