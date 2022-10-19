import java.util.Random;

public class FMain2 {
	//랜덤한 정수를 "출력"하는 함수!
	public static void printInteger() {
		Random rand = new Random();
		int random = rand.nextInt();
		System.out.println(random);
	}
	
	//랜덤한 정수를 "생성"하는 함수 => 정수 "생성"이 목적이다.
	
	public static int returnInteger() {
		Random rand = new Random();
		int random = rand.nextInt();
		return random;//random에 있는 값을 최종 결과로 뱉어내기
						//이 함수는 종료
	}
	
	//정수를 하나 넣으면 홀수인지 짝수인지 출력하는 함수
	public static void printOdd(int a) {
		System.out.println(a % 2 == 0 ? "짝" : "홀");
	}
	
	//정수 2개 넣었을 때 앞 슷자가 크면 "앞", 뒷 숫자가 크거나 같으면 "뒤" 문자열로 생성하는 함수!
	public static String returnMaximum(int a, int b) {
		return a>b?"앞":"뒤";
	}
	
	//점심메뉴 (2가지 중 하나)
	//위의 함수를 이용해서 랜덤한 숫자 2개를 뽑아서 먼저 뽑힌게 크면 내가 먹고 싶은거 아니면 덜 먹고 싶은 것 출력
	public static void Lunch(int a, int b) {
		System.out.println(a > b ?"소고기":"돼지고기");
	}
	
	//blue()를 통해서 구해진 숫자를 i라는 그릇에 
	//JVM -> main 함수를 자동으로 호출
	public static void main(String[] args) {
		int randnum = returnInteger();
		printInteger();
		printOdd(randnum);
		System.out.println(returnMaximum(100, 230));
		String sss = returnMaximum(returnInteger(),returnInteger());
		String menu = sss.equals("앞") ? "소고기":"돼지고기";
		System.out.println(menu);
	}
}
