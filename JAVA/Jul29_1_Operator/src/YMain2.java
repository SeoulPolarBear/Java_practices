import java.util.Scanner;

public class YMain2 {
	public static void main(String[] args) {
		//국어, 수학, 영어 점수를 입력 받아서 출력
		//총점과 평균까지 출력
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int Korean = scanner.nextInt();
		
		
		
		System.out.print("수학 : ");
		int Mathematics = scanner.nextInt();
		
		System.out.print("영어 : ");
		int English = scanner.nextInt();
		
		int total = Korean + Mathematics + English;
		
		double avg = total / 3.0;
		
		System.out.printf("국어 : %d  수학 : %d  영어 : %d\n", Korean, Mathematics, English);
		System.out.printf("총점 : %d  평균 : %.3f", total, avg);
		
	}
}
