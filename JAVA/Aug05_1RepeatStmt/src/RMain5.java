import java.util.Random;

public class RMain5 {
	public static void main(String[] args) {
		//1~10������ ������ ����
		//5�� ���
		Random rand= new Random();
		int x = 0;
		for(int i =0; i < 5; i++) {
			x = rand.nextInt(10) + 1;
			System.out.println(x);
		}
		//while�� : if���� �ݺ� ����
		//������ true�� ���ȿ� ��� �ݺ��ؼ� ���� �κ��� �����Ű��... ���� �κп��� ������ false(����)���� ���� ���ߵ��� �ϰų� break; ��ɾ�� �ݺ����� �����ų �� �ִ�.
		//������ ���� ������ �ݺ��ϴ� �۾��� ����. ���Ѵ�� �ݺ��ϰ� ���� �� while(true)��� Ȥ��, Ư�� ���ǿ� ����� �ϴ� ���
		
		
		//1~3������ ������ ������ ���
		//3�� ������ �ݺ��� ����
		int y = rand.nextInt(3) + 1;
		
		while(y != 3) {
			y = rand.nextInt(3) + 1;
			System.out.println(y);
		}
		//do-while �� : ������� �ϰ� ������ ���߿� �˻�
		//�ѹ��� �ݺ��� ���� �ȴ�.
		//1~10������ ������ ������ ���
				//9�� ������ �ݺ��� ����
				do {
					x = rand.nextInt(10) + 1;System.out.println(x);
				}
				while(x != 9);
				
				do {
					x = rand.nextInt(3) + 1;System.out.println(x);
				}
				while(x != 3);
	System.out.println("==========================");
	int sum = 0;
	int i = 0;
	while(sum <=100) {
		sum += ++i;
	}System.out.println(--i);
	
	System.out.println("==========================");
	int sum2 = 0;
	int j = 0;
	do {
		sum2 += ++j;
	}while(sum2 <= 100);
	System.out.println(--j);
		
	
	//1000������ �����߿��� ���� ū 15�� �����??
	int k = 1;
	while(k*15 <= 1000) {
		k++;
	}System.out.println((--k)*15);
	
	
	//1000���Ϸ� ���� �� �ݴ�� 1000���� �����ؼ� ���Ѵ�.
	int num2 = 1000;
	while(num2 % 15 > 0) {
		System.out.println(num2--);
	}
	}
}