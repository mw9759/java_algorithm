package inflearn.ch08;

import java.util.Scanner;

public class 조합의경우의수_메모이제이션 {
	static int n,r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		arr = new int[n+1][n+1];
		System.out.println(dfs(n, r));
	}
	
	
	static int arr[][];
	private static int dfs(int n, int r) {
		if(arr[n][r]>0) return arr[n][r];
		if(n == r || r == 0) return 1;
		else return arr[n][r] = dfs(n-1, r-1)+dfs(n-1, r);
	}

}
