package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16235_나무재테크_retry {
	/***
	 * 봄 : 자신의 나이만큼 양분 먹음-> 나이 1증가. 나이가 어린 나무부터. 양분 나이만큼 못먹으면 죽음
	 * 여름 : 죽은 나무의 나이/2 만큼 양분증가.
	 * 가을 : 나무번식->나이가 5의 배수라면 8방에 나이 1 나무 생성. 땅 벗어나면 안생김.
	 * 겨울 : 각 지역에 양분 추가.
	 * 
	 * 정답 : k년 후 살아있는 나무 개수.
	 */
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		boolean isDead;
		
		public Tree(int x, int y, int age, boolean isDead) {
			this.x = x;
			this.y = y;
			this.age = age;
			this.isDead = isDead;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}
	
	
	static int n, m, k;
	static ArrayList<Tree> trees;
	static Deque<Integer> deadTrees;
	static int addNutriment[][], nowNutrument[][];
	static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1}, dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 땅 크기
		m = Integer.parseInt(st.nextToken()); // 초기 나무 개수
		k = Integer.parseInt(st.nextToken()); // 년
		
		trees = new ArrayList<>();
		
		addNutriment = new int[n][n];
		nowNutrument = new int[n][n];
		
		// 겨울마다 추가될 양분 입력, 초기 양분 입력
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				addNutriment[i][j] = Integer.parseInt(st.nextToken());
				nowNutrument[i][j] = 5;
			}
		}
		
		// 사전에 심을 나무 정보 입력
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken()); // 나무 나이.
			
			trees.add(new Tree(x, y, z, false));
		}

		deadTrees = new LinkedList<>();
		
		Collections.sort(trees);
		
		//k년 만큼 반복
		for(int i = 0; i<k; i++) {
			year();
		}
		
		int answer = trees.size(); // k년 후 나무 수
		
		System.out.println(answer);
	}
	
	private static void year() {
		// 봄 과정 : 양분먹고 커짐. 못먹으면 죽음.
		spring(); // 나무가 존재할때만.
		// 여름 과정 : 죽은 나무-> 양분
		summer();
		// 가을과정 : 나무 번식
		fall();
		// 겨울과정 : 양분 추가
		winter();
	}

	private static void winter() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				int val = addNutriment[i][j];
				nowNutrument[i][j] += val;
			}
		}
	}

	private static void fall() {
		ArrayList<Tree> newTrees = new ArrayList<>();
		
		// 현재 나무 탐색
		for(int i = 0; i<trees.size(); i++) {
			Tree tree = trees.get(i);
			if(tree.isDead) continue;
			
			if(tree.age%5 == 0) {
				for(int j = 0; j<8; j++) {
					int nx = tree.x + dx[j];
					int ny = tree.y + dy[j];
					
					if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
					newTrees.add(new Tree(nx, ny, 1, false));
				}
			}
		}
		for(Tree tree : trees) {
			if(!tree.isDead) newTrees.add(tree);
		}
		trees = newTrees;
	}

	private static void summer() {
		while(!deadTrees.isEmpty()) {
			int deadTreeIndex = deadTrees.pollLast();
			
			Tree tree = trees.get(deadTreeIndex);
			
			nowNutrument[tree.x][tree.y] += tree.age/2;
			
			tree.isDead = true;
		}
	}

	private static void spring() {
		for(int i = 0; i<trees.size(); i++) {
			Tree tree = trees.get(i);
			// 나무죽음
			if(nowNutrument[tree.x][tree.y] < tree.age) {
				deadTrees.add(i);
				continue;
			}
			// 나무성장
			nowNutrument[tree.x][tree.y] -= tree.age;
			tree.age++;
		}
	}

}
