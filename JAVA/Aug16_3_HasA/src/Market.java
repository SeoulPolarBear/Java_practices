
public class Market {
	private String name;
	private String location;
	private Goods goods;
	
	public Market(String name, String location, Goods goods) {
		super();
		this.name = name;
		this.location = location;
		this.goods = goods;
	}


	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Goods getGoods() {
		return goods;
	}



	public void setGoods(Goods goods) {
		this.goods = goods;
	}



	public void printInfo() {
		System.out.println(name);
		System.out.println(location);
		goods.printInfo();;
	}
}
