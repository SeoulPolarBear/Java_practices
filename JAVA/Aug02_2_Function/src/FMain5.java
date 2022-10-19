import java.util.Random;
import java.util.Scanner;

//동전 맞추기 게임
//10개 넣어서 맞추는 게임
public class FMain5 {

	
	
	//답 맞춰보기
	//결과 출력
	
	// 질문 
	public static void printAnswer() {
		System.out.print("동전 개수를 입력하세요. : ");
	}
	//동전 10개 섞기
	public static int Coin() {
		return new Random().nextInt(11);// 0~10
	}

	// 답 입력
	public static int checkCoin() {
		return new Scanner(System.in).nextInt();
	}

	// 동전 개수 확인
	public static String answer(int coin, int check_coin) {
		return check_coin == coin ? "맞혔다." : "틀렸다.";
	}

	// 답에 대한 결과 출력
	public static void printAnswer(String answer) {
		System.out.println(answer);
	}

	public static void main(String[] args) {
		int coin = Coin();
		printAnswer();
		int check_coin = checkCoin();
		printAnswer(answer(coin, check_coin));

	}

}
