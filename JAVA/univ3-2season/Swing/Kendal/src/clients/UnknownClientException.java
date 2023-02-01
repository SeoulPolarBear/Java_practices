package clients;

import java.lang.Exception;

public class UnknownClientException extends Exception {

	UnknownClientException(String pMessage){
		super(pMessage);
	}
}
