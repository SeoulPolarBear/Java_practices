import java.util.HashMap;
import java.util.Scanner;

public class PMain4 {
	/**
	 * 거스름돈을 환전하는 프로그램 함수 사용 <입력> 구매한 물건 가격 : 낸 돈 : <출력> 거스름돈을 5만원 권 몇 :개 1만 5천 ....
	 * 으로 표현 하기
	 */
	// 구매한 물건 가격
	public static int setValue() {
		System.out.print("구매할 물건 가격 : ");
		return new Scanner(System.in).nextInt();
	}

	// 낸 돈
	public static int setPrice() {
		System.out.println("낸 돈 : ");
		return new Scanner(System.in).nextInt();
	}

	// 거스름돈
	public static int Exchange(int value, int price) {
		int exchange = price - value;
		return exchange;
	}

	// 거스름돈 유무
	public static boolean Exchange(int exchange) {
		return exchange >= 0 ? true : false;
	}

	// 거스름돈 표현할 것 정리
	public static HashMap<Integer, Integer> printExchange(boolean exc, int exchange, HashMap<Integer, Integer> map) {
		if (exc) {
			if (exchange >= 50000) {
				map.put(50000, exchange / 50000);
				exchange %= 50000;
			}
			if (exchange >= 10000) {
				map.put(10000, exchange / 10000);
				exchange %= 10000;
			}
			if (exchange >= 5000) {
				map.put(5000, exchange / 5000);
				exchange %= 5000;
			}
			if (exchange >= 1000) {
				map.put(1000, exchange / 1000);
				exchange %= 1000;
			}
			if (exchange >= 500) {
				map.put(500, exchange / 500);
				exchange %= 500;
			}
			if (exchange >= 100) {
				map.put(100, exchange / 100);
				exchange %= 100;
			}

			if (exchange >= 50) {
				map.put(50, exchange / 50);
				exchange %= 50;
			}
			if (exchange >= 10) {
				map.put(10, exchange / 10);
				exchange %= 10;
			}
			return map;
		} else {
			System.out.println("돈이 모자릅니다. 다시 받아오세요.");
			return map;
		}
	}

	// 거스름 돈 print
	public static void printExchange(HashMap<Integer, Integer> map) {
		System.out.printf(" 50000원 권은 %d 장 있다.\n", map.containsKey(50000) ? map.get(50000) : 0);
		System.out.printf(" 10000원 권은 %d 장 있다.\n", map.containsKey(10000) ? map.get(10000) : 0);
		System.out.printf(" 5000원 권은 %d 장 있다.\n", map.containsKey(5000) ? map.get(5000) : 0);
		System.out.printf(" 1000원 권은 %d 장 있다.\n", map.containsKey(1000) ? map.get(1000) : 0);
		System.out.printf(" 500원 권은 %d 장 있다.\n", map.containsKey(500) ? map.get(500) : 0);
		System.out.printf(" 100원 권은 %d 장 있다.\n", map.containsKey(100) ? map.get(100) : 0);
		System.out.printf(" 50원 권은 %d 장 있다.\n", map.containsKey(50) ? map.get(50) : 0);
		System.out.printf(" 10원 권은 %d 장 있다.\n", map.containsKey(10) ? map.get(10) : 0);
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int exchange = Exchange(setValue(), setPrice());
		map = printExchange(Exchange(exchange), exchange, map);
		printExchange(map);
	}
}
