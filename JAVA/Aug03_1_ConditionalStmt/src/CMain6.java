import java.util.Scanner;

public class CMain6 {
//1년은 12달
	// 각달 며칠인지 다릅니다.
	// 몇 월인지 입력을 받아서
	// 30,31,28 까지 있습니다.
	// 14월 입력 : 없는 달입니다.

	public static void main(String[] args) {
		System.out.println("달을 입력하시오. : ");
		int month = new Scanner(System.in).nextInt();
		int day = 0;
		if (month <= 12) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;

			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;

			case 2:
				day = 28;
				break;
			}
			System.out.printf("%d달은 %d까지 있습니다.", month,day);
		}else
		System.err.printf("%d달은 없습니다.", month);//error 메세지처럼 보이게 한다.
		
	}
}
