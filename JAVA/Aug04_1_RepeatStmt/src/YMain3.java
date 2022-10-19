import java.util.Scanner;

public class YMain3 {
	public static int IntputF1() {
		// f1 : 정수를 하나 입력 받아서
		System.out.println("정수하나 입력해 주세요");
		int f1 = new Scanner(System.in).nextInt();
		return f1;
	}

	public static int IntputF2() {
		// f2 : 정수를 하나 입력 받아서
		System.out.println("정수하나 입력해 주세요");
		int f2 = new Scanner(System.in).nextInt();
		return f2;
	}

	public static void outputNum(int f1) {
		if (f1 > 0) {
			System.out.println("양");
		} else if (f1 == 0) {
			System.out.println("0");
		} else {
			System.out.println("음");
		}
	}

	public static String outputNum2(int f2) {
		// 3의 배수면 3의 배수
		// 3가 아니고 4의 배수면 4의 배수
		// 도 아니면 몰라
		// 을 판정해주는 한수
		if (f2 % 12 == 0)
			return "3과 4의 배수";
		else if (f2 % 3 == 0)
			return "3의배수";
		else if (f2 % 4 == 0)
			return "4의배수";
		else
			return "몰라";
	}

	public static void main(String[] args) {
		outputNum(IntputF1());
		System.out.println(outputNum2(IntputF2()));

	}

}
