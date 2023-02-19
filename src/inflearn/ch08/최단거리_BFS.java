package inflearn.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1부터 n까지
 * 최단거리 구하기
 * 
 */
public class 최단거리_BFS {

	static int n,m;
	static int[] ch, dis;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 총 노드의 갯수이자 각 노드의 번호
		m = Integer.parseInt(st.nextToken()); // 노드간 이동관계 갯수
		ch = new int[n+1]; //각 노드번호를 인덱스로 해당 노드에 방문 여부 저장. 0: 방문하지 않음 | 1: 방문
		dis = new int[n+1]; // 1번노드기준 다른노드까지의 최단길이 저장. 인덱스: 도착지 노드번호
		graph = new ArrayList<ArrayList<Integer>>(); // 각 노드별 인접노드 번호 저장.
		
		// 2차원 리스트에 인덱스로 접근하기 위해 0부터 n까지 초기화.
		// 2차원 구조를 위해 리스트 안에 리스트를 초기화 하는 과정.
		for(int i = 0; i<=n; i++) {
			graph.add(new ArrayList<Integer>()); 
		}
		
		// 노드간 이동관계를 입력받아 2차원 리스트에 초기화.
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 인덱스 기준값.-> 각 노드별 방의 좌표
			int b = Integer.parseInt(st.nextToken()); // a라는 해당 노드의 인접노드 번호 
			graph.get(a).add(b); // a라는 노드에 인접한 노드 번호b 저장.
		}
		
		ch[1] = 1; // 1번노드의 방문여부 1로 초기화
		dis[1] = 0; // 1번노드의 1번으로의 최단거리
		bfs(1); // 1번노드 즉 시작노드의 인접 노드부터 확인한다.
		
		//출력
		//시작노드1로부터의 각 노드까지의 최단거리 출력 
		// 2:3 => 1번에서 2번까지의 최단거리는 3이다.
		for(int i = 2; i<=n; i++) {
			System.out.println(i+ " : "+dis[i]);
		}
	}
	
	private static void bfs(int cnt) {
		Queue<Integer> que = new LinkedList<>(); //너비우선 탐색을 위해 들어온 순으로 작업.
		que.add(cnt); // 생성된 q에 확인할 노드 삽입 : 시작노드인 cnd: 1
		while(!que.isEmpty()) { // 만약 탐색할 노드가 없다면 : q가 비었다면 탈출
			int nowNode = que.poll(); // 이번 while문에서 확인할 노드 빼오기.
			for(int nextNode : graph.get(nowNode)) { // 빼온 현재 노드의 인접한 노드만 확인
				if(ch[nextNode] == 0) {	// 인접한 노드의 방문 기록이 없다면
					ch[nextNode] =1;		// 방문을 표시하고
					que.add(nextNode);		// 큐에 넣어준다 : 들어간 노드 기준에서 또 인접노드를 탐색.
					dis[nextNode] = dis[nowNode]+1; // 이 인접한 노드까지의 최단거리는 현재 노드까지의 최단값 +1이다.
				}
			}
		}
	}

}
