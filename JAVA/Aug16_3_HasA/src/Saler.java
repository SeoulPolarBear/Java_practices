public class Saler {
	private String name;
	private Market market;
	
	public Saler(String name, Market market) {
		super();
		this.name = name;
		this.market = market;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}
	
	public void printInfo() {
		System.out.println(name);
		market.printInfo();;
	}
	
}
