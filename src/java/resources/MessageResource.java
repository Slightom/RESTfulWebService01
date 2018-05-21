package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Message;

public class MessageResource {

    static private Map<Long, Message> messages = new HashMap<Long, Message>();

    public MessageResource() {
        System.out.println("jestem w konstruktorze Message. mSize:" + messages.size());
        if (messages.isEmpty()) {
            messages.put(1L, new Message(1L, "Pierwsza wiadomość", "Tomek"));
            messages.put(2L, new Message(2L, "Druga wiadomość", "Romek"));
            messages.put(3L, new Message(3L, "Trzecia wiadomość", "Atomek"));
        }
    }

    private long generateId() {
        return messages.size() + 1;
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getAllMessages(Long size) {
        if (size != null) {
            int i = 0;
            ArrayList<Message> ls = new ArrayList<>();
            for (Object value : messages.values()) {
                if (++i > size) {
                    break;
                }
                ls.add((Message) value);
            }
            return ls;
        }
        return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(Long id) {
        return messages.get(id);
    }

    public Message createMessage(Message message) {
        System.out.println("jestem w create: " + message.toString());
        message.setId(generateId());
        messages.put(message.getId(), message);

        return messages.get(message.getId());
    }
 
    public Message updateMessage(Message message) {
        messages.put(message.getId(), message);
        return messages.get(message.getId());
    }

    public Message deleteMessage(Long id) {
        Message m = messages.get(id);
        messages.remove(id);
        return m;
    }

    public List<Message> getAllMessagesStartingWith(String par1) {
        Message m;
        ArrayList<Message> ls = new ArrayList<>();
        for (Object value : messages.values()) {
            m = (Message)value;
            if (m.getMessage().toLowerCase().startsWith(par1.toLowerCase())) {
                 ls.add(m);
            }
        }
        return ls;
    }

}
