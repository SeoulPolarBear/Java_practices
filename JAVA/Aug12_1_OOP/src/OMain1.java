import java.util.Random;
import java.util.Scanner;

public class OMain1 {
	//가위바위보
	//3명 심판, 겨루는 2명
	//다 같이 한자리에 있음
	//심판한테는 룰북이 있음
	//1을 입력하면 가위, 2를 입력하면 바위/ 3을 입력하면 보
	//각 객체들의 속성 행동들은 어떻게 할지
	//한명은 random, 하나는 scanner
	//한판 질 동안 몇 승 / 몇 무 했는지 알고 싶다.
	public static void main(String[] args) {
		RuleBook ruleBook = new RuleBook("가위바위보", 
				"가위는 바위를 못 이긴다.", 
				"바위는 보를 못 이긴다.", 
				"보는 가위를 못 이긴다.",
				"가위는 보를 이긴다.", 
				"바위는 가위를 이긴다.", 
				"보는 바위를 이긴다.",
				"같으면 비긴다.");
		Staff staff = new Staff("심판", ruleBook);
		Person me = staff.Start();
		System.out.printf("%s 선수 입장! \n",me.getRole());
		System.out.println("===================================================");
		Person computer = new Person("컴퓨터", 0, 0, 0);
		int count = 1;
		while(true) {
			System.out.println("===================================================");
			System.out.printf("%d번째 게임 시작!", count);
			me.setGive(new Scanner(System.in).nextInt());
			computer.setGive(new Random().nextInt(3) + 1);
			me.Match(computer.getGive(), me.getGive());
			System.out.println("===================================================");
			computer.Match(me.getGive(), computer.getGive());
			System.out.println("===================================================");
			System.out.println("만약 그만 두고 싶으시면 0을 입력해주세요.");
			if(new Scanner(System.in).next().equals("0")){
				break;
			}count++;
		}
		
	}
}
