package service;

import java.net.URI;
import model.Message;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import model.Comment;
import org.hibernate.validator.constraints.URL;
import resources.MessageResource;


@Path("/messages")
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
    public Response getMessage(@PathParam("messageId") Long id, @Context UriInfo uriInfo) {
        Message message = messageResource.getMessage(id);

        String self = uriInfo.getBaseUriBuilder()
                .path(MessageService.class)
                .path(String.valueOf(message.getId()))
                .build().toString();
        message.addLink("self", self);

        String comments = uriInfo.getBaseUriBuilder()
                .path(MessageService.class)
                .path(MessageService.class, "getCommentResource")
                .resolveTemplate("messageId", message.getId())
                .build().toString();
        message.addLink("comments", comments);

        return Response.ok(message).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMessage(Message message, @Context UriInfo uriInfo) {
        System.out.println("jestem w poscie: " + message.toString());
        
        Message newMessage = messageResource.createMessage(message);
        String newId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        Response response = Response.created(uri).entity(newMessage).build();
        
        return response;
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
    
    
    
    //rest 4
    @GET
    @Path("/{messageId}/comments")
    public List<Comment> getCommentResource(@PathParam("messageId") Long id) {
        return CommentService.getInstance().getCommentsFor(id);
    }
}
