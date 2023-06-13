package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) 	throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> arr = new HashMap<String, Integer>();
		String nameArr[] = new String[n];
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			arr.put(str,i);
			nameArr[i] = str;
		}
		
		for(int i = 0; i<m; i++) {
			String str = br.readLine();
			int num = (int) str.charAt(0);
			if(num>=48 && num<=57) {
				sb.append(nameArr[Integer.parseInt(str)-1]);
				sb.append("\n");
			}
			else {
				sb.append(arr.get(str)+1);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
