
public class TestProgram {

	public static void main(String[] args) {
		ClientBook manager = new ClientBook(); 
		Client c = new Client("Gihwon", "Youngin Suji", "010-2772-***", 1); 
		manager.addClient(c.getName(), c); 
		try { 
			manager.getClient("Gihwon").toString(); 
		System.out.println("Client is known as " + c); 
		manager.getClient("Kwon").toString(); 
		} 
		catch (UnknownClientException uke){ 
			System.out.println("No such client"); 
			}
	}

}
