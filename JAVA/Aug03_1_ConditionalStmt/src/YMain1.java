import java.util.Scanner;

public class YMain1 {
	//���� �ϳ��� �Է¹޴� �Լ� ��, 3���� ���� �ϳ��� �Է¹޴µ� 3���� ũ�ų� ���� �� �ٽ� �Է� ���� �� �ֵ��� ����
	public static int InputInt() {
		System.out.print("���� : ");
	int a =	new Scanner(System.in).nextInt();
	return a<3?a:InputInt();//Input->Input->Input->a
					  //main <- a <-  a  <-  a	<-
	}
	
	//Ȧ���� �Է¹��� �� �ִ� �Լ� => ¦�� �Է½� �ٽ� �Է� ���� �� �ֵ��� 
	public static int InputOdd() {
		System.out.print("���� : ");
	int a =	new Scanner(System.in).nextInt();
	return a%2 == 1?a:InputOdd();//Input->Input->Input->a
					  //main <- a <-  a  <-  a	<-
	}
	
	//������ �Է� �޴� �Լ� => 0~100
	public static int Input0_100() {
		System.out.print("0~100 : ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		return 0 <= a && a <=100?a:Input0_100();
	}
	
public static void main(String[] args) {
	System.out.println(InputInt());
	System.out.println(InputOdd());
	System.out.println(Input0_100());
}
}
