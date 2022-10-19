import java.util.Random;
import java.util.Scanner;

public class FMain5 {
	// 쉬는날..방에서 게임을 하고 있는데.. => 엄마가 심부름 시켜요...
	public static void makeErrand() {
		System.out.println("아들~");
		System.out.println("돈 줄테니까");
		System.out.println("수퍼가서");
		System.out.println("라면이랑");
		System.out.println("참치 사고");
		System.out.println("남은 돈 가져와~");
	}
	//심부름 중에... (라면 : 3200, 참치 : 2170, 과자 : 1500)
	//돈이 얼마 남는지... 생각... 엄마가 주신 돈에서 위 같은 값을 뺀 잔돈을 보여주는 함수 생성
	
	public static int Exchange(int money) {
	Random r = new Random();
	return money - (3200 + 2170 + (r.nextInt(6) + 1) * 1000);
	}
	
	//엄마가 돈을 주셨다.(돈 = 입력)
	public static int getMoney() {
		System.out.println("엄마가 주신 돈을 입력하시오 : ");
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();
		System.out.printf("엄마가 %d원을 주셨다.\n", money);
		return money;
	}
	
	//계산을 하고, 잔돈을 엄마한테 주자...
	public static String returnMoney(int exchange, int money) {
		//과자 값 계산
		System.out.printf("아니 뭐 과자 값이 %d원이나 하냐!!", money - (exchange + 3200 + 2170));
		
		//잔돈 관련 출력
		String value = exchange >= 0?
				"그래도 " + String.valueOf(exchange) + "원이 남았다!":
					"아놔 " + String.valueOf(Math.abs(exchange))  + "원 모자르네 큰일났다...";
		return value;
	}
	
	public static void main(String[] args) {
		int money = getMoney();
		int exchange = Exchange(money);
		System.out.printf("%s",returnMoney(exchange,money));
		
	}
}

/* 함수를 표현하는 4가지 방식! 
 * 왜? 사용할까요?
 * 보기 편하게
 * 오류 발견에 편하게
 * 역할 나눔
 * 재사용하기 위해서
 * 
 * main함수에 코드를 최대한 짧게 구성하기 위해서
 * 기능들을 묶어서 함수라는 걸로 사용
 * 기능을 나눠서 효율적으로 사용
 * */




