import java.util.Scanner;

public class YMain1 {
	// ATM����� �ϴ� ���α׷�
	// 1�� ���� ���� / 2�� ���� ���/ 3�� ���� �ܰ� Ȯ�� / 4�� ���� ���α׷��� ����
	public static int Deposit() {
		return new Scanner(System.in).nextInt();
	}
	public static int depositResult(int balance,int deposit) {
		return balance + deposit;
	}
	public static int Withdraw() {
		return new Scanner(System.in).nextInt();
	}
	
	public static int withdrawResult(int balance,int deposit) {
		return balance - deposit;
	}

	public static void Finish() {

	}

	// �� ���� �Է��� ���� ��(�Ա�, ���)
	// main �Լ���!
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int button = 0;
		int balance = 0;
		while(button != 4) {
			System.out.println("1�� ���� �Ա� / 2�� ���� ���/ 3�� ���� �ܰ� Ȯ�� / 4�� ���� ���α׷��� ����");
			 button = scan.nextInt();
			 
			 if(button == 1) {//����
				 System.out.println("�Ա��� �����ϼ̱���. ���� �ݾ��� �Է����ּ���");
				int deposit = Deposit();
				if(deposit >=0) {
					System.out.printf("%d�� �Ա��մϴ�.\n", deposit);
					System.out.println();
					balance = depositResult(balance, deposit);
				}else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���");
					System.out.println();
					continue;
				}
			}
			 else if(button == 2) {//���
				 System.out.println("����� �����ϼ̱���. ����� �ݾ��� �Է����ּ���");
				int withdraw = Withdraw();
					if(withdraw >=0) {
						System.out.printf("%d�� ��� �մϴ�.\n", withdraw);
						System.out.println();
						balance = withdrawResult(balance, withdraw);
					}else {
						System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���");
						System.out.println();
						continue;
					}
					
				 
			 }else if(button == 3) {//�ܰ� Ȯ��
				 System.out.println("�ܰ�Ȯ���� �����̱���.");
					System.out.printf("�ܰ�� %d�� ���ҽ��ϴ�.\n",balance);
					System.out.println();
				}
			 
			 else if(button == 4) {// ���α׷� ����
				 System.out.println("���α׷��� �����մϴ�.");
			 }
			 else{
				 System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
				 System.out.println();
				 continue;
			 }
		}
		
		//switch���� ���� ������ ���α׷� ������ ��쿡�� while�� �̸� ������ �����Ű�� ����� �ִ�. a : while// break a;
	}
}
