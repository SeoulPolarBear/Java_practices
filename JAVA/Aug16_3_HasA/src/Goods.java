
public class Goods {
	private String name;
	private int price;
	private Menu menu;
	
	public Goods(String name, int price, Menu menu) {
		super();
		this.name = name;
		this.price = price;
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
		menu.printMenuInfo();;
	}
}
