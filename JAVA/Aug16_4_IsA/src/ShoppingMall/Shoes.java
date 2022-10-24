package ShoppingMall;

public class Shoes extends Product{
private int size;


public Shoes(String name, int price, int size) {
	super(name, price);
	this.size = size;
}

public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public void printInfo() {
	super.printInfo();
	System.out.println(size);
}
}
