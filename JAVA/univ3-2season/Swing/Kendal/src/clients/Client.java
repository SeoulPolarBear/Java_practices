package clients;
import java.io.Serializable;

public class Client implements Serializable {
	
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

	public int getCredit() {
		return credit;
	}
	
	public void decreaseCredit(int pDecrease) {
		credit = credit - pDecrease;
	}
	
	public void increaseCredit(int pExtraCredit) {
		credit = credit + pExtraCredit;
	}
	
	public String toString() {
		return ("Client name: " + name + "\nAddress: " + address + "\nPhone: " 
	+ phone + "\nCurrent credit: " + credit);
	}
}
