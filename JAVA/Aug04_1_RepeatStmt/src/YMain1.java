import java.util.Scanner;

public class YMain1 {
public static void main(String[] args) {
	//점수를 입력 받아서 90이면 'A',
	/**90~80 : B
	 * 80~70 : c
	 * 70~60 :D
	 * 60~ F
	 * switch case로
	 * 
	 * */
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("점수 입력 : ");
	int score = scanner.nextInt();
	switch (score/10) {
	case 10:
		System.out.println(score%10 == 0?"A":"잘못 입력하셨습니다. 다시 입력하세요.");
		break;
	case 9:
		System.out.println("A");
		break;
	case 8:
		System.out.println("B");
		break;
	case 7:
		System.out.println("C");
		break;
	case 6:
		System.out.println("D");
		break;
	case 5:
	case 4:
	case 3:
	case 2:
	case 1:
	case 0:
		System.out.println("F");
		break;
	default:
		System.out.println("잘못된 입력값입니다. 다시 입력하십시오.");
		break;
	}
}
}
