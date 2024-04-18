package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719_빗물 {

	static int h, w;
	static int arr[];
	static int maxL[], maxR[];
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		arr = new int[w];
		maxL = new int[w];
		maxR = new int[w];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<w; i++) {
			solution(i);
		}
		System.out.println(answer);
	}
	private static void solution(int now) {
		int mL = 0;
		int mR = 0;
		if(maxL[now-1]>arr[now] && maxR[now-1] != arr[now-1]) {
			mL = maxL[now-1];
			mR = maxR[now-1];
		}
		else {
			for(int i = now; i>=0; i--) {
				mL = Math.max(mL, arr[i]);
			}
			for(int i = now; i<w; i++) {
				mR = Math.max(mR, arr[i]);
			}
		}
		maxL[now] = mL;
		maxR[now] = mR;
		answer += mL>mR?mR-arr[now]:mL-arr[now];
	}

}
