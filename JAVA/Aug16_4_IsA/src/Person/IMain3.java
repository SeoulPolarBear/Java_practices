package Person;

public class IMain3 {
	public static void main(String[] args) {
		//ȫ�浿 17�� �Ǳ� ����б� 1�г�
		//��浿 21�� ���հ��� 2�г�
		//��浿 22�� ���� ��
		Student student1 = new Student("ȫ�浿", 17, "�Ǳ� ����б�", 1);
		Student student2 = new Student("��浿", 21, "���հ����б�", 2);
		Soldier soldier = new Soldier("��浿", 22, "����", "��");
		student1.printInfo();
		student2.printInfo();
		soldier.printInfo();
	}
}
