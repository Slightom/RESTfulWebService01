package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Message;

public class MessageResource {

    static private Map<Long, Message> messages = new HashMap<Long, Message>();
    private long idCounter = 0L;

    public MessageResource() {
        messages.put(generateId(), new Message(idCounter, "Pierwsza wiadomość", "Tomek"));
        messages.put(generateId(), new Message(idCounter, "Druga wiadomość", "Romek"));
        messages.put(generateId(), new Message(idCounter, "Trzecia wiadomość", "Atomek"));
    }

    private long generateId() {
        return ++idCounter;
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(Long id) {
        return messages.get(id);
    }

    public Message createMessage(Message message) {
        message.setId(generateId());
        messages.put(message.getId(), message);

        return messages.get(message.getId());
    }

    public Message updateMessage(Message message) {
        messages.put(message.getId(), message);
        return messages.get(message.getId());
    }
}
