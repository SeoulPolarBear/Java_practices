
public class CMain1 {
//신발 객체
	// 나이키 홈페이지
	// 이름 : ??
	// size
	//가격
	//브랜드
	//정보를 출력
	//======================================
	// 나이키 홈페이지
	// 이름 : ??
	// size
	//가격
	//브랜드
	//정보를 출력
	//======================================
	public static void main(String[] args) {
		Shoes shoes1 = new Shoes("나이키 에어맥스 플러스", 270, 189000); 
		Shoes shoes2 = new Shoes("나이키 에어 줌 페가수스 39", 270, 139000); 
		Shoes shoes3 = new Shoes(null, 0, 0);
		shoes1.printInfo();
		shoes2.printInfo();
		
		shoes2.test("zzzzz");
		shoes2.test(shoes2.getName());
	}

}
