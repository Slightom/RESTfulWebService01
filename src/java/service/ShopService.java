package service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import model.*;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/shop")
public class ShopService {
    private Products products = new Products();
    
    @Context
    private UriInfo context;
    
    public ShopService(){
    }
    
    @GET
    @Path("/allproducts")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseList getAllProducts(){
        System.out.println("jestem: ");
        List<Product> allProducts = products.getProducts();
        ResponseList responseList = new ResponseList();
        responseList.setList(allProducts);
        
        System.out.println("jestem: " + responseList.toString());
        return responseList;
    }
}
