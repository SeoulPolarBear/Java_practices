import java.util.Random;
import java.util.Scanner;

public class OMain1 {
	//����������
	//3�� ����, �ܷ�� 2��
	//�� ���� ���ڸ��� ����
	//�������״� ����� ����
	//1�� �Է��ϸ� ����, 2�� �Է��ϸ� ����/ 3�� �Է��ϸ� ��
	//�� ��ü���� �Ӽ� �ൿ���� ��� ����
	//�Ѹ��� random, �ϳ��� scanner
	//���� �� ���� �� �� / �� �� �ߴ��� �˰� �ʹ�.
	public static void main(String[] args) {
		RuleBook ruleBook = new RuleBook("����������", 
				"������ ������ �� �̱��.", 
				"������ ���� �� �̱��.", 
				"���� ������ �� �̱��.",
				"������ ���� �̱��.", 
				"������ ������ �̱��.", 
				"���� ������ �̱��.",
				"������ ����.");
		Staff staff = new Staff("����", ruleBook);
		Person me = staff.Start();
		System.out.printf("%s ���� ����! \n",me.getRole());
		System.out.println("===================================================");
		Person computer = new Person("��ǻ��", 0, 0, 0);
		int count = 1;
		while(true) {
			System.out.println("===================================================");
			System.out.printf("%d��° ���� ����!", count);
			me.setGive(new Scanner(System.in).nextInt());
			computer.setGive(new Random().nextInt(3) + 1);
			me.Match(computer.getGive(), me.getGive());
			System.out.println("===================================================");
			computer.Match(me.getGive(), computer.getGive());
			System.out.println("===================================================");
			System.out.println("���� �׸� �ΰ� �����ø� 0�� �Է����ּ���.");
			if(new Scanner(System.in).next().equals("0")){
				break;
			}count++;
		}
		
	}
}
