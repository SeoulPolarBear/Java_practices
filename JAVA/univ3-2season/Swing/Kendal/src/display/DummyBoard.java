package display;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import messages.Message;

public class DummyBoard implements DisplayBoardControl {
	private List<Message> messageList;
	
	public DummyBoard() { 
		messageList =null;
	}
	
	public void loadMessages(Collection<Message> pMessages) {
		messageList = new ArrayList<Message>(pMessages);
	}
	
	public void run() {
		for (Message msg : messageList) {
			JOptionPane.showMessageDialog(null, msg.getText());
		}
	}

}
