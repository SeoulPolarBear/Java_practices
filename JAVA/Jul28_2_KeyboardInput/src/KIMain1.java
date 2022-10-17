import java.util.Scanner;

public class KIMain1 {

	public static void main(String[] args) throws InterruptedException {
		//Scanner : Java에 내장되어 있는 기능 중 하나!
		//이 기능을 사용하기 위해서 Import라는 것이 사용됨
		//이 Scanner라는 걸 사용하려면 조건이 하나 필요한데...
		
		//new ~~~ : 객체
		
		//Scanner는 화면(이클립스의 콘솔창)으로부터 데이터를 입력 받는 기능
		
		Scanner keyboard = new Scanner(System.in);
		
		//키, 몸무게, 신발사이즈, 여행가고 싶은 곳, 좋아하는 숫자, 놀고 싶은지 유무
		System.out.print("이름 : ");
		String name = keyboard.next();
		System.out.print("키 : ");
		double height = keyboard.nextDouble();
		System.out.print("몸무게 : ");
		int weight = keyboard.nextInt();
		System.out.print("발사이즈 : ");
		int footSize = keyboard.nextInt();
		System.out.print("여행가고 싶은 곳 : ");
		String visit = keyboard.next();
		System.out.print("좋아하는 숫자 : ");
		int likeNumber = keyboard.nextInt();
		System.out.print("놀고 싶은 유무 : ");
		boolean play = keyboard.nextBoolean();
		
		
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("신발사이즈 : " + footSize);
		System.out.println("여행가고 싶은 곳 : " + visit);
		System.out.println("좋아하는 숫자 : " + likeNumber);
		System.out.println("놀고 싶은지 유무 : " + play);
		
		
		
	
		
		//bat파일 생성
		//끄고 싶으면 아무거나 누르십시오.
		//뭔가 입력해서 엔터 치면
		//1초 마다 .이 3번 나오고 프로그램 종료합니다 라는 메시지가 출력되고 0.5초후 프로그램 종료

		System.out.println("끄고 싶으면 아무거나 누르십시오.");
		String key = keyboard.next();
		keyboard.close();
		
		Thread.sleep(1000);//끝내는 것으로 생각하기보다는 delay를 시키는 거라고 생각하면 된다.
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print("프로그램 종료합니다.");
		Thread.sleep(500);
		
	}

}
