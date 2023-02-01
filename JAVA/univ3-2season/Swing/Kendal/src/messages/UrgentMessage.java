package messages;

public class UrgentMessage extends Message{
	
	final int COST =2;

	public UrgentMessage(String pClientID, String pText, int pDaysRemaining) {
		super(pClientID, pText, pDaysRemaining);
	}
	
	public String getText() {
		return "*** " + super.getText() + "*** ";
	}
	
	public int getCost() { 
		return COST;
	}
}
