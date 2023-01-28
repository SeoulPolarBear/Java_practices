import java.util.HashMap;
import java.util.Map;

public class ClientBook {
private Map<String, Client> clientMap;
public ClientBook() {
clientMap = new HashMap<String, Client>();
 }
public void addClient(String pClientID, Client pNewClient) {
clientMap.put(pClientID, pNewClient);
 }
public Client getClient(String pClientID) throws UnknownClientException {
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

}
