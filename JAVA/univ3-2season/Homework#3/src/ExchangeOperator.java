import java.util.Scanner;
public class ExchangeOperator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("100의 배수인 양의 정수를 입력하세요:");
		int won = scanner.nextInt(); // 가격 입력
		int five_hundred_won = won/500;//500으로 나눈 몫
		int one_hundred_won = (won%500)/100;//500으로 나눈 나머지를 100으로 나눈 몫
		
		System.out.print(won + "원은");
		System.out.print("500원은" + five_hundred_won + "개,");
		System.out.print("100원은" + one_hundred_won + "개 입니다");
		
		scanner.close();
	
	}

}
