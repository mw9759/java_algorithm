package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1202_보석도둑{

	static class Gem implements Comparable<Gem>{
		int weight;
		int cost;
		
		public Gem(int weight, int cost) {
			this.weight = weight;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Gem o) {
			if(this.weight == o.weight) {
				return o.cost - this.cost;
			}
			return this.weight - o.weight;
		}
	}
	
	static int n, k, bag[];
	static Gem gems[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		gems = new Gem[n];
		bag = new int[k];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			gems[i] = new Gem(w, c);
		}
		
		Arrays.sort(gems);
		
		for(int i = 0; i<k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		
		long answer = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i = 0, j = 0; i<k; i++) {
			
			while(j < n && gems[j].weight <= bag[i]) {
				que.add(gems[j++].cost);
			}
			
			if(!que.isEmpty()) answer += que.poll();
		}
		
		System.out.println(answer);
	}

}
