//oop
//static
//������
//��ü���� ����
//	A has a B : ��� has a �ڵ���
//	A is a B : �� is a ����
public class HMain1 {
	public static void main(String[] args) {
		// �̸��� û����, ���� û�������� ����
		// ������ ���

		Candy candy = new Candy("û����", "û������");
		candy.printInfo();

		// �̸� �Ե�, ��ġ�� ���, �������� 100���� ȸ��
		// �������
		Company company = new Company("�Ե�", "���", 100000);
		company.CompanyInfo();

		// û���� ������ �Ե����� �������.

		Computer computer = new Computer("i7-1234", 32, 500, new Company("�Ｚ����", "����", 3000000));
		computer.printInfo();
	}
}
