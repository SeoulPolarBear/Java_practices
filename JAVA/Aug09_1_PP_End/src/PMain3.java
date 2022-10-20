import java.util.Scanner;

public class PMain3 {
	public static int Inst() {
		System.out.println("1~5 까지 입력해 주세요. : ");
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

	}

	public static void main(String[] args) {
		//printInst(Inst());
		Program();
	}

	// 첫 시작 부분
	public static void Inst2() {
		System.out.println("다음 중 원하는 번호를 입력하세요. : ");
		System.out.println("================================================================================");
		System.out.println("1.학생수 | 2. 점수 입력 | 3. 점수 리스트 |4. 최고 점수 및 평균 점수 |5. 종료");
		System.out.println("================================================================================");
	}

	// 선택할 메뉴 번호 확인
	public static int menuNumber() {
		System.out.print("선택 >>");
		int selectNo = new Scanner(System.in).nextInt();
		return selectNo;
	}

	// 학생 수 값 받아오기
	public static int studentNum() {
		System.out.println("학생수 : ");
		return new Scanner(System.in).nextInt();
	}

	// 학생 개인의 점수 받아오기
	public static int studentScore() {
		
		Scanner scan =new Scanner(System.in);
		int score = scan.nextInt();
		
		if (score < 0 || score > 100) {
			System.out.printf("%d는 0과 100 사이에만 입력 가능합니다.\n", score);
			System.out.println("다시 입력해 주십시오.");
		}
		return 0 <= score && score <=100 ? score: studentScore();
	}

	// 학생들의 점수를 입력하기
	public static int[] StudentScore(int[] scores) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d번 학생 점수 입력 : ", i + 1);
			scores[i] = studentScore();
		}
		return scores;
	}

	// 학생들의 점수 출력하기
	public static void printScores(int[] scores) {
		int index = 1;
		for (int i : scores) {
			System.out.printf("%d번 학생 점수 : %d점 \n", index++, i);
		}
	}

	// 최고점수, 평균점수 출력하기
	public static void printStatus(int[] scores) {
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
	}

	// 종료 메시지
	public static void printFinish() {
		System.out.println("종료됩니다.");
		System.out.println("=================================================================================");
	}

	// 전체적인 프로그램이 돌아갈 가능
	public static void Program() {
		Inst2();
		int selectNo = menuNumber();//시작 및 번호 입력 및 받을 값 확인
		// 배열의 기본 값은 null
		int[] scores = null;
		a: while (true) {
			System.out.printf("당신이 선택한 번호는 %d 입니다.\n", selectNo);

			switch (selectNo) {
			case 1:
				scores = new int[studentNum()];
				System.out.printf("학생 수는 %d명 입니다.",scores.length);
				// 핵심은 여기서 array의 인덱스를 다음과 같이 받았다는 것에 있다.
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
				System.out.println("다시 입력해 주세요.");
				break;
			}
			Inst2();
			selectNo = menuNumber();
		}
	}

}
