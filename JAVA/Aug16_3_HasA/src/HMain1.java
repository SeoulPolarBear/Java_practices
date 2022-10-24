//객체간의 관계
//		A has a B : 사람은 has a 핸드폰 : 포함관계
//		A is a B : 개 is a 동물 : 상속관계
public class HMain1 {
	public static void main(String[] args) {
		//이름이 Kim Andrew, 남자, 핸드폰 번호가 010-1234-5678인 사람
		//출력
		
		Human man1 = new Human("Kim Andrew","남","010-1234-5678");
		man1.HumanInfo();
		
		//판교 포차, 삼평동, 032-1222-3444, Kim Andrew의 식당
		//출력(식당주인의 정보까지)
		Restaurant restaurant = new Restaurant("판교 포차", "삼평동", "032-1222-3444", man1);
		restaurant.restaurantInfo();
		System.out.println("========================================================");
		//계란말이, 22000원, 판교 포차에서 판느 메뉴
		Menu menu1 = new Menu("계란말이", 22000, restaurant);
		menu1.printMenuInfo();
		System.out.println("========================================================");
		//석쇠불고기, 25000원, 판교 포차에서 파는 메뉴
		Menu menu2 = new Menu("석쇠불고기", 25000, restaurant);
		menu2.printMenuInfo();
		System.out.println("========================================================");
		//석쇠, 5000원, 석쇠불고기를 담은 접시
		Goods steelGrill = new Goods("석쇠", 5000, menu2);
		steelGrill.printInfo();
		System.out.println("========================================================");
		// 가락시장, 송파구. 석쇠를 구매한 시장
		Market market = new Market("가락시장", "송파구", steelGrill);
		market.printInfo();
		System.out.println("========================================================");
		//곽두팔, 가락시장을 좋아하는 상인
		Saler saler = new Saler("곽두팔", market);
		saler.printInfo();
		System.out.println("========================================================");
		
		System.out.println("*" + saler.getName() + "*");
		System.out.println("========================================================");
		saler.getMarket().printInfo();
		System.out.println("========================================================");
		//곽두팔이 좋아하는 시장은 어디에? 출력
		System.out.println(saler.getMarket().getLocation());
		System.out.println("========================================================");
		//곽두팔이 좋아하는 시장에서 산 접시 전체 정보
		saler.getMarket().getGoods().printInfo();
		System.out.println("========================================================");
		//곽두팔이 좋아하는 시장에서 산 접시의 가격
		System.out.println(saler.getMarket().getGoods().getPrice()); 
		
		System.out.println("========================================================");
		//곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴 정보
		saler.getMarket().getGoods().getMenu().printMenuInfo(); 
		
		System.out.println("========================================================");
		//곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴 가격
		System.out.println(saler.getMarket().getGoods().getMenu().getPrice()); 
		
		System.out.println("========================================================");
		//곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 판 식당 연락처
		System.out.println(saler.getMarket().getGoods().getMenu().getRestaurant().getPhoneNumber()); 
		
		System.out.println("========================================================");
		//곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 판 식당 주인 연락처
		System.out.println(saler.getMarket().getGoods().getMenu().getRestaurant().getOwner().getPhoneNumber()); 
		
		System.out.println("========================================================");
		//계란말이를 파는 사람 연락처
		System.out.println(menu1.getRestaurant().getOwner().getPhoneNumber()); 
		
		
		
		
		
	}
}
