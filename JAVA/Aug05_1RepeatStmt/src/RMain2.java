import java.util.Random;
import java.util.Scanner;

//up & Down ����(main��)
//��ǻ�� vs �� -> ���� ���ڳ��� ����
//���ڰ� ������ ������ Down!
//���ڰ� ������ ������ Up!
// �� �ϸ��� ������ ã�Ҵ��� ���
// �ݺ��� for. ���ǹ� if �̿�
public class RMain2 {

	
	public static int Game() {//Num : ������ ��, num : ���� ������ϴ� ��
		 Random Rand =new Random();
		 int Num = Rand.nextInt(100) + 1;
		int count;
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		for(count = 1; Num != num;count++) {//���� �κп��� ���� ���� ���ص� �ȴ�. ���� Num != num ��ſ� break�� ���°� ���ݴ� ȿ������ �� �ִ�.
			System.out.print("���ڸ� �Է����ּ���. : ");
			num = scanner.nextInt(); 
			if (num < Num) System.out.println("Up");
			else if (num > Num) System.out.println("Down");
			else System.out.println("����");
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Game() + "�� ���� ���߼̳׿�."); 
		
		
	}
}
