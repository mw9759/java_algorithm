package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1800_인터넷설치 {
	
	
	/*
	 * 1~n 중 n번 컴퓨터 인터넷 연결.
	 * k개까지 무료 사용. -> 비싼거부터 사용.
	 * 나머지중 가장 비싼 케이블만 비용지불.
	 * 비용의 최솟값 구하기.
	 * k개 이하로 쓰는것이 best
	 * 우선순위 : 사용한 케이블 개수 오름차순 -> 총비용 오름차순
	 * */
	
	static class Computer implements Comparable<Computer>{
		int num;
		int cost;
		
		public Computer(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Computer o) {
			return this.cost - o.cost;
		}
	}
	
	static int n, p, k;
	static List<ArrayList<Computer>> list;
	static int distCost[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		distCost = new int[n+1];
		
		list = new ArrayList<>();
		for(int i = 0; i<=n; i++) {
			list.add(new ArrayList<Computer>());
		}
		
		int end = Integer.MIN_VALUE;
        int start = 0;
		for(int i = 0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			end = Math.max(end, c);
			list.get(a).add(new Computer(b, c));
			list.get(b).add(new Computer(a, c));
		}
		
		int answer = Integer.MIN_VALUE;
        //이분 탐색으로 중간값(지불 비용)기준 BFS탐색
        while(start<=end){
            int mid = (start + end)/2;
            if(solution(mid)){ // n도착 가능시 최솟값 예정치를 내린다. 이분탐색.
                answer = mid;
                end = mid-1;
            }else // 도착 못할시 예정치 올린다.
                start = mid+1;
        }
        
        if(answer == Integer.MIN_VALUE)
        	System.out.println(-1);
        else
        	System.out.println(answer);
	}
	private static boolean solution(int mid) {
		Arrays.fill(distCost, Integer.MAX_VALUE);
		PriorityQueue<Computer> que = new PriorityQueue<>();
		que.add(new Computer(1, 0));
		distCost[1] = 0;
		
		while(!que.isEmpty()) {
			Computer now = que.poll();
			
			if(distCost[now.num] < now.cost) continue;
			
			for(Computer next : list.get(now.num)) {
				int nextCost = now.cost;
				if(next.cost > mid) nextCost++;
				
				if(nextCost < distCost[next.num]) {
					distCost[next.num]= nextCost;
					que.add(new Computer(next.num, nextCost));
				}
			}
			
		}
		return distCost[n] <= k;
	}
}
