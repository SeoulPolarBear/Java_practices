
public class PMain3 {
	public static void main(String[] args) {
		//print
		System.out.print("1asdf\n");
		System.out.print("2asdf\n");
		
		//printf f: format
		
		//System.out.printf("%?", ��);�� ����
		
		//���� (decimal)
		//%d : ���� �����Ͱ� ���� �ڸ�(decimal, 10����) -> ��� ��� ����
		System.out.printf("%d\n", 100);
		//%xd : (x�� ������ ����) ���ڸ��� ����� ä������ ���
		System.out.printf("%4d\n", 100);
		// %0xd : ���ڸ� ��ŭ ���ڸ��� 0���� ä���� x�ڸ��� ���ڷ� ������ش�.
		System.out.printf("%06d\n", 100);
		//�Ǽ� (float)
		//%f : �Ǽ������Ͱ� ���� �ڸ�
		// %.xf : �Ҽ��� ������ �ڸ��� (�߸��� �κ� �ݿø� ó��)
		//			���ڸ��� 0���� ä���ش�.
		float m = 1000f;
		double k = 1000.0;
		System.out.printf("%.3f\n", m);
		System.out.printf("%f\n", k);
		System.out.printf("%.6f\n", 100.0);
		System.out.printf("%.10f\n", 100.1233246324);
		
		//���ڿ�(String)
		//%s 
		//���� : �׳� �Է��ϰ� �Ǹ� Java�� �������� �ؼ��ϱ� ������ -> ����
		System.out.printf("%s\n","��� �ð�");
		
		//���� ��¥ �������� ���� -> xxxx��-xx��-xx�� ���� : ���� ��� : 32�� ���� 30.71%
		// %% : %�� ���ڷ� ǥ���ϰ� ���� �� (�� printf������ �����ϴ�.)
		
		System.out.printf("%4d��-%02d��-%02d�� ���� : %s ��� : %d�� ���� %.2f%%", 2022,7,27,"����",32, 30.711111);
		
	}
}
