import java.util.Scanner;

public class FMain1 {
	//정수 두개를 넣으면, 그 중에 큰 숫자를 출력해주는 함수
	public static void Max(int a, int b) {
		System.out.println(a>b?a:b);
	}
	
	//실수 두개를 넣으면, 그 중에 큰 숫자를 구해주는 함수
	public static double Maxnum(double a, double b) {
		return a>b?a:b;
	}
	
	public static void main(String[] args) throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("2개의 숫자를 입력하시오 : ");
		int Operand1 = scanner.nextInt();
		int Operand2 = scanner.nextInt();
		double Operand3 = scanner.nextDouble();
		double Operand4 = scanner.nextDouble();
		Max(Operand1,Operand2);
		System.out.println(Maxnum(Operand3,Operand4)); 
		Thread.sleep((int)Maxnum(Operand3,Operand4)*1000);
		
		
	}
}
