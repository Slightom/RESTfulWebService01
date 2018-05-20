package client;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Message;

/**
 *
 * @author Slightom
 */
public class RESTfulClient01 {

    // doesnt work i dont know why
    public static void main(String[] args) {
        Get("2");
        //Post();
        //GetAll();
    }

    public static void Get(String messageId) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:21346/RESTfulWebService01/webresources/messages/" + messageId);
        
        //way 1
        Response response = target.request().get();
        System.out.println("response11: " + response);
        Message message = response.readEntity(Message.class);
        System.out.println("message11: " + message.toString());
        
        //way 2
        String message2 = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("message12: " + message2);
    }

    private static void GetAll() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:21346/RESTfulWebService01/webresources/messages/");

        // way 1
        String messages = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("messages21: " + messages);
        
        // way 2
        List<Message> messages2 = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Message>>(){});
        System.out.println("messages22: " + messages2);
    }
    
    private static void Post(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:21346/RESTfulWebService01/webresources/messages/");
        Message m = new Message(5, "wiadomosc piate", "Taco");
        
        Object s = Entity.json(m);
        
        Response response = target.request().post(Entity.json(m));
        System.out.println("response31: " + response);
    }
}
