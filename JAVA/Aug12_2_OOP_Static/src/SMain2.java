//����
// ���� 2���� ������ �� ���� ����ϴ� ���
// 
public class SMain2 {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.sum(3, 4);
		calculator.sum(1,3,4);
		Calculator.sum(30, 50);// static -> �޸𸮸� �� ���� �ذ� ( ��������)
		//Calculator.sum(0, 0, 2); ���� : Ŭ���� �Լ� �̹Ƿ� static�� �����Ƿ�
		
		//���� �ƶ����� Java�� ���� Ŭ���� �� �ϳ��� Math
		//�̰� ���� ��ü�� ������ �ʰ� ����� ���!
		System.out.println(Math.PI);
	}

}
