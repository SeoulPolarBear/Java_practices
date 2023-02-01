package display;
import java.util.Collection;
import messages.Message;

public interface DisplayBoardControl {
	
	public void loadMessages(Collection<Message> pMessages);
	
	public void run();

}
