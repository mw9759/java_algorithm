package java_algorithm.BJ;

import java.util.Arrays;
import java.util.Comparator;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[] {1, 3, 2, 5, 4, 5, 2, 3};
		int s = solution(6, a);
		System.out.println(s);
	}

	public static int solution(int k, int[] tangerine) {
        int answer = 0;
        int arr[] = new int[10000001];
        
        for(int i = 0; i<tangerine.length; i++){
        	if (arr[tangerine[i]] == 0) {
                arr[tangerine[i]] = 0;
            }
            arr[tangerine[i]]++;
        }
        Integer tmp[] = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder());
        
        
        int n = 0;
        while(k>0){
            k -= arr[n];
            answer++;
            n++;
        }
        return answer;
    }
}
