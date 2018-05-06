package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Message;

public class MessageResource {

    static private Map<Long, Message> messages = new HashMap<Long, Message>();

    public MessageResource() {
        messages.put(1L, new Message(1L, "Pierwsza wiadomość", "Tomek"));
        messages.put(2L, new Message(2L, "Druga wiadomość", "Romek"));
        messages.put(3L, new Message(3L, "Trzecia wiadomość", "Atomek"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }
    
    public Message getMessage(Long id){
        return messages.get(id);
    }
    
    
}
