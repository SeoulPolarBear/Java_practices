import java.util.Scanner;

public class CMain4 {
	
	//switch-case (ex : 권한 설정)
	public static void main(String[] args) {
		//Scanner로 입력을 받을 것!
		Scanner scanner = new Scanner(System.in);
		System.out.println("계급이 뭐냐? : ");
		String army = scanner.next();
		
		String a  = "눈치";
		String b = "관등성명";
		String c = "훈련";
		String d = "잠";
		
		//이병 입력 -> 눈치, 관등성명, 훈련, 잠
		//일병 입력 -> 관등성명, 훈련, 잠
		//상병 입력 -> 훈련, 잠
		//병장 입력 -> 잠
		switch (army) {
		case "이병":
			System.out.println(a);
			
		case "일병":
			System.out.println(b);
			
		case "상병":
			System.out.println(c);
			
		case "병장":
			System.out.println(d);
			break;

		default:
			System.out.println("뭔 소리야 오늘 전역인데");
			break;
		}
		
	}
}
