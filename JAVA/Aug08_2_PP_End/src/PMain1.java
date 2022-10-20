import java.util.Scanner;

//어떤 숫자를 콘솔창에 입력
// 그 숫자의 약수를 구해주는 프로그램
//Main에서 진행 -> 음수 값은 무시
// ex) 12의 약수는 : 1, 2, 3, 4, 6, 12
//계속 입력하면 약수를 계속 출력해서 보여주고 -> 콘솔창에 0을 입력하면 프로그램이 종료되게!(0 입력하기 전까지는 무한반복)
//배열 사용 x
public class PMain1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = 1;
		while (num != 0) {
			System.out.println("음이 아닌 숫자를 입력해 주세요. :");
			num = scanner.nextInt();
			int i = 0;
			if (num >= 0) {
				System.out.printf("%d의 약수는", num);
				for (i = 1; i <= Math.sqrt(num); i++) {
					if (num % i == 0) {
						System.out.print(i);
						System.out.print(" ");
					}
				}
				for (int j = i; j <= num; j++) {
					if (num % j == 0) {
						System.out.print(j);
						System.out.print(" ");
					}
				}
				System.out.println();
			} else
				System.out.println("음의 숫자 입니다. 다시 입력해 주세요.");
		}
		System.out.println("프로그램이 종료됩니다.");
	}
}
