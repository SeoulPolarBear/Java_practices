//��ü���� ����
//		A has a B : ����� has a �ڵ��� : ���԰���
//		A is a B : �� is a ���� : ��Ӱ���
public class HMain1 {
	public static void main(String[] args) {
		//�̸��� Kim Andrew, ����, �ڵ��� ��ȣ�� 010-1234-5678�� ���
		//���
		
		Human man1 = new Human("Kim Andrew","��","010-1234-5678");
		man1.HumanInfo();
		
		//�Ǳ� ����, ����, 032-1222-3444, Kim Andrew�� �Ĵ�
		//���(�Ĵ������� ��������)
		Restaurant restaurant = new Restaurant("�Ǳ� ����", "����", "032-1222-3444", man1);
		restaurant.restaurantInfo();
		System.out.println("========================================================");
		//�������, 22000��, �Ǳ� �������� �Ǵ� �޴�
		Menu menu1 = new Menu("�������", 22000, restaurant);
		menu1.printMenuInfo();
		System.out.println("========================================================");
		//����Ұ��, 25000��, �Ǳ� �������� �Ĵ� �޴�
		Menu menu2 = new Menu("����Ұ��", 25000, restaurant);
		menu2.printMenuInfo();
		System.out.println("========================================================");
		//����, 5000��, ����Ұ�⸦ ���� ����
		Goods steelGrill = new Goods("����", 5000, menu2);
		steelGrill.printInfo();
		System.out.println("========================================================");
		// ��������, ���ı�. ���踦 ������ ����
		Market market = new Market("��������", "���ı�", steelGrill);
		market.printInfo();
		System.out.println("========================================================");
		//������, ���������� �����ϴ� ����
		Saler saler = new Saler("������", market);
		saler.printInfo();
		System.out.println("========================================================");
		
		System.out.println("*" + saler.getName() + "*");
		System.out.println("========================================================");
		saler.getMarket().printInfo();
		System.out.println("========================================================");
		//�������� �����ϴ� ������ ���? ���
		System.out.println(saler.getMarket().getLocation());
		System.out.println("========================================================");
		//�������� �����ϴ� ���忡�� �� ���� ��ü ����
		saler.getMarket().getGoods().printInfo();
		System.out.println("========================================================");
		//�������� �����ϴ� ���忡�� �� ������ ����
		System.out.println(saler.getMarket().getGoods().getPrice()); 
		
		System.out.println("========================================================");
		//�������� �����ϴ� ���忡�� �� ���ÿ� ��� �޴� ����
		saler.getMarket().getGoods().getMenu().printMenuInfo(); 
		
		System.out.println("========================================================");
		//�������� �����ϴ� ���忡�� �� ���ÿ� ��� �޴� ����
		System.out.println(saler.getMarket().getGoods().getMenu().getPrice()); 
		
		System.out.println("========================================================");
		//�������� �����ϴ� ���忡�� �� ���ÿ� ��� �޴��� �� �Ĵ� ����ó
		System.out.println(saler.getMarket().getGoods().getMenu().getRestaurant().getPhoneNumber()); 
		
		System.out.println("========================================================");
		//�������� �����ϴ� ���忡�� �� ���ÿ� ��� �޴��� �� �Ĵ� ���� ����ó
		System.out.println(saler.getMarket().getGoods().getMenu().getRestaurant().getOwner().getPhoneNumber()); 
		
		System.out.println("========================================================");
		//������̸� �Ĵ� ��� ����ó
		System.out.println(menu1.getRestaurant().getOwner().getPhoneNumber()); 
		
		
		
		
		
	}
}
