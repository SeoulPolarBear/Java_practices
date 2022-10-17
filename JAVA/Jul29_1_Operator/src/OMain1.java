import java.util.Scanner;

public class OMain1 {
	public static void main(String[] args) {
		//변수
		//자료형 변수명 = 값;
		//=(대입연산자)
		//A = B
		//우항에 있는 것을 좌항에 넣어라.
		//변수에 값을 넣을 때 사용
		
		//사칙연산(Scanner + 출력) : 산술 연산자
		// 숫자는 2개만 입력 받음 (x,y)
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("피연산자 2개의 값을 입력하시오.");
		System.out.print("x : ");
		double x = scanner.nextDouble();
		System.out.print("y : ");
		double y = scanner.nextDouble();
		
		System.out.printf("+ : %.3f  - : %.3f  * : %.3f  / : %.3f  %% : %.3f\n", x + y, Math.abs(x - y), x * y, x / y, x % y );
		
		//int x, int y시 (double) x / y = double 왜? (double) x가 일단 double로 변하기 때문, %는 remainder라고 한다.
		
		//x = 10; y = 4;
		//print(x), print(y)
		//x = y;
		//print(x), print(y)
		//result : 10 4 4 4
		
		//대입 연산자 활용
		//+= , -=, *=, /=, %=
		
		x += 1; //x = x + 1
		x -= 1;
		x *= 3;
		x /= 10;
		x %= 10;
		
		//++,--
		
		y = x++;// x = y 후 x += 1
		y = ++x; // x += 1 후 x = y
		System.out.println(x);
		
		
		
	}
}
