import java.util.ArrayList;
import java.util.Random;

public class RMain1 {
	public static ArrayList<Integer> array = new ArrayList<Integer>();
	public static void main(String[] args) {
		// ㅋ 출력
		int k = 5;
		int a;

		do {
			a = --k;
			System.out.println("ㅋ");
		} while (a != 0);

		// ㅋ을 3번 출력하고 싶음
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d : ㅋ\n", i);
		}

		for (int i = 0; i < 3; i++) {
			System.out.printf("%d : ㅋ\n", i);
		}

		// 5부터 1까지 순서대로 내림차순 출력
		for (int i = 5; i > 0; i--) {
			System.out.println(i);
		}

	//반복문이 5번 도는 동안에 1~10사이의 숫자를 랜덤하게 뽑고 싶을 때?
		//반복문 속에서 변수를 만드는 것 별로!(비효율적이다.)
		//반복문이 한 번 돌때마다 변수를 생성함!
		//따라서 반복문 밖에서 변수 하나를 만들어서 갖다 쓰는거 조금 더 효율적!
		Random rand = new Random();
		int x3 = 0;
		for(int i = 0; i < 5; i++) {
			x3 = rand.nextInt(10) + 1;
			System.out.println(x3);
		}
		System.out.println("-------------------------------");
		
		for(int i = 0;i<5;i++) {
			array.add(rand.nextInt(10) + 1);
		}
		for(int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		System.out.println("-------------------------------");
		//1 + ... + 10 더한 값 출력
		int x = 0;
		for(int i = 1; i < 11; i++) {
			x += i;
		}
		System.out.println(x);
		
		int y = 1;
		for(int i = 1; i < 8; i++) {
			y *= i;
		}
		System.out.println(y);
		
		System.out.println("-------------------------------");
		//1~50까지 숫자 중에 3의 배수거나, 5의 배수인 숫자를 다 더한 값을 출력
		int sum_3_5 = 0;
		for(int i = 0; i < 51; i++) {
			if(i%3 == 0 || i%5 == 0) sum_3_5 += i;
		}
		System.out.println(sum_3_5);
		
		
		
		
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		
	}
}
