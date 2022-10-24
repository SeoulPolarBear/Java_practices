package ShoppingMall;
//A is a B : 상속관계
// 쇼핑몰 - 상품에 대한 정보를 게시하고 싶음
public class IMain2 {
public static void main(String[] args) {
	//신발(이름, 가격, 사이즈)
	//출력
	Shoes shoes = new Shoes("에어포스1", 256000, 280);
	
	//컴퓨터 (이름, 가격, cpu, ram, hdd)
	//출력
	Computer computer = new Computer("Samsung Desktop", 1500000, "i7-1234", 32, 1024);
	//노트북 (이름, 가격, cpu, ram, hdd, 무게, 배터리 지속시간)
	//출력
	NoteBook noteBook = new NoteBook("Apple MAC", 1500000, "M1", 32, 1024, 1.5, 8.5);
	ShoppingMall shoppingMall = new ShoppingMall(shoes,computer,noteBook);
	
	shoppingMall.printInfo();
	
	
	
}
}
