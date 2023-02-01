package tests;

import junit.framework.TestCase;
import clients.Client;
import clients.ClientBook;
import clients.UnknownClientException;

public class ClientTests extends TestCase {
	
	public void testAddClient() {
		ClientBook cb = new ClientBook();
		Client c= new Client("Simon", "Room 217", "x2756", 10);
		Client c2 = null;
		cb.addClient("sk", c);
		try {
			c2 = cb.getClient("sk");
		}
		catch (UnknownClientException uce) {
			fail();
		}
	assertEquals(10,c2.getCredit());
	}
	
	public void testGetUnknownClient() {
		ClientBook cb = new ClientBook();
		try {
			cb.getClient("sk");
			fail();
			} catch (UnknownClientException uce) {
		}
	}
	public void testClientToString() {
		ClientBook cb = new ClientBook();
		Client c = new Client("Simon", "Room 217", "x2756", 10);
		cb.addClient("sk", c);
		assertEquals("Client name: Simon\nAddress: Room 217"
		+ "\nPhone: x2756\nCurrent credit: 10", c.toString());
	}

	public void testIncreaseCredit() {
		Client c = new Client("Simon", "Room 217", "x2756", 10);
		c.increaseCredit(10);
		assertEquals(20, c.getCredit());
		}
	
	public void testDeleteClient() {
		ClientBook cb = new ClientBook();
		Client c = new Client("Simon", "Room 217", "x2756", 10);
		cb.addClient("sk", c);
		try {
			cb.deleteClient("sk");
			} catch (UnknownClientException uce) {
				fail();
				}
		try {
			c = cb.getClient("sk");
			fail();
			} catch (UnknownClientException uce) {
				
		}
	}

}
