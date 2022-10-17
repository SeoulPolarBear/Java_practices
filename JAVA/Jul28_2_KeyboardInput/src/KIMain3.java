import java.util.Scanner;

public class KIMain3 {

	public static void main(String[] args) {
		//메뉴판(고기)
		//가격을 입력받아서 메뉴판 모양으로 출력
		
		Scanner scanner =  new Scanner(System.in);
		
		System.out.print("항정살 : ");
		int price1 = scanner.nextInt();
		
		System.out.print("삼겹살 : ");
		int price2 = scanner.nextInt();

		System.out.print("등심 : ");
		int price3 = scanner.nextInt();
		
		System.out.print("안심 : ");
		int price4 = scanner.nextInt();
		
		System.out.print("가브리살 : ");
		int price5 = scanner.nextInt();
		
		System.out.print("갈비 : ");
		int price6 = scanner.nextInt();
		
		System.out.print("껍데기 : ");
		int price7 = scanner.nextInt();
		
		System.out.print("냉면 : ");
		int price8 = scanner.nextInt();
		
		
		System.out.println("===============메뉴판================");
		System.out.println("정성과 마음으로 진심을 다하겠습니다.");
		System.out.println("항정살 : " + "--------W" + price1);
		System.out.println("삼겹살 : " + "--------W" + price2);
		System.out.println("등심 : " + "--------W" + price3);
		System.out.println("안심 : " + "--------W" + price4);
		System.out.println("가브리살 : " + "--------W" + price5);
		System.out.println("갈비 : " + "--------W" + price6);
		System.out.println("껍데기 : " + "--------W" + price7);
		System.out.println("냉면 : " + "--------W" + price8);
		System.out.println("====================================");
		

	}

}
