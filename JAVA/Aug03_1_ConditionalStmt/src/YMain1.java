import java.util.Scanner;

public class YMain1 {
	//정수 하나를 입력받는 함수 단, 3보다 작은 하나를 입력받는데 3보다 크거나 같을 때 다시 입력 받을 수 있도록 설정
	public static int InputInt() {
		System.out.print("숫자 : ");
	int a =	new Scanner(System.in).nextInt();
	return a<3?a:InputInt();//Input->Input->Input->a
					  //main <- a <-  a  <-  a	<-
	}
	
	//홀수만 입력받을 수 있는 함수 => 짝수 입력시 다시 입력 받을 수 있도록 
	public static int InputOdd() {
		System.out.print("숫자 : ");
	int a =	new Scanner(System.in).nextInt();
	return a%2 == 1?a:InputOdd();//Input->Input->Input->a
					  //main <- a <-  a  <-  a	<-
	}
	
	//정수를 입력 받는 함수 => 0~100
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
