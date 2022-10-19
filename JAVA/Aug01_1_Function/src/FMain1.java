//�Լ� (Function)
//	�����ִ� ���(�۾�)���� ����
//	�ʿ��� ������ �ҷ���(ȣ���ؼ�) ����� ����
public class FMain1 {

//public static ����Ÿ�� �Լ��� (parameter, ...){
//	����
//	return 
//}

	// ����Ÿ�� : ��ȯ�� ���� �ڷ���
	// �Լ� ������ ���� �ϼ��� �ǰ�, main���� ��ȯ�� ��� ���� ���� �ڷ���
	// return�̶�� ���� ����ؼ� ��ȯ�� �� ���̰�, ����� �̵���

	/*
	 * �Լ��� : �� �״�� �� �Լ��� �̸� 1. ���ڷ� �����ϸ� -> ���� 2. Ư������, ���� -> ���� 3. �ڹٹ���(�����) -> ����
	 * _�̿��ϸ� ���� �� �ִ�. Java�� ��ȭ) 4. �Լ����� ���� ���� ����̴� �� �� �ְ� 5. �ҹ��ڷ� ���� 6. �������� ���ؼ� ��ü
	 * : abcd_efg_hijk ��Ÿü : abcdEfghijk 7. �ѱ��� ������� �ʴ´�.
	 * 
	 * ������ vs �Լ��� : ������ ���� �� : ���ó��/ �Լ��� ���� �� : ����ó�� ������ �ȴ�.
	 * 
	 * �Ķ����(����, parameter) : �Լ��� �����ϴµ� �ʿ��� ��� ������ �� : �ʿ��� ������ŭ ����ϵ�, �ڷ����� ���缭
	 * ����ؾ��Ѵ�.
	 * 
	 * JDK(�ڹ� ����ŰƮ) -> JRE(�ڵ� ����ȯ��) ���� �� JRE�� OS(�ü��)�� ���缭 -> JVM(�ڹ� ����ӽ�)
	 * ->WORE(Write Once Anywhere - Java�� ����!
	 */

	public static void myIntroduce() {
		System.out.println("�̸� : �Ӽ�ȯ");
		System.out.println("�ڵ��� ��ȣ : ���");
		System.out.println("��� �� : ����");
	}
	
	public static double Operation(double a,double b,String c) {
		double result = 0;
		switch (c) {
		case "+":
		result = a+b;
		break;
		
		case "-":
			result = a-b;
			break;
			
		case "*":
			result = a*b;
			break;
			
		case "/":
			result = a/b;
			break;
			
		case "%":
			result = a%b;
			break;
			
		case "//":
			result = (int)a / (int)b;
			break;

		}
		return result;
	}
	
	public static void test(int b) {//�Ķ���� ������ �ҷ��°� �� ���� �Լ� �ȿ� �ִ� ������ ������ �Ǿ �׸��� b�� ���� stack�� ���̰� ��
		int a = 123;
		System.out.println(b);//30
		System.out.println(a + b);//153
	}

	// ����� JVM�� main�� �ڵ����� ȣ��
	// �츮�� �ڵ��ϼ��ؼ� ����� �� main�� ��� �Լ��� ����!
	public static void main(String[] args) {
		myIntroduce();
		
//		System.out.print("�ǿ����� 2���� �� �� ������ �����ּ���.(+,-,*,/,%,//) : ");
//		Scanner scanner = new Scanner(System.in);
//		double a = scanner.nextDouble();
//		double b = scanner.nextDouble();
//		String operate = scanner.next();
//		System.out.println(Operation(a,b,operate));   
		
		int a = 10;
		int b = 20;
		int c = 30;
		
		test(c);//30, 153
		
		System.out.println(b);//20

	}

}
