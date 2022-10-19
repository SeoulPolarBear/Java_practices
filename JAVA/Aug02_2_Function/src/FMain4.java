import java.util.Random;
import java.util.Scanner;

//질문 & 답 입력
//동전 갯수가 홀수면 "홀" & 짝수면 "짝" 비교동전
//비교해서 결과 내기
// 출력

//홀짝 (함수. ver)
public class FMain4 {
	//답에 대한 결과 출력
		public static void printAnswer() {
			System.out.print("\"홀수\" 인지 \"짝수\"인지 입력하시오. : ");
		}
		
	//동전 랜덤으로 쥐기
	public static int Coin() {
		return new Random().nextInt(11);//0~10
	}
	
	//홀짝 중에 하나 얘기하기
	public static String oddorEven() {
		return new Scanner(System.in).next();
	}
	
	//coin 홀짝인지 확인
	public static String Result(int coin) {
		return coin%2 == 0?"짝수":"홀수";
	}
	//내가 얘기한게 맞는지 확인
	public static String checkAnswer(String odd_or_even, String result) {
		return odd_or_even.equals(result)?"정답!":"땡";
	}
	//답에 대한 결과 출력
	public static void printAnswer(int coin,String check_answer) {
		System.out.println(coin + "원입니다! 너는 : " + check_answer);
	}
	
	public static void main(String[] args) {
		printAnswer();
		int coin = Coin();
		String odd_or_even = oddorEven();
		String result = Result(coin);
		String check_answer = checkAnswer(odd_or_even, result);
		printAnswer(coin,check_answer);
	}
}
