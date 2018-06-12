package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import service.ResponseList;
import service.SearchParam;

public class ShopClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTfulWebService01/webresources";

    public ShopClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("shop");
    }

    public <T> T getAllProducts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allproducts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }

    public ResponseList findProducts(String name, String maker, int price) {
        WebTarget resource = webTarget;
        resource = resource.path("findProducts");

        SearchParam searchParam = new SearchParam();
        searchParam.setName(name);
        searchParam.setMaker(maker);
        searchParam.setPriceLowerThan(price);

        ResponseList responseList
                = resource.request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(searchParam, MediaType.APPLICATION_JSON), ResponseList.class);

        return responseList;
    }

}
