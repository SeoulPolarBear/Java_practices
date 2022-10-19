import java.util.Scanner;

// 정수 2개를 입력 받아서 (각각의 함수에)
// 그 정수 2개를 더했을 때 짝수면 결과를 return 아니면 값을 재입력
public class YMain2 {
	//X 값
	public static int getX() {
		System.out.print("x : ");
		int x = new Scanner(System.in).nextInt();
		return x;
	}
	//Y 값
	public static int getY() {
		System.out.print("y : ");
		int y = new Scanner(System.in).nextInt();
		return y;
	}
	//덧셈을 계산해서 결과를 리턴할 함수
	public static int sum(int x, int y) {
		int c = x + y;
		return c % 2 == 0 ? c : sum(getX(), getY());
	}

	public static void main(String[] args) {
		System.out.println("숫자 2개를 입력하시오. : ");
		System.out.println("정답 : " + sum(getX(), getY()));
	}
}
