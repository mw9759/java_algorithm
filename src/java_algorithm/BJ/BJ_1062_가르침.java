package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1062_가르침 {

	static int n, k;
	static String words[];
	static List<Character> need;
	static LinkedHashSet<Character> antic = new LinkedHashSet<>();
	static HashSet<Character> set;
	static int max = 0;
	static char visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// 필수로 배워야하는 개수가 5개. 이거보다 못배우면 읽을 수 있는 단어가 없음.
		if(k<5) {
			System.out.println(0);
			return;
		}
		
		words = new String[n]; // 읽으려는 단어들
		set = new HashSet<>(); // 읽으려면 배워야하는 알파벳
		visited = new char[k-5]; // 배운 알파벳 (조합) : 필수 5개 제외
		
		// 필수 알파벳 5개 
		antic.add('a');
		antic.add('n');
		antic.add('t');
		antic.add('i');
		antic.add('c');
		
		// 입력처리
		for(int i = 0; i<n; i++) {
			words[i] = br.readLine();
			// 앞4개 뒤4개 알파벳은 필수라 제외
			for(int j = 4; j<words[i].length()-4; j++) {
				if(antic.contains(words[i].charAt(j))) continue; // 필수일때 따로 배울 필요 없음.
				
				set.add(words[i].charAt(j)); // 배워야 하는 알파벳
			}
		}
		// set -> list : 인덱스조회 필요
		need = new ArrayList<Character>(set);
		
		
		// 필수제외) 배울수 있는 개수>=배워야하는개수 : 모든 단어 읽을 수 있음
		if(k-5>=need.size()) System.out.println(n);
		
		else {
			solution(0, 0);
			System.out.println(max);//최대읽을수있는개수
		}
	}

	public static void solution(int cnt, int start) {
		// 기저조건 : 필수제외) 배울수있는 개수만큼 배웠을때.(조합)
		if(cnt == k-5) {
			// 검증
			int nowCnt = 0;
			// 단어 배열 조회
			for(int i = 0; i<words.length; i++) {
				boolean isLearn = true; // 읽을 수 있는가
				// 필수제외) 배워야하는 알파벳
				for(int j = 4; j<words[i].length()-4; j++) {
					if(antic.contains(words[i].charAt(j))) continue; // 필수제외
					
					boolean flag = false; 
					//배운것인지
					for(char c : visited) { 
						// 배워야하는 알파벳이 배운 목록에 있을때 : 배움.
						if(c == words[i].charAt(j)) {
							flag = true;
							break;
						}
					}
					// 못배운 알파벳이라면 못배움 신호 바로전달 : 다음 알파벳 볼 필요없음. 어차피 못읽음.
					if(!flag) {
						isLearn = false;
						break;
					}
				}
				// 알파벳을 전부 배워 읽을 수 있는 경우 카운팅.
				if(isLearn) nowCnt++;
			}
			// 최대값 초기화
			max = Math.max(max, nowCnt);
			return;
		}
		
		// 조합 로직 : 중복x
		for(int i = start; i<need.size(); i++) {
			visited[cnt] = need.get(i);
			solution(cnt+1, i+1);
		}
	}
}
