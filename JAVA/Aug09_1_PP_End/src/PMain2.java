import java.util.Scanner;

public class PMain2 {
	public static void main(String[] args) {
		System.out.println("1~5 까지 입력해 주세요. : ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();// 1~5

		int[] checknum = { 0, 0 };
		int n = 0;
		double[] score = new double[100];
		while (num != 5) {
			// 1을 입력하면 학생 수 값을 입력 받을 수 있게
			if (num == 1 && checknum[0] == 0) {
				System.out.println("학생 수를 입력해 주세요.");
				n = scanner.nextInt();
				System.out.printf("학생수는 %d명 입니다.\n", n);
				checknum[0] = 1;
			} else if (num == 1 && checknum[0] == 1) {
				System.out.println("이미 학생 수는 입력하셨습니다.");
			}

			// 2를 입력하면 각 학생들의 점수를 입력 받을 수 있게(점수 범위는 고려 X)
			else if (num == 2 && checknum[0] == 1) {
				if (checknum[1] == 0) {
					System.out.printf("학생들 %d명의 점수를 입력해 주세요.\n", n);
					for (int i = 0; i < n; i++) {
						score[i] = new Scanner(System.in).nextDouble();
					}
					checknum[1] = 1;
				} else {
					System.out.println("이미 점수를 입력하셨습니다.");
				}

			} // 3을 입력하면 학생들의 점수리스트를 출력 할 수 있게(ex : 1번 학생 점수 : 50점)
				// 4를 입력하면 최고 점수와 평균점수를 분석해서 출력 할 수 있게
				// 5를 입력하면 프로그램 종료
			else if (checknum[0] == 1 && checknum[1] == 1) {
				if (num == 3) {
					for (int i = 0; i < n; i++) {
						System.out.printf("%d번 학생 점수 : %.2f\n", i + 1, score[i]);
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

					System.out.printf("최고 점수는 : %.2f, 평균점수는 : %.2f\n", max, avg);
				} else {
					System.out.println("학생 또는 학생 성적을 입력하시지 않으셨습니다. 1번 혹은 2번을 다시 실행해 주십시오. ");
				}
			} else {

				System.out.println("다시 입력해주세요. ");
			}
			System.out.println("============================================");
			System.out.println("다음에 입력할 명령어의 숫자를 입력해 주세요.");
			num = scanner.nextInt();
		}
		System.out.println("프로그램이 종료 됩니다.");
		
		asdgqawe();
	}

	public static void asdgqawe() {
		Scanner k = new Scanner(System.in);
		int selectNo = 0;
		int studentNum = 0;
		// 배열의 기본 값은 null
		int[] scores = null;
		a : while (true) {
			System.out.println("======================================================================");
			System.out.println("1.학생수 | 2. 점수 입력 | 3. 점수 리스트 |4. 최고 점수 및 평균 점수 |5. 종료");

			selectNo = k.nextInt();

			switch (selectNo) {
			case 1:
				System.out.println("학생수 : ");
				studentNum = k.nextInt();
				scores = new int[studentNum];// 핵심은 여기서 array의 인덱스를 다음과 같이 받았다는 것에 있다.
				break;
			case 2:
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("%d번 학생 점수 입력 : ", i + 1);
					scores[i] = k.nextInt();
				}
				break;
			case 3:
				int index = 1;
				for (int i : scores) {
					System.out.printf("%d번 학생 점수 : %d점 \n", index++, i);
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
				System.out.printf("최고 점수 : %d\n", max);
				System.out.printf("평균 점수 : %.2f점\n", avg);
				break;
			case 5:
				System.out.println("종료됩니다.");
				System.out.println("=========================================================");
				break a;
			default:
			System.out.println("다시 입력해 주세요.");
				break;
			}
		}
	}
}
