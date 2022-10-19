import java.util.Scanner;
//재귀적 호출(recursive call)
//함수 속에서 자기 자신(이 함수)을 또 호출 -> 반복

//함수를 부른다 : 느린 작업 
//반복문 :
public class FMain7 {
//등차수열 
	// 정수를 하나 넣으면
	// 1 + 2 + .. + 그 숫자까지
	// 다 더한 값을 구해주는 함수를 구해라
	//
	public static int sum(int a) { return a == 1 ? a : a + sum(a - 1); }

	// 정수를 하나 넣으면 factorial 값을 구하는 함수
	public static int factorial(int b) { return b == 1 ? b : factorial(b - 1) * b;}

	// 피보나치 수열
	public static int fibonacci(int c) { return c == 1 || c == 2 ? 1 : fibonacci(c - 1) + fibonacci(c - 2); }

	public static void main(String[] args) throws Exception{
		
		
			System.out.print("숫자를 입력하시오. : ");
			System.out.println(sum(new Scanner(System.in).nextInt()));
			System.out.print("숫자를 입력하시오. : ");
			System.out.println(factorial(new Scanner(System.in).nextInt()));
			System.out.print("숫자를 입력하시오. : ");
			System.out.println(fibonacci(new Scanner(System.in).nextInt()));
	}
}
