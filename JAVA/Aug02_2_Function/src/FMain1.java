import java.util.Scanner;

public class FMain1 {
	//���� �ΰ��� ������, �� �߿� ū ���ڸ� ������ִ� �Լ�
	public static void Max(int a, int b) {
		System.out.println(a>b?a:b);
	}
	
	//�Ǽ� �ΰ��� ������, �� �߿� ū ���ڸ� �����ִ� �Լ�
	public static double Maxnum(double a, double b) {
		return a>b?a:b;
	}
	
	public static void main(String[] args) throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("2���� ���ڸ� �Է��Ͻÿ� : ");
		int Operand1 = scanner.nextInt();
		int Operand2 = scanner.nextInt();
		double Operand3 = scanner.nextDouble();
		double Operand4 = scanner.nextDouble();
		Max(Operand1,Operand2);
		System.out.println(Maxnum(Operand3,Operand4)); 
		Thread.sleep((int)Maxnum(Operand3,Operand4)*1000);
		
		
	}
}
