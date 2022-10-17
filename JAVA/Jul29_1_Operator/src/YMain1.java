import java.util.Scanner;

public class YMain1 {
	public static void main(String[] args) {
		//오늘 기분은 어떤가
		//오늘 컨디션 점수
		//대중교통 몇 번 갈아탔는지
		//밤에 잘 잤는지(t/f)
		//몇 시간 잤는지
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("오늘은 기분이 어떠신가요? ");
		String condition = scanner.next();
		System.out.println(condition + "이군요");
		
		System.out.print("오늘 컨디션 점수는 몇 점인가요?");
		int conditionScore = scanner.nextInt();
		System.out.println(conditionScore + "이군요");
		
		System.out.print("대중교통 몇 번 갈아탔나요? ");
	    int InterChange = scanner.nextInt();
	    System.out.println(InterChange + "이군요");
		
		System.out.print("밤에 잘 잤나요? ");
		boolean goodNight = scanner.nextBoolean();
		
		if(goodNight) System.out.println("잘 주무셨군요");
		else System.out.println("안타깝습니다.");
		
		
		System.out.print("몇 시간 잤나요? ");
		int sleep = scanner.nextInt();
		System.out.println(sleep + "이군요");
		
		
		System.out.println("-------------------");
		System.out.println("\\   /\\     /\\   /");
		System.out.println(" ) ( ')   (' ) (");
		System.out.println("(  / )     ( \\  )");
		System.out.println(" \\(_)\\     /(_)/");
		System.out.println("-------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}
}
