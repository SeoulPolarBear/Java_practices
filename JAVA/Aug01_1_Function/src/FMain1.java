//함수 (Function)
//	관련있는 기능(작업)들을 묶고
//	필요할 때마다 불러서(호출해서) 사용이 가능
public class FMain1 {

//public static 리턴타입 함수명 (parameter, ...){
//	내용
//	return 
//}

	// 리턴타입 : 반환될 값의 자료형
	// 함수 내에서 식이 완성이 되고, main으로 반환할 결과 값에 대한 자료형
	// return이라는 것을 사용해서 반환을 할 것이고, 사용은 이따가

	/*
	 * 함수명 : 말 그대로 이 함수의 이름 1. 숫자로 시작하면 -> 에러 2. 특수문자, 띄어쓰기 -> 에러 3. 자바문법(예약어) -> 에러
	 * _이용하면 막을 수 있다. Java의 문화) 4. 함수명을 봐도 무슨 기능이니 알 수 있게 5. 소문자로 시작 6. 가독성을 위해서 뱀체
	 * : abcd_efg_hijk 낙타체 : abcdEfghijk 7. 한글은 사용하지 않는다.
	 * 
	 * 변수명 vs 함수명 : 변수명 지을 때 : 명사처럼/ 함수명 지을 때 : 동사처럼 지으면 된다.
	 * 
	 * 파라미터(인자, parameter) : 함수를 실행하는데 필요한 재료 주의할 점 : 필요한 개수만큼 사용하되, 자료형에 맞춰서
	 * 사용해야한다.
	 * 
	 * JDK(자바 개발키트) -> JRE(자동 실행환경) 실행 시 JRE가 OS(운영체제)에 맞춰서 -> JVM(자바 가상머신)
	 * ->WORE(Write Once Anywhere - Java의 장점!
	 */

	public static void myIntroduce() {
		System.out.println("이름 : 임성환");
		System.out.println("핸드폰 번호 : 비밀");
		System.out.println("사는 곳 : 서울");
	}
	
	public static double Operation(double a,double b,String c) {
		double result = 0;
		switch (c) {
		case "+":
		result = a+b;
		break;
		
		case "-":
			result = a-b;
			break;
			
		case "*":
			result = a*b;
			break;
			
		case "/":
			result = a/b;
			break;
			
		case "%":
			result = a%b;
			break;
			
		case "//":
			result = (int)a / (int)b;
			break;

		}
		return result;
	}
	
	public static void test(int b) {//파라미터 값으로 불러온고 그 다음 함수 안에 있는 내용이 진행이 되어서 그림상 b가 먼저 stack에 쌓이게 됨
		int a = 123;
		System.out.println(b);//30
		System.out.println(a + b);//153
	}

	// 실행시 JVM이 main을 자동으로 호출
	// 우리가 자동완성해서 사용할 이 main도 사실 함수의 일종!
	public static void main(String[] args) {
		myIntroduce();
		
//		System.out.print("피연산자 2가지 수 및 연산을 적어주세요.(+,-,*,/,%,//) : ");
//		Scanner scanner = new Scanner(System.in);
//		double a = scanner.nextDouble();
//		double b = scanner.nextDouble();
//		String operate = scanner.next();
//		System.out.println(Operation(a,b,operate));   
		
		int a = 10;
		int b = 20;
		int c = 30;
		
		test(c);//30, 153
		
		System.out.println(b);//20

	}

}
