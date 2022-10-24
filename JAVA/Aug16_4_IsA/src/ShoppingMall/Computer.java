package ShoppingMall;

public class Computer extends Product{
private String cpu;
private int ram;
private int hdd;

public Computer(String name, int price, String cpu, int ram, int hdd) {
	super(name, price);
	this.cpu = cpu;
	this.ram = ram;
	this.hdd = hdd;
}

public String getCpu() {
	return cpu;
}

public void setCpu(String cpu) {
	this.cpu = cpu;
}

public int getRam() {
	return ram;
}

public void setRam(int ram) {
	this.ram = ram;
}

public int getHdd() {
	return hdd;
}

public void setHdd(int hdd) {
	this.hdd = hdd;
}
@Override
public void printInfo() {
	super.printInfo();
	System.out.println(cpu);
	System.out.println(ram + "GB");
	System.out.println(hdd + "GB");
}
}
