package clients;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ClientBook implements Serializable {
	
	private Map<String, Client> clientMap;
	
	public ClientBook() {
		clientMap = new HashMap<String, Client>();
	}

	public void addClient(String pClientID, Client pNewClient) {
		clientMap.put(pClientID, pNewClient);
	}
	
	public Client getClient(String pClientID ) throws UnknownClientException{
		Client foundClient;
		
		foundClient = clientMap.get(pClientID);
		
		if (foundClient != null) {
			return foundClient;
			}
		else {
			throw new UnknownClientException(
					"ClientBook.getClient(): unknown client ID:" + pClientID);
		}
	}
	
	public void deleteClient(String pClientID) throws UnknownClientException {
		Client removedClient;
		
		removedClient = clientMap.remove(pClientID);
		
		if (removedClient == null) {
			throw new UnknownClientException(
					"ClientBook.getClient(): unknown client ID:" + pClientID);
		}
	}
			
			public void saveToFile(ObjectOutputStream oos) {
				try {
					oos.writeObject(this);
					
				}
				catch (IOException ioe) {
					JOptionPane.showMessageDialog(null, "" + ioe);
				}
			}
		
			static public ClientBook readFromFile(ObjectInputStream ois) {
				ClientBook cb = null;
				
				try {
					cb = (ClientBook) ois.readObject();
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
	

