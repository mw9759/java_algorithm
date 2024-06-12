package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_14725_개미굴 {

	static class Trie{
		TreeMap<String, Trie> children;
		
		public Trie() {
			this.children = new TreeMap<>();
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static Trie trie = new Trie();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			
			Trie cur = trie;
			
			for(int j = 0; j<m; j++) {
				String word = st.nextToken();
				
				cur.children.computeIfAbsent(word, key -> new Trie());
				
				cur = cur.children.get(word);
			}
		}
		
		print(0, trie);
		System.out.println(sb);
	}

	private static void print(int depth, Trie cur) {
		
		for(String word : cur.children.keySet()) {
			for(int i = 0; i<depth; i++) {
				sb.append("--");
			}
			sb.append(word+"\n");
			print(depth+1, cur.children.get(word));
		}
	}

	

}
