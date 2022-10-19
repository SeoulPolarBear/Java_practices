import java.util.Random;
import java.util.Scanner;

//up & Down 게임(main에)
//컴퓨터 vs 나 -> 같은 숫자내면 종료
//숫자가 나보다 낮으면 Down!
//숫자가 나보다 높으면 Up!
// 몇 턴만에 정답을 찾았는지 출력
// 반복문 for. 조건문 if 이용
public class RMain2 {

	
	public static int Game() {//Num : 정답인 수, num : 내가 맞춰야하는 수
		 Random Rand =new Random();
		 int Num = Rand.nextInt(100) + 1;
		int count;
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		for(count = 1; Num != num;count++) {//조건 부분에는 조건 지정 안해도 된다. 따라서 Num != num 대신에 break를 쓰는게 조금더 효율적일 수 있다.
			System.out.print("숫자를 입력해주세요. : ");
			num = scanner.nextInt(); 
			if (num < Num) System.out.println("Up");
			else if (num > Num) System.out.println("Down");
			else System.out.println("정답");
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Game() + "번 만에 맞추셨네요."); 
		
		
	}
}
