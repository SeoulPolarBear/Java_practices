package Product;

public class IMain3 {
	public static void main(String[] args) {
		Pen p = new Pen();
		System.out.println("=======================");
		Pen p2 = new Pen("빨강");
		System.out.println("=======================");
		Pen p3 = new Pen("모나미", 300, "검정");
		System.out.println("=======================");
		//이름이 패션마스크, 가격이 1000원인 마스크
		Product2 product2 = new Product2();
		Mask mask = new Mask("패션마스크", 1000);
	}
}
//즉, 위 2개는 상위 클래스 호출 한 경우
//아래 1개는 상위클래스를 호출하지 않았다.
//Product !
//=======================
//Product !
//=======================
//=======================
