//이중 for문
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
			System.out.printf("ㅣ<%d>단  ㅣ", i);
			for (int j = 1; j < 10; j++) {
				System.out.printf("  %d X %d = %d	", i, j, i * j);
			}
			System.out.print("ㅣ");
			System.out.println();

		}
		System.out.println(
				"==========================================================================================================================================================");
		System.out.println(
				"==========================================================================================================================================");
		for (int i = 1; i < 10; i++) {
			System.out.printf("  <%d>단    	", i);

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
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------");
		// 1번째 방법
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == i)
					System.out.print("ㅋ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		// 2번째 방법
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			System.out.println("ㅋ");
		}

		// 3번째 방법
		for (int i = 5; 0 < i && i <= 5; i--) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("  ");
			}
			System.out.println("ㅋ");
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.print("                   ㅋ");
		for (int i = 0; i < 20; i += 2) {
			for (int j = 0; j < (20 - i) / 2; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();

		}
		System.out.println("                  ㅣㅣ");
		System.out.println("                  ㅣㅣ");
		System.out.println("          ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("          ㅣ                ㅣ ");
		System.out.println("          ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(i%2 == 0?"ㅋ":"ㅎ");
			}
			System.out.println();
		}
		
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i%2 == 0?"ㅋ":"ㅎ");
			}System.out.println();
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
		
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j <=2*(4- i); j++) {
				System.out.print(i%2 == 0?"ㅋ":"ㅎ");
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
