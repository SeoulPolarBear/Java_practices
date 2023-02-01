package main;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import messages.Message;
import messages.UrgentMessage;
import clients.Client;
import clients.UnknownClientException;
import display.DummyBoard;

public class GUImain {
	
private JTextField clientClientID;
private JTextField clientName;
private JTextField clientAddress;
private JTextField clientPhone;
private JTextField clientCredits;
private JTextField messageClientID;
private JTextField messageText;
private JTextField messageDays;
Manager manager = new Manager();

	public static void main(String[] args) {
		GUImain uim = new GUImain();
		uim.createGUI();

	}

	public void createGUI() {
		// main frame
	JFrame frame = new JFrame("Message Management System v2.0");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	Container cp = frame.getContentPane();
	cp.setLayout(new GridLayout(1, 3));
	
	// client panel
	JPanel cliPan = new JPanel();
	cliPan.setLayout(new GridLayout(7, 2));
	cliPan
	        .setBorder(BorderFactory
	           .createEtchedBorder(EtchedBorder.LOWERED));
	cliPan.add(new JLabel("NEW CLIENTS"));
	cliPan.add(new JLabel("")); 
	cliPan.add(new JLabel("Client ID"));
	cliPan.add(clientClientID = new JTextField());
	cliPan.add(new JLabel("Name"));
	cliPan.add(clientName = new JTextField());
	cliPan.add(new JLabel("Address"));
	cliPan.add(clientAddress = new JTextField());
	cliPan.add(new JLabel("Phone"));
	cliPan.add(clientPhone = new JTextField());
	cliPan.add(new JLabel("Credits"));
	cliPan.add(clientCredits = new JTextField());
	
	cliPan.add(new JLabel(""));
	JButton jb = new JButton("Add Client");
	jb.addActionListener(new AddClientListener());
	cliPan.add(jb); 
	
	cp.add(cliPan);
	
	// message panel
	JPanel msgPan = new JPanel();
	msgPan.setLayout(new GridLayout(6, 2));
	msgPan 
	.setBorder(BorderFactory 
	.createEtchedBorder(EtchedBorder.LOWERED));
	msgPan.add(new JLabel("NEW MESSAGES"));
	msgPan.add(new JLabel(""));
	msgPan.add(new JLabel("Client ID"));
	msgPan.add(messageClientID = new JTextField());
	msgPan.add(new JLabel("Text")); 
	msgPan.add(messageText = new JTextField());
	msgPan.add(new JLabel("Days"));
	msgPan.add(messageDays = new JTextField());
	
	msgPan.add(new JLabel(""));
	jb = new JButton("Add Message");
	jb.addActionListener(new AddMessageListener()); 
	msgPan.add(jb);
	
	msgPan.add(new JLabel("")); 
	jb = new JButton("Add Urgent Message"); 
	jb.addActionListener(new AddUrgentMessageListener());
	msgPan.add(jb);
	
	cp.add(msgPan);
	
	// button panel
	JPanel btnPan = new JPanel();
	btnPan.setLayout(new GridLayout(8, 1));
	btnPan 
	.setBorder(BorderFactory 
			.createEtchedBorder(EtchedBorder.LOWERED)); 
	
	jb = new JButton("Find Client"); 
	jb.addActionListener(new FindClientListener());
	btnPan.add(jb); 

	jb = new JButton("Increase Credit"); 
	jb.addActionListener(new IncreaseCreditListener());
    btnPan.add(jb); 

    jb = new JButton("Delete Client"); 
    jb.addActionListener(new DeleteClientListener());
    btnPan.add(jb); 

    btnPan.add(new JLabel());

    jb = new JButton("Display Messages"); 
    jb.addActionListener(new DisplayMessagesListener()); 
    btnPan.add(jb); 

    jb = new JButton("Purge Messages"); 
    jb.addActionListener(new PurgeMessagesListener()); 
    btnPan.add(jb); 

    btnPan.add(new JLabel());

    jb = new JButton("Save and Exit"); 
    jb.addActionListener(new SaveAndExitListener());
    btnPan.add(jb); 

    cp.add(btnPan); 

    frame.pack(); 
    frame.setVisible(true); 

    manager.startUp();
    }

	private class AddClientListener implements ActionListener {
public void actionPerformed(ActionEvent arg0) { 

	Client c = new Client(clientName.getText(), 
clientAddress.getText(), clientPhone.getText(), Integer 
.parseInt(clientCredits.getText())); 
manager.getClientBook().addClient(clientClientID.getText(), c);
      } 
   }

private class FindClientListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {

		String id = JOptionPane.showInputDialog(null, "Enter client ID"); 
  if (id == null) 

	  id = ""; // workaround in case Cancel pressed 
try { 
JOptionPane.showMessageDialog(null, manager.getClientBook() 
 .getClient(id).toString()); 
} 
catch (UnknownClientException uke) { 
JOptionPane.showMessageDialog(null, "No such client");

      } 
    } 
 } 

private class IncreaseCreditListener implements ActionListener { 

	public void actionPerformed(ActionEvent arg0) { 

		String id = JOptionPane.showInputDialog(null, "Enter client ID"); 
 if (id == null)
      id = ""; // workaround in case Cancel pressed 

 try { 
	 Client c = manager.getClientBook().getClient(id); 
   String raw;
   int extraCredit; 
raw = JOptionPane.showInputDialog(null, 
"Enter extra credit units");
if (raw == null) 
raw = ""; // workaround in case Cancel pressed 
try { 
extraCredit = Integer.parseInt(raw); 
} catch (NumberFormatException exception) {
extraCredit = 0; 
} 
 c.increaseCredit(extraCredit); 
} 
 catch (UnknownClientException uce) {
JOptionPane.showMessageDialog(null, "No such client");
    } 
  } 
}

private class DeleteClientListener implements ActionListener {
public void actionPerformed(ActionEvent arg0) {
String id = JOptionPane.showInputDialog(null, "Enter client ID");
if (id == null) 
id = ""; // workround in case Cancel pressed 
try { 
manager.getClientBook().deleteClient(id);
} 
catch (UnknownClientException uke) {
JOptionPane.showMessageDialog(null, "No such client"); 
     }
  } 
} 

private class AddMessageListener implements ActionListener { 
public void actionPerformed(ActionEvent arg0) {
Message m = new Message(messageClientID.getText(), messageText 
.getText(), Integer.parseInt(messageDays.getText())); 
manager.getMessageSet().addMessage(m); 
    }
  } 

private class AddUrgentMessageListener implements ActionListener {
public void actionPerformed(ActionEvent arg0) {
Message m = new UrgentMessage(messageClientID.getText(), 
messageText.getText(), Integer.parseInt(messageDays 
                .getText())); 
 manager.getMessageSet().addMessage(m); 

    } 
  } 

private class DisplayMessagesListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		DummyBoard db = new DummyBoard();

manager.getMessageSet().display(db); 
    }
  }

private class PurgeMessagesListener implements ActionListener { 
public void actionPerformed(ActionEvent arg0) { 
manager.getMessageSet().dailyPurge();
    }
  } 
private class SaveAndExitListener implements ActionListener {
    
	public void actionPerformed(ActionEvent arg0) { 
     manager.shutDown(); 
     System.exit(0); 
       }
     } 
   }


