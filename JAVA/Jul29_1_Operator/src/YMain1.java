import java.util.Scanner;

public class YMain1 {
	public static void main(String[] args) {
		//���� ����� ���
		//���� ����� ����
		//���߱��� �� �� ����������
		//�㿡 �� �����(t/f)
		//�� �ð� �����
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("������ ����� ��Ű���? ");
		String condition = scanner.next();
		System.out.println(condition + "�̱���");
		
		System.out.print("���� ����� ������ �� ���ΰ���?");
		int conditionScore = scanner.nextInt();
		System.out.println(conditionScore + "�̱���");
		
		System.out.print("���߱��� �� �� ����������? ");
	    int InterChange = scanner.nextInt();
	    System.out.println(InterChange + "�̱���");
		
		System.out.print("�㿡 �� �䳪��? ");
		boolean goodNight = scanner.nextBoolean();
		
		if(goodNight) System.out.println("�� �ֹ��̱���");
		else System.out.println("��Ÿ�����ϴ�.");
		
		
		System.out.print("�� �ð� �䳪��? ");
		int sleep = scanner.nextInt();
		System.out.println(sleep + "�̱���");
		
		
		System.out.println("-------------------");
		System.out.println("\\   /\\     /\\   /");
		System.out.println(" ) ( ')   (' ) (");
		System.out.println("(  / )     ( \\  )");
		System.out.println(" \\(_)\\     /(_)/");
		System.out.println("-------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}
}
