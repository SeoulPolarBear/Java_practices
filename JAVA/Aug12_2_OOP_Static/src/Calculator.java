//���� �� ���峪��? : ������ �����Ϸ��� -> Memory���� ������!!
//	���� : �����͸� �����ϴ� ����(�׸�)
//	��ü�� �� ���峪��? : �ǻ�Ȱ������ ����(�Ӽ�)�� ���� �˾ƺ��� ���ϰ� �Ϸ���!!
//			-> static ���� method ������ ������!
public class Calculator {
	public static void sum(int x, int y) {
		//��������� ���� -> �����Ұ� ����
		//					->���� ��ü�� ���� �ʿ䰡 ����.
		//					-> static �޼ҵ带 ������� ����� �ȴ�.
		System.out.println(x + y);
	}
	public void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

}
