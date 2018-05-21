package service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Message;
import resources.MessageResource;

//@Path("/messages")
public class MessageService {

    MessageResource messageResource = new MessageResource();

    // Rest czesc 1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getText(@QueryParam("size") Long size, @HeaderParam("user-agent") String userAgent, @MatrixParam("author") String author) {
        //System.out.println("size: " + size);
        //System.out.println("HeaderParam: " + userAgent);
        //System.out.println("MatrixParent: " + author);
        return messageResource.getAllMessages(size);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getJsons")
    public List<Message> getText2() {
        return messageResource.getAllMessages();
    }

    // Rest czesc 2
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") Long id) {
        return messageResource.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) {
        System.out.println("jestem w poscie: " + message.toString());
        return messageResource.createMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(Message message) {
        return messageResource.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public Message delete(@PathParam("messageId") Long id) {
        return messageResource.deleteMessage(id);
    }

    @GET
    @Path("/filtr")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@QueryParam("zaczynasie") String par1) {
        if (par1 != null) {
            return messageResource.getAllMessagesStartingWith(par1);
        }

        return messageResource.getAllMessages();
    }
}
