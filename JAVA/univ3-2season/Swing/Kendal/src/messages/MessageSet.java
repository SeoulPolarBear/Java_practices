package messages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import clients.Client;
import clients.ClientBook;
import clients.UnknownClientException;
import display.DisplayBoardControl;

public class MessageSet implements Serializable{
	
	private Set<Message> messageSet;
	
	private ClientBook clients;
	
	public MessageSet(ClientBook pClients) {
		clients = pClients;
		messageSet = new HashSet<Message>();
	}

	public void addMessage(Message pMsgToAdd) {
		messageSet.add(pMsgToAdd);
	}
	
	public void display(DisplayBoardControl db) {
		db.loadMessages(messageSet);
		db.run();
	}
	
	public void dailyPurge() {
		
		Client client;
		
		for(Message msg : messageSet) {
			
			msg.decrementDays();
			
			try {
				client = clients.getClient(msg.getClientID());
				client.decreaseCredit(msg.getCost());
				
				if (msg.hasExpired() || client.getCredit()<=0) {
					messageSet.remove(msg);
				}
			}
		catch (UnknownClientException uce) {
			JOptionPane.showMessageDialog(null, "INTERNAL ERROR IN MessageSet.Purge()\n"  
		+ "Exception details: " + uce + 
		"\nMesssage details:\n" + msg);
			
			if (msg.hasExpired()) {
				messageSet.remove(msg);
			}
		}
		}
	}

	public void saveToFile(ObjectOutputStream oos) {
		try {
			oos.writeObject(this);
		}
		catch(IOException ioe) {
			JOptionPane.showMessageDialog(null,"" +  ioe);
		}
		
	}
	
	static public MessageSet readFromFile(ObjectInputStream ois) {
		MessageSet cb = null;
		
		try {
			cb = (MessageSet) ois.readObject();
		}
		catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "" + ioe); 
			System.exit(1); 
			} 
		catch (ClassNotFoundException cnfe) { 
		JOptionPane.showMessageDialog(null, "" + cnfe); 
		System.exit(1); 
		} 
		return cb;
			
		}
	}


