
public class Restaurant {
	private String name;
	private String position;
	private String phoneNumber;
	private Human owner;
	
	public Restaurant(String name, String position, String phoneNumber, Human owner) {
		super();
		this.name = name;
		this.position = position;
		this.phoneNumber = phoneNumber;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Human getOwner() {
		return owner;
	}

	public void setOwner(Human owner) {
		this.owner = owner;
	}
	
	public void restaurantInfo() {
		System.out.println(name);
		System.out.println(position);
		System.out.println(phoneNumber);
		owner.HumanInfo();
	}
	
	
}
