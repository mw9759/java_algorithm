package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14499_주사위굴리기 {
	
	static class DiceV{
		// 현재 면
		int x;
		int y;
		// 면의 값
		int cost;
		public DiceV(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		public String toString() {
			return "x: "+x + " | y: "+ y+ " | cost: "+ cost;
		}
	}
	
	static int n, m, x, y, k;
	static int arr[][];
	// 위, 우, 좌, 상, 하, 밑
	static int dice[][] = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}, {2, 0}}; 
//							-1, 0   				  2, 0    0, 0	  1, 0
//							1, 0                      0, 0    2, 0    -1, 0
//							0, 1    2, 0    0, 0                      0, -1
//							0, -1   0, 0    2, 0                      0, 1
    static int move1[][] = {{0, 1}, {2, -1}, {0, 1}, {0, 0}, {0, 0}, {-2, -1}}; // 
	static int move2[][] = {{0, -1}, {0, -1}, {2, 1}, {0, 0}, {0, 0}, {-2, 1}};
	static int move3[][] = {{-1, 0}, {0, 0}, {0, 0}, {3, 0}, {-1, 0}, {-1, 0}};
	static int move4[][] = {{1, 0}, {0, 0}, {0, 0}, {1, 0}, {1, 0}, {-3, 0}};
	static int dx[] = {0, 0, 0, -1, 1}, dy[] = {0, 1, -1, 0, 0}; 
	static HashMap<Integer, Integer[]> nextD = new HashMap<>();
	static List<DiceV> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		list = new ArrayList<DiceV>();
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<6; i++) {
			list.add(new DiceV(dice[i][0], dice[i][1], 0));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<k; i++) {
			if(!solution(Integer.parseInt(st.nextToken()))) continue;
			change();
			findTop();
		}
	}
	private static void change() {
		for(DiceV d : list) {
			// 현재 면이 바닥이라면
			if(d.x == 2) {
				if(arr[x][y] == 0) {
					arr[x][y] = d.cost;
				}
				else {
					d.cost = arr[x][y];
					arr[x][y] = 0;
				}
			}
		}
	}
	
	private static void findTop() {
		for(DiceV d : list) {
			if(d.x == 0 && d.y == 0) {
				System.out.println(d.cost);
			}
		}
	}
	
	private static boolean solution(int dir) {
//		System.out.println("dir: "+dir+" x: "+x+" y: " +y);
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx<0 || nx>=n || ny<0 || ny>=m) return false;
		x = nx;
		y = ny;
//		System.out.println("x: "+x+" y: " +y);
		//동쪽이동
		if(dir == 1) move(move1, nx, ny);
		// 서쪽이동
		else if(dir == 2) move(move2, nx, ny);
		// 북쪽이동
		else if(dir == 3) move(move3, nx, ny);
		// 남쪽이동
		else if(dir == 4) move(move4, nx, ny);
		
		return true;
	}
	
	private static void move(int[][] m, int nx, int ny) {
//		System.out.println("before==============");
//		for(DiceV d: list)
//			System.out.println(d.toString());
		for(DiceV d : list) {
			for(int i = 0; i<6; i++) {
				if(d.x == dice[i][0] && d.y == dice[i][1]) {
					d.x += m[i][0];
					d.y += m[i][1];
					break;
				}
			}
		}
//		System.out.println("before==============");
//		for(DiceV d: list)
//			System.out.println(d.toString());
	}
}
