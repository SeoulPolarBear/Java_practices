import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.Calendar;

public class VMain2 {
	public static void main(String[] args) {
		//�������
		String name = "�������";
		//���� : 1000��
		int price = 1000;
		//80ml
		int volume = 80;
		//�� : ü������
		String incense = "ó������";
		//��� 99.9%
		double antivirus=99.9;
		//����
		String color = "��";
		//ȸ�� : ���̼�
		String Co = "���̼�";
		//��Ȱ�� boolean
		boolean recycle = true;
		//���
		
		System.out.printf("���� : %s \n", name);
		System.out.printf("���� : %d�� \n", price);
		System.out.printf("�뷮 : %dml \n", volume);
		System.out.printf("�� : %s \n", incense);
		System.out.printf("��� : %.1f%% \n", antivirus);
		System.out.printf("�� : %s�� \n", color);
		System.out.printf("ȸ�� : %s \n", Co);
		System.out.printf("��Ȱ�� : %b \n", recycle);
		
		//�̸� ,���� ��¥(����, ��, ��), ��� ��(����), �÷�, java���� ����
		String myname = "Lim";
		Calendar time = Calendar.getInstance();// Calendar �߻� Ŭ����
		
		int year = time.get(Calendar.YEAR);
		int month = time.get(Calendar.MONTH) + 1;
		int day = time.get(Calendar.DATE);
		
		String place = "Seoul";
		int eyes = -11;
		boolean java =true;
		
		System.out.printf("�̸� : %s \n", myname);
		System.out.printf("���� ��¥ : %d.%02d.%02d \n", year,month,day);
		System.out.printf("��°� : %s \n", place);
		System.out.printf("�÷� : %d \n", eyes);
		System.out.printf("java���� ���� : %b \n", java);
		
	}
}
