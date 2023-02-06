package ssafy.algorithm;

public class RecursiveCall {

	public static void main(String[] args) {
		m3(5);
	}
	
	static void m1() {
		System.out.println("m1()");
		//m1();
	}
	static int m2_cnt = 5;
	static void m2() {
		if(m2_cnt == 0) return;

		//선행 
		System.out.println("1 m2_cnt = "+ m2_cnt);
		
		m2_cnt--;
		m2();
		//후행
		System.out.println("2 m2_cnt = "+ m2_cnt);
	}
	
	static void m3(int m3_cnt) {
		if(m3_cnt == 0) return;

		//선행 
		System.out.println("1 m3_cnt = "+ m3_cnt);
		
		//m3_cnt--;
		//m3(m3_cnt);
		//m3_cnt++;
		m3(--m3_cnt);
		
		//후행
		System.out.println("2 m3_cnt = "+ m3_cnt);
	}
}

