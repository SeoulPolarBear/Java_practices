import java.util.Scanner;
public class ExchangeOperator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("100�� ����� ���� ������ �Է��ϼ���:");
		int won = scanner.nextInt(); // ���� �Է�
		int five_hundred_won = won/500;//500���� ���� ��
		int one_hundred_won = (won%500)/100;//500���� ���� �������� 100���� ���� ��
		
		System.out.print(won + "����");
		System.out.print("500����" + five_hundred_won + "��,");
		System.out.print("100����" + one_hundred_won + "�� �Դϴ�");
		
		scanner.close();
	
	}

}
