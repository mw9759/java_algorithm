package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Point1{
	int x,y;
	Point1(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BJ_2239_스도쿠 {
	static int arr[][] = new int[10][10];
	static List<Point1> point = new ArrayList<Point1>();
	static boolean flag = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i<= 9; i++) {
			String str = br.readLine();
			for(int j = 0; j<9; j++) {
				arr[i][j+1] = str.charAt(j)-'0';
				if(arr[i][j+1] == 0) {
					point.add(new Point1(i, j+1));
				}
			}
		}
		sudoku(0);
		for(int i = 1; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				System.out.print(arr[i][j]);
			}System.out.println();
		}
	}
	
	private static void sudoku(int idx) {
//		if(idx>0) {
//			int bx = point.get(idx-1).x;
//			int by = point.get(idx-1).y;
//			if(arr[bx][by] == 0) return;
//		}
		if(flag) return;
		if(idx == point.size()) {
			boolean flags = true;
			for(int i = 1; i<=9; i++) {
				for(int j = 1; j<=9; j++) {
					if(arr[i][j] == 0) {
						flags =false;
					}
				}
			}
			if(flags) flag = true;
			
			return;
		}
		
		int x = point.get(idx).x;
		int y = point.get(idx).y;
		for(int i = 1; i<=9; i++) {
			if(checkX(x,i) && checkY(y,i) && check33((x-1)/3,(y-1)/3,i)) {
				arr[x][y] = i;
				sudoku(idx+1);
			}
		}
	}
	private static boolean checkX(int x, int num) {
		for(int i = 1; i<=9; i++) {
			if(arr[x][i] == num) return false;
		}
		return true;
	}
	
	private static boolean checkY(int y, int num) {
		for(int i = 1; i<=9; i++) {
			if(arr[i][y] == num) return false;
		}
		return true;
	}
	
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
