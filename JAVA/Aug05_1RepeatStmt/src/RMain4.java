//for(���� �ʱ�ȭ; ���ǽ�; ���� ����)
public class RMain4 {
	public static void main(String[] args) {
		// 1~100������ ���� �߿��� 6�� ����� ���� ���� ���
		int sum = 0;
		for (int i = 1; i * 6 < 100; i++) {
			sum += i * 6;
		}
		System.out.println(sum);

		// 4x + 5y = 60�� �Ǵ� ��(����)�� ��� ���ؼ�
		// (x,y)�� ���·� ���
		// x,y�� �� �� 10������ ����(1~10)
		int x = 0;
		for (int j = 1; j <= 10; j++) {
			for (int i = 1; i * 4 + j * 5 <= 60; i++) {
				if (i * 4 + 5 * j == 60) {
					System.out.printf("(%d, %d)\n", i, j);
				}
			}
		}

	}
}
