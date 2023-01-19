import java.util.Scanner;
public class SuccessOrFail {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);// TODO Auto-generated method stub

		System.out.print("점수를 입력하십시오:");
		int score=scanner.nextInt();
		if(score>=80)
			System.out.println("축하합니다!합격입니다.");
		
		scanner.close();
	}

}
