//���� for��
public class RMain2 {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
		System.out.println("-------------------------------");
		System.out.print("        \\||/");
		for (int i = 0; i < 20; i += 2) {
			for (int j = 0; j < (20 - i) / 2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
		System.out.println("         ||");
		System.out.println("         ||");
		System.out.println("     ----------");
		System.out.println("     |        | ");
		System.out.println("     ----------");
		System.out.println(
				"==========================================================================================================================================================");
		for (int i = 2; i < 10; i++) {
			System.out.printf("��<%d>��  ��", i);
			for (int j = 1; j < 10; j++) {
				System.out.printf("  %d X %d = %d	", i, j, i * j);
			}
			System.out.print("��");
			System.out.println();

		}
		System.out.println(
				"==========================================================================================================================================================");
		System.out.println(
				"==========================================================================================================================================");
		for (int i = 1; i < 10; i++) {
			System.out.printf("  <%d>��    	", i);

		}
		System.out.println();
		System.out.println(
				"==========================================================================================================================================");

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d X %d = %d	", j, i, i * j);
			}
			System.out.println();

		}
		System.out.println(
				"==========================================================================================================================================");

		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("��");
			}
			System.out.println();
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------");
		// 1��° ���
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == i)
					System.out.print("��");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		// 2��° ���
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			System.out.println("��");
		}

		// 3��° ���
		for (int i = 5; 0 < i && i <= 5; i--) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("  ");
			}
			System.out.println("��");
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.print("                   ��");
		for (int i = 0; i < 20; i += 2) {
			for (int j = 0; j < (20 - i) / 2; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("��");
			}
			System.out.println();

		}
		System.out.println("                  �Ӥ�");
		System.out.println("                  �Ӥ�");
		System.out.println("          �ѤѤѤѤѤѤѤѤѤ�");
		System.out.println("          ��                �� ");
		System.out.println("          �ѤѤѤѤѤѤѤѤѤ�");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(i%2 == 0?"��":"��");
			}
			System.out.println();
		}
		
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i%2 == 0?"��":"��");
			}System.out.println();
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
		
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j <=2*(4- i); j++) {
				System.out.print(i%2 == 0?"��":"��");
			}System.out.println();
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5-i ; j++) {
				System.out.print( "*");
			}
			for (int j = 0; j < i*2 ; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 5-i ; j++) {
				System.out.print("*");
			}System.out.println();
			
		}
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j <= i ; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < 8 - i*2 ; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i ; j++) {
				System.out.print("*");
			}System.out.println();
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i + 1; j++) {
				System.out.print("*");
			}System.out.println();
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				if(j%4 == 1 || j%4 == 2 ) System.out.print("*");
				else System.out.print(" ");;
		}System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	
}
