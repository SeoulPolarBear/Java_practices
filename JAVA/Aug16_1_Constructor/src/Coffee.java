
public class Coffee {
private String name;
private int price;

public Coffee() {//객체값을 초기화 하는데 목적이 있다/.
	// TODO Auto-generated constructor stub
}

public Coffee(String name, int price) {
	super();//위에 있는 기본 생성자를 불러오는 기능
	this.name = name;
	this.price = price;
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

public void printInfo() {
	System.out.printf("%s 가격 : %d\n", name, price);
}
}
