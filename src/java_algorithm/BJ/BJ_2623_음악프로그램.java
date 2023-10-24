package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2623_음악프로그램 {

	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<HashSet<Integer>> list = new ArrayList<>();
		int count[] = new int[n+1];
		for(int i = 0; i<n+1; i++) list.add(new HashSet<>());
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			if(size == 0) continue;
			
			int pre = Integer.parseInt(st.nextToken());
			for(int j = 1; j<size; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if(!list.get(pre).contains(cur)) {
					list.get(pre).add(cur);
					count[cur]++;
				}
				pre = cur;
			}
		}
		
		Queue<Integer> result = new LinkedList<>();
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i<n+1; i++) {
			if(count[i] == 0) que.add(i);
		}
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			result.add(cur);
			for(int next : list.get(cur)) {
				count[next]--;
				if(count[next]==0) {
					que.add(next);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(result.size() == n) {
			while(!result.isEmpty()) {
				sb.append(result.poll());
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
		else {
			System.out.println(0);
		}
		
	}

}
