
public class RMain3 {
	public static void main(String[] args) throws InterruptedException {
		// �ʽð�
		// ���� �� �� �� => ������ for�� �̿�
		// 1�ʸ��� �� ���� ����

		System.out.println("���� ����");
		for (int day = 0; day < 30; day++) {
			for (int hour = 0; hour < 24; hour++) {
				for (int min = 0; min < 60; min++) {
					for (int sec = 0; sec < 60; sec++) {
						System.out.printf("[Day%02d] %02d:%02d:%02d\n", day, hour, min, sec);
						Thread.sleep(1000);
					}
				}
			}
		}
	}
}
