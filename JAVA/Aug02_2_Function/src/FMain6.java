import java.util.Random;

public class FMain6 {
//랜덤한 정수를 하나 구하는 함수
	public static int getNumber() {
		return new Random().nextInt();
	}
//두 정수를 더한 값을 출력하는 함수
	
	public static int sumNumber(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		//랜덤한 정수를 2개 구해서...
		int a = getNumber();int b = getNumber();
		//그 2개의 수를 더한 값을 출력
		System.out.print("결과 : ");
		System.out.println(sumNumber(a,b));
	}
}
