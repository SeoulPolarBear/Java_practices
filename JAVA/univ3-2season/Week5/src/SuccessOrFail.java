import java.util.Scanner;
public class SuccessOrFail {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);// TODO Auto-generated method stub

		System.out.print("������ �Է��Ͻʽÿ�:");
		int score=scanner.nextInt();
		if(score>=80)
			System.out.println("�����մϴ�!�հ��Դϴ�.");
		
		scanner.close();
	}

}
