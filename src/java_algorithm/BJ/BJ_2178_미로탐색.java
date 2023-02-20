package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//좌표 담을 클래스 변수
class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BJ_2178_미로탐색 {
	static int n,m; //배열 크기
	static int arr[][]; // 배열 선언
	static int count = 1; // 최소 이동거리
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1]; // 인덱스 접근 용이하게 +1 +1
		
		//데이터 입력 초기화
		for(int i = 1; i<= n; i++) {
			char[] input = br.readLine().toCharArray(); // 스트링->문자열배열
			for(int j = 0; j<m; j++) {
				arr[i][j+1] = input[j]-'0'; // 문자->정수
			}
		}
		//메서드 호출
		solution();
		//출력
		System.out.println(count);
	}
	private static void solution() {
		Queue<Point> que = new LinkedList<Point>();// 클래스 객체로 큐 생성.
		que.add(new Point(1, 1));// 첫 시발점 큐에 담기.
		// 큐가 빌때까지 반복.
		while(!que.isEmpty()) {
			int size = que.size(); // 큐의 크기 따로 담기
			// 큐의 크기만큼 반복: 큐의 크기를 다 돌아야 한 싸이클(bfs)
			for(int i = 0; i<size; i++) {
				int x = que.peek().x; // 현재 x좌표
				int y = que.poll().y; // 현재 y좌표
				//하부로 이동검증
				if(x<n && arr[x+1][y] == 1) { //이동 조건
					if(x+1 == n && y == m) { //다음이 도착지일시 즉시탈출
						count++; return;
					}
					arr[x+1][y] = 2;	// 방문한 지역은 2로 초기화
					que.add(new Point(x+1,y)); // 큐에 해당 지역 좌표담기: 다음 while문에서 검증.
				}
				//우측으로 이동검증
				if(y<m && arr[x][y+1] == 1) { //이동조건
					if(x == n && y+1 == m) { //다음이 도착지일시 즉시탈출
						count++; return;
					}
					arr[x][y+1] = 2;
					que.add(new Point(x,y+1));
				}
				// 상부와 좌측이동으로는 nm좌표로 이동이 불가능하기에 즉시탈출은 있을 수 없다.
				//상부
				if(x>1 && arr[x-1][y] == 1) { 
					arr[x-1][y] =2;
					que.add(new Point(x-1,y));
				}
				//좌측
				if(y>1 && arr[x][y-1] == 1) {
					arr[x][y-1] =2;
					que.add(new Point(x,y-1));
				}
			}
			count++; // 한 싸이클 다돌면 이동횟수 추가.
		}
	}

}
