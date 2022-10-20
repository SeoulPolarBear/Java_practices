import java.util.Scanner;

public class Staff {
	private String role;
	private RuleBook ruleBook;
	
	public Staff(String role, RuleBook ruleBook) {
		this.role = role;
		this.ruleBook = ruleBook;
	}
	//������ �˸��� �Ҹ�
	public Person Start() {
		System.out.printf("���� %s �� ���� ������ �ִ� %s �Դϴ�.\n",ruleBook.getName() ,role);
		Scanner scan = new Scanner(System.in);
		System.out.print("�� ���� ���� �ʹٰ��??(y/n) : ");
		String wantToSee = scan.next();
		if(wantToSee.equals("Y") || wantToSee.equals("y")) {
			for (String sentence : ruleBook.getRuleBook()) {
				System.out.println(sentence);
			}
		}
			else if(wantToSee.equals("N") || wantToSee.equals("n")) {
				System.out.println("�����Դϴ�. ������ �� ���� �ٰſ���.");
			}
			else {System.out.println("������ �ɷ� �ϰڽ��ϴ�.");}
		
		
		System.out.println("===================================================");
		System.out.println("�׷� ���� ������ �ְڽ��ϴ�.");
		return new Person(scan.next(), 0, 0, 0);
	}
	
	
	
}
