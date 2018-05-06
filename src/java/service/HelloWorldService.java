package service;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldService {

    // ćwiczenie 1
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHtml() {
        return "Siema! To jest metoda getHtml() - pierwsza jej wersja";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String getHtml3() {
        return "Metoda post bez Path";
    }

    // ćwiczenie 2
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("echo")
    public String getHtml2() {
        return "Witaj echooo - to jest 2. metoda";
    }

    // ćwiczenie 3
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/echo2/{p1}/{p2}")
    public String echo(@PathParam("p1") String p1, @PathParam("p2") String p2) {
        return "Hello, first  parameter is: " + p1 + "\n"
                + "       second parameter is: " + p2;
    }

}
