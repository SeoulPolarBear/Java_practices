import java.util.HashMap;
import java.util.Scanner;

public class PMain4 {
	/**
	 * �Ž������� ȯ���ϴ� ���α׷� �Լ� ��� <�Է�> ������ ���� ���� : �� �� : <���> �Ž������� 5���� �� �� :�� 1�� 5õ ....
	 * ���� ǥ�� �ϱ�
	 */
	// ������ ���� ����
	public static int setValue() {
		System.out.print("������ ���� ���� : ");
		return new Scanner(System.in).nextInt();
	}

	// �� ��
	public static int setPrice() {
		System.out.println("�� �� : ");
		return new Scanner(System.in).nextInt();
	}

	// �Ž�����
	public static int Exchange(int value, int price) {
		int exchange = price - value;
		return exchange;
	}

	// �Ž����� ����
	public static boolean Exchange(int exchange) {
		return exchange >= 0 ? true : false;
	}

	// �Ž����� ǥ���� �� ����
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
			System.out.println("���� ���ڸ��ϴ�. �ٽ� �޾ƿ�����.");
			return map;
		}
	}

	// �Ž��� �� print
	public static void printExchange(HashMap<Integer, Integer> map) {
		System.out.printf(" 50000�� ���� %d �� �ִ�.\n", map.containsKey(50000) ? map.get(50000) : 0);
		System.out.printf(" 10000�� ���� %d �� �ִ�.\n", map.containsKey(10000) ? map.get(10000) : 0);
		System.out.printf(" 5000�� ���� %d �� �ִ�.\n", map.containsKey(5000) ? map.get(5000) : 0);
		System.out.printf(" 1000�� ���� %d �� �ִ�.\n", map.containsKey(1000) ? map.get(1000) : 0);
		System.out.printf(" 500�� ���� %d �� �ִ�.\n", map.containsKey(500) ? map.get(500) : 0);
		System.out.printf(" 100�� ���� %d �� �ִ�.\n", map.containsKey(100) ? map.get(100) : 0);
		System.out.printf(" 50�� ���� %d �� �ִ�.\n", map.containsKey(50) ? map.get(50) : 0);
		System.out.printf(" 10�� ���� %d �� �ִ�.\n", map.containsKey(10) ? map.get(10) : 0);
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int exchange = Exchange(setValue(), setPrice());
		map = printExchange(Exchange(exchange), exchange, map);
		printExchange(map);
	}
}
