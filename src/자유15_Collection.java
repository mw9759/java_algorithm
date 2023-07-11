import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class 자유15_Collection {

	public static void main(String[] args) {
		// 현재 날짜 구하기
        LocalDate now = LocalDate.now();
 
        // 포맷 정의
        // 현재 년도
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        int formatedNowYear = Integer.parseInt(now.format(formatter));
        // 현재 월
        formatter = DateTimeFormatter.ofPattern("MM");
        int formatedNowMonth = Integer.parseInt(now.format(formatter));
        // 월별 일수 초기화
        int monthDate[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 만약 2월이면 일 수 재정의
        if(formatedNowMonth == 2) {
        	if(formatedNowYear%4 == 0) {
        		if(formatedNowYear%100 == 0) {
        			if(formatedNowYear%400 == 0) {
        				monthDate[2] = 29;
        			}
        		}
        		monthDate[2] = 29;
        	}
        }
        //출력
        System.out.println(monthDate[formatedNowMonth]);
        
        
	}

}
