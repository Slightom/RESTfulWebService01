package service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Message;
import resources.MessageService;

@Path("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getText() {
        return messageService.getAllMessages();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getJsons")
    public List<Message> getText2() {
        return messageService.getAllMessages();
    }
}
