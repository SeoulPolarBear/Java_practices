//����
//1. ���� ������ �ҽ��� stack ������ ��(��������)
//2. static����������� static������ ��ġ
//3. JVM�� SMain1.main(...);�� ȣ��
//4. ����
public class SMain1 {
	public static void main(String[] args) {
		//���� ��ü
		//���� �̸�, �߷� ,����
		//����ϴ� ���
		
		
		Snack snack1 = new Snack("�����۽�", 550, 2500);
		Snack snack2 = new Snack("��īĨ", 450, 1500);
		
		//������ FINAL ������
//		snack1.manufacturer = "LIm";
		
		
		//���� �޸� �̹Ƿ� �ϳ��� ��ü���� �ٲٸ� �� �ٲ��.
//		System.out.println(snack1.manufacturer);
//		System.out.println(snack2.manufacturer);
//		System.out.println(Snack.manufacturer);
		System.out.println(snack1.MANUFACTURER);
		System.out.println(snack2.MANUFACTURER);
		System.out.println(Snack.MANUFACTURER);
		
		Snack.printTaste();
		//���� main���� ���ڰ�ü�� ���� ����
		//���� �̸� ���� �����ڸ� �� �� �ִ�.
	}
}
