import java.util.ArrayList;
/** 4. A first-in, first-out collection of messages. 
 * This implementation is not very efficient. We will consider 
 * a more efficient implementation in chapter  */



public class MessageQueue {
	
	private ArrayList<Message> queue;
	
	public MessageQueue() {
		queue = new ArrayList<Message>();
	}

	
	/**Remove message at head.
 @return message that has been removed from the queue  */
	
	public Message remove()
	{
		return queue.remove(0);
		
	}
	
	public void add(Message newMessage)
	{
		queue.add(newMessage);
	}
	
	/** Get the total number of messages in the queue. 
 @return the total number of messages in the queue*/
	
	public int size()
	{
		return queue.size();
	}
	
	public Message peek()
	{
		if(queue.size()==0)
			return null;
		else return queue.get(0);
	}
	
}
