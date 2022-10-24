//계란말이, 석쇠불고기 관련 정보
public class Menu {
private String name;
private int price;
private Restaurant restaurant;

public Menu(String name, int price, Restaurant restaurant) {
	super();
	this.name = name;
	this.price = price;
	this.restaurant = restaurant;
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

public Restaurant getRestaurant() {
	return restaurant;
}

public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}
public void printMenuInfo() {
	System.out.println(name);
	System.out.println(price);
	restaurant.restaurantInfo();
}
}
