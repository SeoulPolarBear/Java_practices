import java.util.Scanner;

public class PMain2 {
	public static void main(String[] args) {
		System.out.println("1~5 ���� �Է��� �ּ���. : ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();// 1~5

		int[] checknum = { 0, 0 };
		int n = 0;
		double[] score = new double[100];
		while (num != 5) {
			// 1�� �Է��ϸ� �л� �� ���� �Է� ���� �� �ְ�
			if (num == 1 && checknum[0] == 0) {
				System.out.println("�л� ���� �Է��� �ּ���.");
				n = scanner.nextInt();
				System.out.printf("�л����� %d�� �Դϴ�.\n", n);
				checknum[0] = 1;
			} else if (num == 1 && checknum[0] == 1) {
				System.out.println("�̹� �л� ���� �Է��ϼ̽��ϴ�.");
			}

			// 2�� �Է��ϸ� �� �л����� ������ �Է� ���� �� �ְ�(���� ������ ��� X)
			else if (num == 2 && checknum[0] == 1) {
				if (checknum[1] == 0) {
					System.out.printf("�л��� %d���� ������ �Է��� �ּ���.\n", n);
					for (int i = 0; i < n; i++) {
						score[i] = new Scanner(System.in).nextDouble();
					}
					checknum[1] = 1;
				} else {
					System.out.println("�̹� ������ �Է��ϼ̽��ϴ�.");
				}

			} // 3�� �Է��ϸ� �л����� ��������Ʈ�� ��� �� �� �ְ�(ex : 1�� �л� ���� : 50��)
				// 4�� �Է��ϸ� �ְ� ������ ��������� �м��ؼ� ��� �� �� �ְ�
				// 5�� �Է��ϸ� ���α׷� ����
			else if (checknum[0] == 1 && checknum[1] == 1) {
				if (num == 3) {
					for (int i = 0; i < n; i++) {
						System.out.printf("%d�� �л� ���� : %.2f\n", i + 1, score[i]);
					}

				} else if (num == 4) {
					double max = score[0];
					double sum = 0;
					for (int i = 0; i < n; i++) {
						if (max < score[i])
							max = score[i];
						sum += score[i];
					}
					double avg = sum / n;

					System.out.printf("�ְ� ������ : %.2f, ��������� : %.2f\n", max, avg);
				} else {
					System.out.println("�л� �Ǵ� �л� ������ �Է��Ͻ��� �����̽��ϴ�. 1�� Ȥ�� 2���� �ٽ� ������ �ֽʽÿ�. ");
				}
			} else {

				System.out.println("�ٽ� �Է����ּ���. ");
			}
			System.out.println("============================================");
			System.out.println("������ �Է��� ��ɾ��� ���ڸ� �Է��� �ּ���.");
			num = scanner.nextInt();
		}
		System.out.println("���α׷��� ���� �˴ϴ�.");
		
		asdgqawe();
	}

	public static void asdgqawe() {
		Scanner k = new Scanner(System.in);
		int selectNo = 0;
		int studentNum = 0;
		// �迭�� �⺻ ���� null
		int[] scores = null;
		a : while (true) {
			System.out.println("======================================================================");
			System.out.println("1.�л��� | 2. ���� �Է� | 3. ���� ����Ʈ |4. �ְ� ���� �� ��� ���� |5. ����");

			selectNo = k.nextInt();

			switch (selectNo) {
			case 1:
				System.out.println("�л��� : ");
				studentNum = k.nextInt();
				scores = new int[studentNum];// �ٽ��� ���⼭ array�� �ε����� ������ ���� �޾Ҵٴ� �Ϳ� �ִ�.
				break;
			case 2:
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("%d�� �л� ���� �Է� : ", i + 1);
					scores[i] = k.nextInt();
				}
				break;
			case 3:
				int index = 1;
				for (int i : scores) {
					System.out.printf("%d�� �л� ���� : %d�� \n", index++, i);
				}
				break;
			case 4:
				int max = 0;
				int sum = 0;
				double avg = 0;
				for (int i : scores) {
					sum += i;
					max = (max < i) ? i : max;
				}
				avg = (double) sum / scores.length;
				System.out.printf("�ְ� ���� : %d\n", max);
				System.out.printf("��� ���� : %.2f��\n", avg);
				break;
			case 5:
				System.out.println("����˴ϴ�.");
				System.out.println("=========================================================");
				break a;
			default:
			System.out.println("�ٽ� �Է��� �ּ���.");
				break;
			}
		}
	}
}
