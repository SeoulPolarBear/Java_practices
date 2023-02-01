package messages;

import java.io.Serializable;

public class Message implements Serializable {
	final int COST = 1;
	
	private String clientID;
	private String messageText;
	private int daysRemaining;
	
	public Message( String pClientID, String pText, int pDaysRemaining) {
		clientID = pClientID;
		messageText = pText;
		daysRemaining = pDaysRemaining;
		
	}

	
	public void decrementDays() {
		daysRemaining--;
	}

    public boolean hasExpired() {
    	return (daysRemaining == 0);
    }

    
    public String getClientID() { 
    	return clientID;
    }
    
    public String getText() {
    	return messageText;
    }
    
    public int getCost() {
    	return COST;
    }
    
    public int hashCode() { 
    	return (clientID + messageText).hashCode();
    	
    }
    
    public boolean equals(Object pOther) {
    	Message otherMsg = (Message) pOther;
    	
    	return (clientID.equals(otherMsg.clientID)&& messageText
    			.equals(otherMsg.messageText));
    }
    
    public String toString() {
    	return ("Message text: " + messageText + "\nClient" + clientID
    			+ "\nDays left: " + daysRemaining);
    }
}
