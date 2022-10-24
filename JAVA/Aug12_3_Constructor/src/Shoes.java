//Constructor
// 객체가 만들어질 때 뭔가 작업을 해야하는데...
//	=>생성자 만들기!
// 리턴이 아예 없고, 메소드명이 클래스명과 같은 메소드
// 생성자를 만들지 않으면 => 기본 생성자를 만들어버림
// 생성자를 건드리면...
//	=> 자바 컴파일러가 기본 생성자를 안만들어줌...
//	=> 시스템이 자동으로 객체를 만들때가 있는데...
//  => 기본 생성자를 씀 => 에러!
public class Shoes {
	// 나이키 홈페이지
	// 이름 : ??
	private String name;
	// size
	private int size;
	// 가격
	private int price;
	// 브랜드
	private static String brand = "나이키";
	
	public Shoes() {
		
	}
	//생성자 만들 때 ctrl + space 누르면 된다.

	// 정보를 출력 생성자 오버로딩
	public Shoes(String name, int size, int price) {
		super();//위에 있는 기본 생성자 불러옴!
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static String getBrand() {
		return brand;
	}

	public static void setBrand(String brand) {
		Shoes.brand = brand;
	}

	public void printInfo() {
		System.out.printf("이름 : %s\n", name);
		System.out.printf("사이즈 : %d\n", size);
		System.out.printf("가격 : %d\n", price);
		System.out.printf("브랜드 : %s\n", brand);
		System.out.println("======================================");
	}
	public void test(String name) {//신발 이름
		System.out.println(name);
		System.out.println(this.name);
	}

}
