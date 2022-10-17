import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.Calendar;

public class VMain2 {
	public static void main(String[] args) {
		//섬유향수
		String name = "섬유향수";
		//가격 : 1000원
		int price = 1000;
		//80ml
		int volume = 80;
		//향 : 체리블라썸
		String incense = "처리블라썸";
		//향균 99.9%
		double antivirus=99.9;
		//무색
		String color = "무";
		//회사 : 다이소
		String Co = "다이소";
		//재활용 boolean
		boolean recycle = true;
		//출력
		
		System.out.printf("종류 : %s \n", name);
		System.out.printf("가격 : %d원 \n", price);
		System.out.printf("용량 : %dml \n", volume);
		System.out.printf("향 : %s \n", incense);
		System.out.printf("향균 : %.1f%% \n", antivirus);
		System.out.printf("색 : %s색 \n", color);
		System.out.printf("회사 : %s \n", Co);
		System.out.printf("재활용 : %b \n", recycle);
		
		//이름 ,오늘 날짜(연도, 월, 일), 사는 곳(지역), 시력, java경험 유무
		String myname = "Lim";
		Calendar time = Calendar.getInstance();// Calendar 추상 클래스
		
		int year = time.get(Calendar.YEAR);
		int month = time.get(Calendar.MONTH) + 1;
		int day = time.get(Calendar.DATE);
		
		String place = "Seoul";
		int eyes = -11;
		boolean java =true;
		
		System.out.printf("이름 : %s \n", myname);
		System.out.printf("오늘 날짜 : %d.%02d.%02d \n", year,month,day);
		System.out.printf("사는곳 : %s \n", place);
		System.out.printf("시력 : %d \n", eyes);
		System.out.printf("java경험 유무 : %b \n", java);
		
	}
}
