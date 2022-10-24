//변수 왜 만드나요? : 데이터 저장하려고 -> Memory상의 공간에!!
//	변수 : 데이터를 저장하는 공간(그릇)
//	객체는 왜 만드나요? : 실생활스러운 변수(속성)을 만들어서 알아보기 편하게 하려고!!
//			-> static 없는 method 가지고 오려고!
public class Calculator {
	public static void sum(int x, int y) {
		//멤버변수가 없음 -> 저장할게 없음
		//					->계산기 객체를 만들 필요가 없음.
		//					-> static 메소드를 기반으로 만들면 된다.
		System.out.println(x + y);
	}
	public void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

}
