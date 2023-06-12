package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_1181_단어정렬 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String arr[] = new String[n];
		for(int i = 0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				else {
					return s1.length()-s2.length();
				}
			}
		});
		
		System.out.println(arr[0]);
		for(int i = 1; i<n; i++) {
			if(!arr[i-1].equals(arr[i])) {
				System.out.println(arr[i]);
			}
		}
	}

}
