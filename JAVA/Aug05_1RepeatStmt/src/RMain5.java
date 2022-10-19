import java.util.Random;

public class RMain5 {
	public static void main(String[] args) {
		//1~10사이의 랜덤한 숫자
		//5번 출력
		Random rand= new Random();
		int x = 0;
		for(int i =0; i < 5; i++) {
			x = rand.nextInt(10) + 1;
			System.out.println(x);
		}
		//while문 : if문의 반복 조건
		//조건이 true인 동안에 계속 반복해서 수행 부분을 실행시키는... 실행 부분에서 조건을 false(거짓)으로 만들어서 멈추도록 하거나 break; 명령어로 반복문을 종료시킬 수 있다.
		//조건이 맞지 않으면 반복하던 작업을 중지. 무한대로 반복하고 싶을 때 while(true)사용 혹은, 특정 조건에 멈춰야 하는 경우
		
		
		//1~3사이의 랜덤한 정수를 출력
		//3이 나오면 반복문 종료
		int y = rand.nextInt(3) + 1;
		
		while(y != 3) {
			y = rand.nextInt(3) + 1;
			System.out.println(y);
		}
		//do-while 문 : 실행부터 하고 조건을 나중에 검사
		//한번은 반복이 보장 된다.
		//1~10사이의 랜덤함 정수를 출력
				//9가 나오면 반복문 종료
				do {
					x = rand.nextInt(10) + 1;System.out.println(x);
				}
				while(x != 9);
				
				do {
					x = rand.nextInt(3) + 1;System.out.println(x);
				}
				while(x != 3);
	System.out.println("==========================");
	int sum = 0;
	int i = 0;
	while(sum <=100) {
		sum += ++i;
	}System.out.println(--i);
	
	System.out.println("==========================");
	int sum2 = 0;
	int j = 0;
	do {
		sum2 += ++j;
	}while(sum2 <= 100);
	System.out.println(--j);
		
	
	//1000이하의 숫자중에서 가장 큰 15의 배수는??
	int k = 1;
	while(k*15 <= 1000) {
		k++;
	}System.out.println((--k)*15);
	
	
	//1000이하로 줄일 때 반대로 1000에서 시작해서 구한다.
	int num2 = 1000;
	while(num2 % 15 > 0) {
		System.out.println(num2--);
	}
	}
}