import java.util.Scanner;

public class RMain6 {
	public static void main(String[] args) {
		//�ݺ��� 10�� -> �ݺ��� 1�� �������� �ȳ��ϼ��� 3���� ���
		//=> ���ڱ� ���� 3�� ���� �ȵ�...
			for(int i = 0;i < 10; i++) {
				
				if(i == 3) {
					continue;
				}
				System.out.println(i);
				System.out.println("�ȳ��ϼ��� 1Ʈ");
				System.out.println("�ȳ��ϼ��� 2Ʈ");
				System.out.println("�ȳ��ϼ��� 3Ʈ");
		}
			
			for (int i = 0; i < 10; i++) {
				if(i%2==0) {
					System.out.println("��!");
				}else {
					/*
					 * continue;//���� ������ �Ѿ 
					 * break;//(����������) �ݺ����� ���� 
					 * return;//(�������), �Լ��� ��, �ݺ�����
					 * ����!
					 */				}
			}
				
				//�ڸ�Ʈ ������ �Է� ���� �ǵ�, ������ ��� �޾ƿð�
				//������ "����"�� �ݺ��� ��!
				String commentString = new Scanner(System.in).next();
				while(true) {
					System.out.println("��Ʈ ���� : ");
					commentString = new Scanner(System.in).next();
					
					if(commentString.equals("����")){
						System.out.println("�λ縦 ���� �޾��ֳ�");
						break;
					}
				}
				
			
	}
}
