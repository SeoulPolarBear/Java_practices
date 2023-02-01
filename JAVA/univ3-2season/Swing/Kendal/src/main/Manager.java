package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane; 

import clients.ClientBook;

import messages.MessageSet;

public class Manager{
	private final String MMS_DATA_FILE = "mmsdata.dat";
	
	ClientBook cb;
	
	MessageSet ms;
	
	public void startUp(){
		try {
			FileInputStream fis = new FileInputStream(MMS_DATA_FILE); 
            ObjectInputStream ois = new ObjectInputStream(fis);

            cb = ClientBook.readFromFile(ois);

            ms = MessageSet.readFromFile(ois);
            fis.close();

		} 
		catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, 
					"No existing client/message data found");
			cb = new ClientBook();
			ms = new MessageSet(cb);
			} 
		catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "" + ioe);
			System.exit(1);
			}
	}
	

	public void shutDown(){

		try {
			FileOutputStream fos = new FileOutputStream(MMS_DATA_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			cb.saveToFile(oos);
			ms.saveToFile(oos);
			fos.close();

		}
		catch (IOException ioe){
			JOptionPane.showMessageDialog(null, "" + ioe);
			}
		}
	
	public ClientBook getClientBook(){
		return cb;
	}
	
	public MessageSet getMessageSet(){
		return ms;
	}
}