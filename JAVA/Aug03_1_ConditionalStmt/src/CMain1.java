import java.util.Scanner;

public class CMain1 {
	// ���� ���� ������ �Է��ؼ� �޾ƿ��� �Լ�
	public static int getKoreanScore() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� ������ �Է��Ͻÿ�. : ");
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
				return "�� ġ��";
			else {
				return "good";
			}
		} else {
			if (0 < a && a < 30)
				return "�׳� ������";
			else
				return "���� ��";
		}
	}

	public static void main(String[] args) {
		int kor = getKoreanScore();
		String m;
		if (100 >= kor && kor >= 90)
			m = "��";
		else if (90 > kor && kor >= 80)
			m = "��";
		else if (kor >= 70 && 80 > kor)
			m = "��";
		else if (kor >= 60 && 70 > kor)
			m = "��";
		else
			m = "��";

		System.out.printf("����� %s�Դϴ�.", m);
		System.out.println(good(kor));
	}// ���� ������ 50�� �� �Ǹ� ��, �ƴϸ� â��

}
