
public class FMain4 {
//정수 2개를 넣으면 그 합을 출력해주는 함수
//만약 main class에 존재하는 함수에 static(정적할당)을 해주지 않으면 오류가 발생
//이유 : main함수에서 사용하기 위해서는 메모리에 할당이 되어 있는 상태로 존재를 해야 하는데
//함수에 static을 적어주지 않으면 main이 작동하는 도중에 함수가 종료가 되어서 호환성에 문제가 발생한다.
//따라서 main class에 존재하는 함수들은 반드시 함수 앞에 static을 붙여줘야한다.
	
	//오버로딩(overloading) ******** 고급기술 을 쓰는 이유 함수 값의 의미가 중요하다고 생각되기 때문에 사용된다.
	//함수명은 같게, parameter값을 다르게 하는 기술

	
	
	//	public static int sum(int a, int b) { ->단, 다음과 같이 return 값이 달라도 오버로딩은 안 된다.
	//		return a + b;
	//	}
	
	

	//호출할 때 어떤 값을 넣었느냐에 따라 함수가 불러지게 하는 기술
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	//정수 3개를 넣으면 그 합을 출력해주는 함수
	public static void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	//실수 3개를 넣으면 그 합을 출력해주는 함수
	public static void sum(double a, double b, double c) {
		System.out.println(a + b + c);
	}
	
	
//	===========================================================
	
	//정수 1개를 넣으면 -> 윽!
	public static void printString(int a) {
		System.out.println("윽!");
	}
	//문자열 1개를 넣으면 -> 악! 출력
	public static void printString(String b) {
		System.out.println("악!");
	}
	//실수 1개를 넣으면 -> 으아아악! 출력
	public static void printString(double c) {
		System.out.println("으아아악!");
	}
	//아무것도 넣지 않으면 -> ... 출력
	public static void printString() {
		System.out.println("...");
	}
	//오버로딩의 예시 ex)print, println, printf
	
	
	public static void main(String[] args) {
		sum(3,2);
		sum(3,2,3);
		sum(3.0, 1.0, 4.0);
		
		printString("g");
	}
}
