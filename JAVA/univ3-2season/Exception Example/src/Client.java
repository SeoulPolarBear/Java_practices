
public class Client {

	private String name;
	private String address;
	private String phone;
	private int credit;
	public Client(String pName, String pAddress, String pPhone, int pCredit) {
	name = pName;
	address = pAddress;
	phone = pPhone;
	credit = pCredit;
	}
	public String getName() {
	return name;
	}
	public int getCredit() {
	return credit;
	}
	public String toString() {
	return ("Client name: " + name + "\nAddress: " + address + "\nPhone: "
	+ phone + "\nCurrent credit: " + credit);
	
	}
	
	public void determineCreditRating() {
		if(credit<=2)
			System.out.println(name + "대출 대상 입니다.");
		else
		System.out.println(name + "대출 대상이 아닙니다.");
	}
}
