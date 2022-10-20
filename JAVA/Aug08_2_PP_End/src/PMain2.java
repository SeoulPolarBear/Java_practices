import java.util.Scanner;

//PP:절차지향 프로그래밍
//연산자
//shift 연산자 
// 3 << 1 
// 11 => 110 => 3*(2^1) = 6 
public class PMain2 {
	static int midnight = 0;
	static int parking = 1;
	static int wifi = 2;
	static int smoking = 3;
	// 24시간 : 1 << 0 = 1
	//주차창 : 1 << 1 = 2
	//wifi : 1 << 2 = 4
	//흡연실 : 1 << 3 = 8
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0~15를 입력하시면 해당 서비스에 대해 설명해 드리겠습니다. : ");
		int button1 = scanner.nextInt();
		
		String[] array = {" "," "," "," "};
		
		while(button1 != 0) {
			if( (1 << midnight) <= button1 && button1 < (1 << parking)) {
				button1 -=  (1 << midnight);
				array[0] = "24시간" ;
			}
			else if( (1 << parking) <= button1 && button1 < (1 << wifi)) {
				button1 -=  (1 << parking);
				array[1] = "주차창";
			}
			else if( (1 << wifi) <= button1 && button1 < (1 << smoking)) {
				button1 -=  (1 << wifi);
				array[2] = "wifi";
			}
			else if( (1 << smoking) <= button1 && button1 < (1 << 4)) {
				button1 -=  (1 << smoking);
				array[3] = "흡연실";
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}System.out.print("지금 이 가계에서 사용할 수 있는 서비스는 ");
		for (String string : array) {
			if (!string.equals(" ")) System.out.print(string + " "); 
		}System.out.println("입니다.");
		
		//강사님 풀이 : 이점 : 아래로 차례대로 내려가므로 코드의 길이가 늘어 나지 않게 되고 순서대로 처리하므로 한번에 처리할 수 있게 된다.
		//즉, 시간 복잡도가 많이 줄어들게 된다. 따라서 else if문 보다 훨씬 더 빠르게 처리가 될 수 있다.
//if( (1 << 3) <= button1 ) {
//		button1 -=  (1 << 3);
//		array[0] = "흡연실" ;
//	}
//	if( (1 << 2) <= button1 ) {
//		button1 -=  (1 << 2);
//		array[1] = "wifi";
//	}
//	if( (1 << 1) <= button1 ) {
//		button1 -=  (1 << 1);
//		array[2] = "주차창";
//	}
//	if( (1 << 0) <= button1) {
//		button1 -=  (1 << 0);
//		array[3] = "24시간";
//	}
//	else {
//		System.out.println("잘못 입력하셨습니다.");
//		break;
//	}
		
		int button2 = 13;
		String[] option = {"24시간", "주차장", "WIFI", "흡연실"};
		for(int i = option.length - 1; i >= 0; i--) {
			if(button2 > (1 << i)) {
			System.out.println(option[i]);
		}
		
	}
	}
}
