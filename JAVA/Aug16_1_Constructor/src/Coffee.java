
public class Coffee {
private String name;
private int price;

public Coffee() {//��ü���� �ʱ�ȭ �ϴµ� ������ �ִ�/.
	// TODO Auto-generated constructor stub
}

public Coffee(String name, int price) {
	super();//���� �ִ� �⺻ �����ڸ� �ҷ����� ���
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
	System.out.printf("%s ���� : %d\n", name, price);
}
}
