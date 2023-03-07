package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_뱀_3190 {
	static int n, appleCnt, turnCnt;
	static int board[][], movePattern[][], map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		appleCnt = Integer.parseInt(br.readLine());
		board = new int[n+1][n+1];
		map = new int[n+1][n+1];
		for(int i = 0; i<appleCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		turnCnt = Integer.parseInt(br.readLine());
		movePattern = new int[turnCnt][2];
		
		for(int i = 0; i<turnCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			movePattern[i][0] = Integer.parseInt(st.nextToken());
			movePattern[i][1] = st.nextToken().charAt(0);
		}
		
		for(int i = turnCnt-1; i>0; i--) {
			movePattern[i][0] -= movePattern[i-1][0];
		}
		
//		for(int i = 0; i<=n; i++) {
//			map[i] = board[i].clone();
//		}
		
		System.out.println(solution());
	}
	
	private static int solution() {
		//68 D  76  L
		boolean flag = true;
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(new int[] {1,1});
//		int headX = 1, headY = 1, tailX = 1, tailY = 1;
		int dir = 1;// 1:우 , 2:하 , 3:좌, 4:상
		int count = 0;
		board[1][1] = 2;
		
		for(int[] i : board) {
			System.out.println(Arrays.toString(i));
		}System.out.println();
		
		for(int i = 0; i<turnCnt; i++) {
			int cnt = movePattern[i][0];
			for(int j = 0; j<cnt; j++) {
				int headX = list.get(0)[0];
				int headY = list.get(0)[1];
				
				for(int q = 0; q<list.size(); q++) {
					map[list.get(q)[0]][list.get(q)[1]] = 2;
				}
				
				for(int[] is : map) {
					System.out.println(Arrays.toString(is));
				}System.out.println();
				
				for(int k = 0; k<=n; k++) {
					Arrays.fill(map[k], 0);
				}
				
				
				count++;
				// 우측이동1
				if(dir == 1) {
					int inbody[] = {headX, headY+1}; // 뱀의 몸인지 확인할 좌표
					if(headY+1>n || list.contains(inbody)) return count; // 인덱스를 벗어나거나 뱀의 몸이라면 리턴.
					list.add(0, new int[] {headX, headY+1}); // 아니라면 우선 뱀의 머리위치 초기화.
					if(board[headX][headY+1]==1) board[headX][headY+1] = 0; // 머리위치에 사과가 있다면 먹는다.
					else list.remove(list.size()-1); // 사과가 없으면 꼬리를 땡겨와서 꼬리위치 변화-> 마지막 위치 삭제.
					
//					for(int[] k : board) {
//						System.out.println(Arrays.toString(k));
//					}System.out.println();
				}
				//하부이동2
				else if(dir == 2) {
					int inbody[] = {headX+1, headY}; // 뱀의 몸인지 확인할 좌표
					if(headX+1>n || list.contains(inbody)) return count;
					list.add(0, new int[] {headX+1, headY});
					if(board[headX+1][headY]==1) board[headX+1][headY] = 0;
					else list.remove(list.size()-1);
//						
//					for(int[] k : board) {
//						System.out.println(Arrays.toString(k));
//					}System.out.println();
				}
				//좌측이동3
				else if(dir == 3) {
					int inbody[] = {headX, headY-1}; // 뱀의 몸인지 확인할 좌표
					if(headY-1<1 || list.contains(inbody)) return count;
					list.add(0, new int[] {headX, headY-1});
					if(board[headX][headY-1]==1) board[headX][headY-1] = 0;
					else list.remove(list.size()-1);
					
//					for(int[] k : board) {
//						System.out.println(Arrays.toString(k));
//					}System.out.println();
				}
				//상부이동4
				else if(dir == 4) {
					int inbody[] = {headX-1, headY}; // 뱀의 몸인지 확인할 좌표
					if(headX-1<1 || list.contains(inbody)) return count;
					list.add(0, new int[] {headX-1, headY});
					if(board[headX-1][headY]==1) board[headX-1][headY] = 0;
					else list.remove(list.size()-1);
					
//					for(int[] k : board) {
//						System.out.println(Arrays.toString(k));
//					}System.out.println();
				}
			}
			
			if(movePattern[i][1] == 68) {//D
				if(dir == 1) dir = 2;
				else if(dir == 2) dir = 3;
				else if(dir == 3) dir = 4;
				else if(dir == 4) dir = 1;
			}
			
			else {//L
				if(dir == 1) dir = 4;
				else if(dir == 2) dir = 1;
				else if(dir == 3) dir = 2;
				else if(dir == 4) dir = 3;
			}
		}
		return count;
	}
}
/*
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D
*/