import java.util.Scanner;

public class KIMain2 {
	public static void main(String[] args) {
		//반지름을 입력받아서 원의 면적 계산하기
		Scanner scanner = new Scanner(System.in);
//		System.out.println("반지름을 입력받아서 원의 면적 계산하기");
//		System.out.print("원의 반지름 : ");
//		double radian = scanner.nextDouble();
//		
//		double area = Math.PI * Math.pow(radian, 2);
//		
//		System.out.printf("%.3f\n", area);
//		
//		
//		
//	//가로,세로 입력 받아서 사각형 면적 구하기
//		System.out.println("가로,세로 입력 받아서 사각형 면적 구하기");
//		System.out.print("가로 : ");
//		double width = scanner.nextDouble();
//		System.out.print("세로 : ");
//		double height = scanner.nextDouble();
//		
//		double area2 = width * height;
//		
//		System.out.printf("%.3f", area2);
		
		//시간(초)를 입력 받아서 분, 시간 단위로 변환해서 출력
		System.out.println("시간(초)를 입력 받아서 분, 시간 단위로 변환해서 출력");
		System.out.print("초 : ");
		double second = scanner.nextDouble();
		
		double minute = second / 60;
		double hour = minute / 60;
		
		System.out.printf("분 : %f  시 : %f", minute,hour);
		
		
		//참고 int/int = int로 나온다.
		//둘중 하나라도 double이면 결과는 double로 나온다.
	}
}
