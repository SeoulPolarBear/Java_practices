import java.util.Scanner;

public class Staff {
	private String role;
	private RuleBook ruleBook;
	
	public Staff(String role, RuleBook ruleBook) {
		this.role = role;
		this.ruleBook = ruleBook;
	}
	//시작을 알리는 소리
	public Person Start() {
		System.out.printf("저는 %s 룰 북을 가지고 있는 %s 입니다.\n",ruleBook.getName() ,role);
		Scanner scan = new Scanner(System.in);
		System.out.print("룰 북이 보고 싶다고요??(y/n) : ");
		String wantToSee = scan.next();
		if(wantToSee.equals("Y") || wantToSee.equals("y")) {
			for (String sentence : ruleBook.getRuleBook()) {
				System.out.println(sentence);
			}
		}
			else if(wantToSee.equals("N") || wantToSee.equals("n")) {
				System.out.println("유감입니다. 앞으로 안 보여 줄거에요.");
			}
			else {System.out.println("못들은 걸로 하겠습니다.");}
		
		
		System.out.println("===================================================");
		System.out.println("그럼 선수 입장이 있겠습니다.");
		return new Person(scan.next(), 0, 0, 0);
	}
	
	
	
}
