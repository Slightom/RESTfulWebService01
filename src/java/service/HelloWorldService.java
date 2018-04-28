package service;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHtml() {
        return "Witaj JAX-RS";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getHtml3() {
        return "Witaj JAX-RS3";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("echo")
    public String getHtml2() {
        return "Witaj echooo";
    }

    @GET
    @Path("/echo2/{parametr}")
    public String echo(@PathParam("parametr") String name) {
        return "Hello, parameter is: " + name;
    }

}
