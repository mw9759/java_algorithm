package java_algorithm.BJ;

import java.util.Scanner;

public class BJ_9663_NQueen {
	static int n, arr[], answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		queen(1);
		System.out.println(answer);
	}
	private static void queen(int row) {
		if(!check(row-1)) return; //이전 행이 옯바른 위치인지 확인 리턴이 false이면 이번 퀸의 배치는 잘못된 것이다.
		if(row>n) {
			answer++;
			return;
		}
		//해당 행에서 i몇번째 열에 퀸을 세웠을때의 경우
		for(int i = 1; i<=n; i++) {
			arr[row] = i; // row번째 행의 열은 i
			queen(row+1);//다음 행 확인
		}
	}
	private static boolean check(int row) {
		//현재행 이전의 모든 행을 돌면서 걸리는게 없는지 확인
		//좌상대각선 식 Math.abs(arr[i]-i) == Math.abs(arr[row]-row) 이면 같은 좌상 대각선상
		//우상대각선 식 arr[i]+i ==arr[row]+row 이면 같은 우상대각선상.
		// 이 두 식은 Math.abs(arr[i]-arr[row]) == row-i 로 한번에 정리된다. : row-i는 항상 양수이다.
		for(int i = 1; i<row; i++) {
			if(arr[i] == arr[row] || Math.abs(arr[i]-arr[row]) == row-i) {
				return false;
			}
		}
		return true;
	}

}
