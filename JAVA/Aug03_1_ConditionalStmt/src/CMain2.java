import java.util.Scanner;

public class CMain2 {
	// 숫자하나를 입력
	// 입력 받은 정수 값이 5보다 크면 새로운 변수 y에 정수 10을 담아서 출력
	// 입력 받은 정수 값이 3보다 크면 새로운 변수 y에 정수 20을 담아서 출력

	
	//if문 안에 변수를 만들면
	//if문이 돌아가면서 계속해서 int y를 생성하고 있음!
	//		->효율적이지 않다.
	//if문 바깥에다가 변수를 생성하고
	//if문 안에서 값을 '변경'(할당) 할 수 있게 하는 것이 효율적
	
	
	public static int checkNumber(int a) {
		int y = 0;
		if (a > 3) {
			if (a > 5) {
				y = 10;
			} else
				y = 20;
		}
		else y = a;//다음과 같이 else문을 만들던가 처음부터 y를 초기화 하지 않으면 에러가 발생하게 된다. 
		return y;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int k = scanner.nextInt();

		System.out.println(checkNumber(k));
	}
}
