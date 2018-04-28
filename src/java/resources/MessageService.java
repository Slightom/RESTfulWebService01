package resources;

import java.util.ArrayList;
import java.util.List;
import model.Message;


public class MessageService {
    private List<Message> list = new ArrayList<>();
    
    public MessageService(){
        Message m1 = new Message(1L, "Pierwsza wiadomość", "Tomek");
        Message m2 = new Message(2L, "Druga wiadomość", "Romek");
        Message m3 = new Message(3L, "Trzecia wiadomość", "Atomek");
    
        list.add(m1);
        list.add(m2);
        list.add(m3);
    }
    
    public List<Message> getAllMessages(){
        return list;
    }
}
