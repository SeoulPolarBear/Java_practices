public class PMain5 {
	//���� ����...!!
	//Call by Value, Call by Reference
	
	//��� ���� ����Ǿ����� ������ �� �־��...
	//Call by Value : ������ '��'�� �����ؼ� �Լ��� �Ķ���� ������ ����ϴ� ��
	//Call by Reference : ������ �����ϴ� �ּҰ�(������)�� �Ķ���͸� ������ ����ϴ� ��
	public static void test(int a, int[] b, int[] c) {// ��, int[] c = ���� c�� ���� ��(���纻); �̷��� ���� �ȴ�.
		System.out.println("b(green)" + b);//asdgaSDG
		System.out.println("c(green)" + c);//ASGFDAWEGWE ��, ���⼭ c�� ���� ���纻�̴�. 
		System.out.println("a(green)" + a);//10
		System.out.println(b[0]);//10
		System.out.println(c[0]);//10
		a = 100;
		b[0] = 100;//b�� test�� ���ο� �迭������ ���� b ���� ����Ű�� �ּҰ� main�� b�� �����Ƿ� �ּҸ� ã�ư� ���� �ٲٸ� ���� �ٲ��.
		//main�ʿ� ������ ��(������)
		//�⺻���� �������� ���� !
		
		//new int[] : �� �״�� ���ο� ��(new)
		//new int[] �� ����� -> ����� �� ���� ����(���Խ��� �ƴ϶�)
		
		
		
		c = new int[] {100, 200};//���� ������ �������Ƿ� �ᱹ �ٸ� �ּҸ� �ٽ� ���� �ȴ�. ��, c�� ���� �ٲ�� ���� ���󰣴�. 
		//main �Լ��� ������ �ٸ� c�� ����� �°� �̴� �ᱹ �Լ��� ������ c�� b�� ��������.
		System.out.println(b);
		System.out.println(c);
		System.out.println(a);//100
		System.out.println(b[0]);//100
		System.out.println(c[0]);//100
		
	}
	public static void main(String[] args) {
		int a = 10;
		int[] b = {10, 20};
		int[] c = {10, 20};
		System.out.println("b(red)" + b);//ASDFAEG
		System.out.println("c(red)" + c);//ASDGAWEG
		System.out.println("-------------------------------");
		test(a,b,c);
		System.out.println(a);//10
		System.out.println(b[0]);//100
		System.out.println(c[0]);//10(100���� �ؼ� Ʋ�Ⱦ���.)
		//�� ���濡 ������ ���� �ʾ���
		//test �Լ��� c�ʹ� �ٸ��� ������
	}
}

