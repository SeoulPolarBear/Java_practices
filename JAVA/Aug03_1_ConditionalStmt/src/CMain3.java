import java.util.Scanner;

public class CMain3 {

	public static void main(String[] args) {
		//정수 하나 입력 받을 수 있게
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 하나 입력해라 : ");
		int x = scanner.nextInt();
		
		//조건문 : if, switch ~ case
		
		
		//switch 문 : 비교 조건이 특정한 값이나 문자열인 경우 사용
		//break;를 이용해서 각 조건이 만족하면 switch문이 깨지도록 할 수 있다.
		/*
		 * switch (변수 or 식) { 
		 * case 값 A: 
		 * 변수 or 식의 값이 A일 때 이 부분이 실행 
		 * break;
		 * 
		 * case 값 B: 
		 * 변수 or 식의 값이 B일 때 이 부분이 실행 
		 * break;
		 * 
		 * default: 
		 * A or B가 아닐 때 이 부분이 실행이 된다.
		 * break; 
		 * }
		 */
		
		switch (x) {
		case 1:
			System.out.println("ㅋ");
			break;
			
		case 2:
			System.out.println("ㅎ");
			break;
			
		case 3:
			System.out.println("ㅠㅠ");
			break;

		default:
			System.out.println("졸려...");
			break;
		}
	}
}
