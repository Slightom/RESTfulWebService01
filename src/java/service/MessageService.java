package service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Message;
import resources.MessageResource;

@Path("/messages")
public class MessageService {

    MessageResource messageResource = new MessageResource();

    // Rest czesc 1
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getText() {
        return messageResource.getAllMessages();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getJsons")
    public List<Message> getText2() {
        return messageResource.getAllMessages();
    }

    // Rest czesc 2
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") Long id) {
        return messageResource.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) {
        //return "post test";
        return messageResource.createMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(Message message) {
        //return "post test";
        return messageResource.updateMessage(message);
    }
}
