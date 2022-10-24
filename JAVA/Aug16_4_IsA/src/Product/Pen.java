package Product;
//생성자(Java)
// 1. 클래스에 생성자가 하나도 없으면
//		자바 컴파일러가 생성자를 만들어줌!
//	2. 하위클래스 객체를 만들면(Pen)
//		상위클래스 기본생성자(Product)를 자동 호출
//
public class Pen extends Product2{
	private String color;
	
	
	public Pen() {//위 2. 를 명시해 놓은것
		// TODO Auto-generated constructor stub
	}

	public Pen(String color) {
		super();//위 2. 를 명시해 놓은것(없어도 무관)
		this.color = color;
	}
	
	

	public Pen(String name, int price, String color) {
		super(name,price);//2. 발동(x)
		//Product(이름, 가격)
		//super(파라미터)를 가진 생성자를 생성시에는
		//기본생성자가 생기지 않기 때문에 기본생성자를 사용할 수 없다.!!
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
