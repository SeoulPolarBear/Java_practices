import java.util.Scanner;

public class CMain2 {
	// �����ϳ��� �Է�
	// �Է� ���� ���� ���� 5���� ũ�� ���ο� ���� y�� ���� 10�� ��Ƽ� ���
	// �Է� ���� ���� ���� 3���� ũ�� ���ο� ���� y�� ���� 20�� ��Ƽ� ���

	
	//if�� �ȿ� ������ �����
	//if���� ���ư��鼭 ����ؼ� int y�� �����ϰ� ����!
	//		->ȿ�������� �ʴ�.
	//if�� �ٱ����ٰ� ������ �����ϰ�
	//if�� �ȿ��� ���� '����'(�Ҵ�) �� �� �ְ� �ϴ� ���� ȿ����
	
	
	public static int checkNumber(int a) {
		int y = 0;
		if (a > 3) {
			if (a > 5) {
				y = 10;
			} else
				y = 20;
		}
		else y = a;//������ ���� else���� ������� ó������ y�� �ʱ�ȭ ���� ������ ������ �߻��ϰ� �ȴ�. 
		return y;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int k = scanner.nextInt();

		System.out.println(checkNumber(k));
	}
}
