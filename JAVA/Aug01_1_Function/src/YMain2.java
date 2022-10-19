import java.util.Random;
import java.util.Scanner;

public class YMain2 {
	public static void main(String[] args) {
		Random r = new Random();
//		int i = r.nextInt();// -2^31~2^31 - 1(int)
//		int i2 = r.nextInt(5);// 0~4
//		int i3 = r.nextInt(5) + 1;// 1~5
//		System.out.println(i);
//		System.out.println(i2);

		// 홀짝 게임
		// 동전 10개 정도를 쥐고 있다가
		// 내가 홀이라고 하면
		// 홀인지 짝인지 판정해서 정답인지 아닌지 판정해서 결과를 출력하는 프로그램
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\"홀수\" 인지 \"짝수\"인지 입력하시오. : ");
		String predict = scanner.next();
		int coin = r.nextInt(11);
		
		String answer = (coin%2 == 0)?"짝수":"홀수";
		System.out.printf("%d이지롱 %s",coin,predict.equals(answer)?"정답!":"땡");
	}
}
