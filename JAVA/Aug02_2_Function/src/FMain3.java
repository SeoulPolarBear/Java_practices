import java.util.Scanner;

//비만도 검사 프로그램( 함수. ver)

//기능을 잘 분류해서 함수로 표현을 해줘야 하는이유 : 만약에 표준체중이 0.9=>0.8로 바뀌었을 때 즉,
//만약 다양한 기능을 함수 하나에 구현하고, 변경사항을 수정하게 됐을 때...(유지보수)
//한번에 잘 찾을 수 있을까??라는 것 때문에 이렇게 표현한다.
//ctrl + shift + numberpad(/) : 함수를 닫을 수 있다.
//ctrl + shift + numberpad(*) : 함수를 열 수 있다.
//ctrl + / : 함수 +,-표시


//함수 : main함수에서 java를 모르는 사람이 봐도 뭘 한건지 알아볼 수 있게 + 간결해야 한다.
public class FMain3 {
	//키랑 몸무게는 입력을 받을 것 --------- 1
	public static double InputHeight() {
		System.out.print("키 : ");
		return new Scanner(System.in).nextDouble();
	}
	
	public static double InputWeight() {
		System.out.print("체중 : ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
	//표준체중 = (키 - 100) * 0.9 ------------- 2(각 값의 return 값이 어디에 쓰일지 모르므로)
	public static double meanWeight(double height) {
		return (height - 100) * 0.9;
	}
	//비만도 = (실제체중 / 표준체중) *100 ----------------- 3
	public static double obesityPercent(double weight, double meanWeight) {
		return (weight/meanWeight)*100;
	}
	//비만도가 120이 넘으면 '비만', 아니면 '안 비만' -------------- 4
	public static String Presence(double obesityPercent) {
		return obesityPercent > 120 ? "비만":"안 비만";
	}
	//결과 출력
	public static void printPresence(String present) {
		System.out.println(present);
	}
	
	public static void main(String[] args) {
		System.out.println("키와 체중을 입력해 주세요.");
		double height = InputHeight();
		double weight = InputWeight();
		double mean_weight = meanWeight(height);
		double obesity_percent = obesityPercent(weight, mean_weight);
		String present = Presence(obesity_percent);
		printPresence(present);
		
		
		
	}
}
