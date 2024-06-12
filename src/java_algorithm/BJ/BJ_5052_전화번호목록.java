package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_5052_전화번호목록 {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] numbers = new String[n];
			
			for(int i = 0; i<n; i++) {
				numbers[i] = br.readLine();
			}
			
			Arrays.sort(numbers);
			
			boolean isOk = check(n, numbers);
				
			
			System.out.println(isOk ? "YES" : "NO");
		}
	}
	
	public static boolean check(int n, String[] sortNumbers) {
		for(int i = 0; i<n-1; i++) {
			
			if(sortNumbers[i+1].startsWith(sortNumbers[i])) {
				
				return false;
			}
		}
		
		return true;
	}
}
