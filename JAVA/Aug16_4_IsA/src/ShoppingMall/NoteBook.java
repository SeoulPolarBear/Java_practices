package ShoppingMall;

public class NoteBook extends Computer{

	private double weight;
	private double battery;
	
	
	public NoteBook(String name, int price, String cpu, int ram, int hdd, double weight, double battery) {
		super(name, price, cpu, ram, hdd);
		this.weight = weight;
		this.battery = battery;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBattery() {
		return battery;
	}

	public void setBattery(double battery) {
		this.battery = battery;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(weight);
		System.out.println(battery);
	}
}
