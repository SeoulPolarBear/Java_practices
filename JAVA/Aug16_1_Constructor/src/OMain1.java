
public class OMain1 {
	public static void main(String[] args) {
		//커피
		//커피 이름/ 가격
		//출력하는 메소드 생성
		Coffee Americano = new Coffee("Americano", 1500);
		Coffee Espresso = new Coffee("Espresso", 3000);
		Coffee latte = new Coffee("latte", 2500); 
		
		Americano.printInfo();
		Espresso.printInfo();
		latte.printInfo();
	}

}
