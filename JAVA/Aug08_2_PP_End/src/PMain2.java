import java.util.Scanner;

//PP:�������� ���α׷���
//������
//shift ������ 
// 3 << 1 
// 11 => 110 => 3*(2^1) = 6 
public class PMain2 {
	static int midnight = 0;
	static int parking = 1;
	static int wifi = 2;
	static int smoking = 3;
	// 24�ð� : 1 << 0 = 1
	//����â : 1 << 1 = 2
	//wifi : 1 << 2 = 4
	//���� : 1 << 3 = 8
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0~15�� �Է��Ͻø� �ش� ���񽺿� ���� ������ �帮�ڽ��ϴ�. : ");
		int button1 = scanner.nextInt();
		
		String[] array = {" "," "," "," "};
		
		while(button1 != 0) {
			if( (1 << midnight) <= button1 && button1 < (1 << parking)) {
				button1 -=  (1 << midnight);
				array[0] = "24�ð�" ;
			}
			else if( (1 << parking) <= button1 && button1 < (1 << wifi)) {
				button1 -=  (1 << parking);
				array[1] = "����â";
			}
			else if( (1 << wifi) <= button1 && button1 < (1 << smoking)) {
				button1 -=  (1 << wifi);
				array[2] = "wifi";
			}
			else if( (1 << smoking) <= button1 && button1 < (1 << 4)) {
				button1 -=  (1 << smoking);
				array[3] = "����";
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}System.out.print("���� �� ���迡�� ����� �� �ִ� ���񽺴� ");
		for (String string : array) {
			if (!string.equals(" ")) System.out.print(string + " "); 
		}System.out.println("�Դϴ�.");
		
		//����� Ǯ�� : ���� : �Ʒ��� ���ʴ�� �������Ƿ� �ڵ��� ���̰� �þ� ���� �ʰ� �ǰ� ������� ó���ϹǷ� �ѹ��� ó���� �� �ְ� �ȴ�.
		//��, �ð� ���⵵�� ���� �پ��� �ȴ�. ���� else if�� ���� �ξ� �� ������ ó���� �� �� �ִ�.
//if( (1 << 3) <= button1 ) {
//		button1 -=  (1 << 3);
//		array[0] = "����" ;
//	}
//	if( (1 << 2) <= button1 ) {
//		button1 -=  (1 << 2);
//		array[1] = "wifi";
//	}
//	if( (1 << 1) <= button1 ) {
//		button1 -=  (1 << 1);
//		array[2] = "����â";
//	}
//	if( (1 << 0) <= button1) {
//		button1 -=  (1 << 0);
//		array[3] = "24�ð�";
//	}
//	else {
//		System.out.println("�߸� �Է��ϼ̽��ϴ�.");
//		break;
//	}
		
		int button2 = 13;
		String[] option = {"24�ð�", "������", "WIFI", "����"};
		for(int i = option.length - 1; i >= 0; i--) {
			if(button2 > (1 << i)) {
			System.out.println(option[i]);
		}
		
	}
	}
}
