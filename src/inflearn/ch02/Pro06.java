package inflearn.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Pro06 {
	public static List solution(int n, int[] arr) {
		List<Integer> answer = new ArrayList<>();
		List<Integer> reverse = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			if(arr[i]>9) {
				int a = arr[i];
				int s = 0;
				while(a>0) {
					s = s*10 + a%10;
					a/=10;
				}
				reverse.add(s);
			}else reverse.add(arr[i]);
		}
		
		for(int i = 0; i<reverse.size(); i++) {
			boolean check = true;
			if(reverse.get(i)>1) {
				for(int j = 2; j<reverse.get(i); j++) {
					if(reverse.get(i)%j == 0) {
						check =false;
						break;
					}
				}
				if(check) {
					answer.add(reverse.get(i));
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> answer = solution(n,arr);
		for(int s : answer) {
			System.out.print(s+" ");
		}
		
	}

}
