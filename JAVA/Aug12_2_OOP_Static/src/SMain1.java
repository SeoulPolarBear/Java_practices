//정리
//1. 기계어 상태의 소스가 stack 영역에 깔림(차곡차곡)
//2. static멤버변수들이 static영역에 배치
//3. JVM이 SMain1.main(...);를 호출
//4. 실행
public class SMain1 {
	public static void main(String[] args) {
		//과자 객체
		//과자 이름, 중량 ,가격
		//출력하는 기능
		
		
		Snack snack1 = new Snack("프링글스", 550, 2500);
		Snack snack2 = new Snack("포카칩", 450, 1500);
		
		//오류뜸 FINAL 때문에
//		snack1.manufacturer = "LIm";
		
		
		//정적 메모리 이므로 하나의 객체에서 바꾸면 다 바뀐다.
//		System.out.println(snack1.manufacturer);
//		System.out.println(snack2.manufacturer);
//		System.out.println(Snack.manufacturer);
		System.out.println(snack1.MANUFACTURER);
		System.out.println(snack2.MANUFACTURER);
		System.out.println(Snack.MANUFACTURER);
		
		Snack.printTaste();
		//지금 main에는 과자객체가 없는 상태
		//과자 이름 몰라도 생산자를 알 수 있다.
	}
}
