
public class FMain3 {
	
	
	public static void test(int q) {//test�� ��������
		// �̶� ������ �� q�� main���� q�� ������ �ͼ� ����Ѵ�.
		System.out.println(q);//10 test�� ��������
		q = 20;
		System.out.println(q);//20 test�� ��������
	}
	
public static void main(String[] args) {
	
	int q = 10;// main �Լ� �������� yellow
	System.out.println(q);//10 main �Լ� �������� yellow
	test(q);			
	System.out.println(q);//10 main �Լ� �������� yellow
	
}
}
