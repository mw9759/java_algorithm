package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_문자열폭발_9953 {
	static String str;
	static String rmstr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		rmstr = br.readLine();
		solution();
	}
	
	private static void solution() {
		for(int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if(sb.length()>=rmstr.length()) {
				boolean flag = true;
				for(int j = 0; j<rmstr.length(); j++) {
					if(rmstr.charAt(j) != sb.charAt(sb.length()-rmstr.length()+j)) {
						flag = false;
						break;
					}
				}
				if(flag) sb.delete(sb.length()-rmstr.length(), sb.length());
			}
		}
		System.out.println(sb.length() == 0 ? "FRULA":sb);
	}
}
