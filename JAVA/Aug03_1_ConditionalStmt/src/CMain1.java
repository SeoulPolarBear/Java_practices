import java.util.Scanner;

public class CMain1 {
	// 국어 시험 점수를 입력해서 받아오는 함수
	public static int getKoreanScore() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 점수를 입력하시오. : ");
		int score = scanner.nextInt();

		if (0 <= score && score <= 100) {
			return score;
		} else {
			return getKoreanScore();
		}
	}

	public static String good(int a) {
		if (a > 50) {
			if (a <= 60)
				return "좀 치네";
			else {
				return "good";
			}
		} else {
			if (0 < a && a < 30)
				return "그냥 나가라";
			else
				return "ㅂㅅ 아";
		}
	}

	public static void main(String[] args) {
		int kor = getKoreanScore();
		String m;
		if (100 >= kor && kor >= 90)
			m = "우";
		else if (90 > kor && kor >= 80)
			m = "수";
		else if (kor >= 70 && 80 > kor)
			m = "미";
		else if (kor >= 60 && 70 > kor)
			m = "양";
		else
			m = "가";

		System.out.printf("당신은 %s입니다.", m);
		System.out.println(good(kor));
	}// 국어 점수가 50점 안 되면 욕, 아니면 창찬

}
