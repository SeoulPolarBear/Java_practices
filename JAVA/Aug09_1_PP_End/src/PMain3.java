import java.util.Scanner;

public class PMain3 {
	public static int Inst() {
		System.out.println("1~5 ���� �Է��� �ּ���. : ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();// 1~5
		return num;
	}

	public static void printInst(int num) {
		Scanner scanner = new Scanner(System.in);
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

	}

	public static void main(String[] args) {
		//printInst(Inst());
		Program();
	}

	// ù ���� �κ�
	public static void Inst2() {
		System.out.println("���� �� ���ϴ� ��ȣ�� �Է��ϼ���. : ");
		System.out.println("================================================================================");
		System.out.println("1.�л��� | 2. ���� �Է� | 3. ���� ����Ʈ |4. �ְ� ���� �� ��� ���� |5. ����");
		System.out.println("================================================================================");
	}

	// ������ �޴� ��ȣ Ȯ��
	public static int menuNumber() {
		System.out.print("���� >>");
		int selectNo = new Scanner(System.in).nextInt();
		return selectNo;
	}

	// �л� �� �� �޾ƿ���
	public static int studentNum() {
		System.out.println("�л��� : ");
		return new Scanner(System.in).nextInt();
	}

	// �л� ������ ���� �޾ƿ���
	public static int studentScore() {
		
		Scanner scan =new Scanner(System.in);
		int score = scan.nextInt();
		
		if (score < 0 || score > 100) {
			System.out.printf("%d�� 0�� 100 ���̿��� �Է� �����մϴ�.\n", score);
			System.out.println("�ٽ� �Է��� �ֽʽÿ�.");
		}
		return 0 <= score && score <=100 ? score: studentScore();
	}

	// �л����� ������ �Է��ϱ�
	public static int[] StudentScore(int[] scores) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d�� �л� ���� �Է� : ", i + 1);
			scores[i] = studentScore();
		}
		return scores;
	}

	// �л����� ���� ����ϱ�
	public static void printScores(int[] scores) {
		int index = 1;
		for (int i : scores) {
			System.out.printf("%d�� �л� ���� : %d�� \n", index++, i);
		}
	}

	// �ְ�����, ������� ����ϱ�
	public static void printStatus(int[] scores) {
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
	}

	// ���� �޽���
	public static void printFinish() {
		System.out.println("����˴ϴ�.");
		System.out.println("=================================================================================");
	}

	// ��ü���� ���α׷��� ���ư� ����
	public static void Program() {
		Inst2();
		int selectNo = menuNumber();//���� �� ��ȣ �Է� �� ���� �� Ȯ��
		// �迭�� �⺻ ���� null
		int[] scores = null;
		a: while (true) {
			System.out.printf("����� ������ ��ȣ�� %d �Դϴ�.\n", selectNo);

			switch (selectNo) {
			case 1:
				scores = new int[studentNum()];
				System.out.printf("�л� ���� %d�� �Դϴ�.",scores.length);
				// �ٽ��� ���⼭ array�� �ε����� ������ ���� �޾Ҵٴ� �Ϳ� �ִ�.
				break;
			case 2:
				StudentScore(scores);
				break;
			case 3:
				printScores(scores);
				break;
			case 4:
				printStatus(scores);
				break;
			case 5:
				printFinish();
				break a;
			default:
				System.out.println("�ٽ� �Է��� �ּ���.");
				break;
			}
			Inst2();
			selectNo = menuNumber();
		}
	}

}
