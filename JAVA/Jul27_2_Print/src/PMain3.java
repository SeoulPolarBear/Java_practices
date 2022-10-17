
public class PMain3 {
	public static void main(String[] args) {
		//print
		System.out.print("1asdf\n");
		System.out.print("2asdf\n");
		
		//printf f: format
		
		//System.out.printf("%?", 값);의 형태
		
		//정수 (decimal)
		//%d : 정수 데이터가 들어올 자리(decimal, 10진수) -> 모든 언어 공통
		System.out.printf("%d\n", 100);
		//%xd : (x는 임의의 정수) 빈자리가 띄어쓰기로 채워져서 출력
		System.out.printf("%4d\n", 100);
		// %0xd : 빈자리 만큼 그자리를 0으로 채워서 x자리의 숫자로 만들어준다.
		System.out.printf("%06d\n", 100);
		//실수 (float)
		//%f : 실수데이터가 들어올 자리
		// %.xf : 소수점 이하의 자릿수 (잘리는 부분 반올림 처리)
		//			빈자리는 0으로 채워준다.
		float m = 1000f;
		double k = 1000.0;
		System.out.printf("%.3f\n", m);
		System.out.printf("%f\n", k);
		System.out.printf("%.6f\n", 100.0);
		System.out.printf("%.10f\n", 100.1233246324);
		
		//문자열(String)
		//%s 
		//글자 : 그냥 입력하게 되면 Java의 문법으로 해석하기 때문에 -> 오류
		System.out.printf("%s\n","퇴근 시간");
		
		//오늘 날짜 기준으로 연도 -> xxxx년-xx월-xx일 날씨 : 더움 기온 : 32도 습도 30.71%
		// %% : %를 글자로 표현하고 싶을 때 (단 printf에서만 가능하다.)
		
		System.out.printf("%4d년-%02d월-%02d일 날씨 : %s 기온 : %d도 습도 %.2f%%", 2022,7,27,"더움",32, 30.711111);
		
	}
}
