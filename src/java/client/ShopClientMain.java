package client;

import java.security.AllPermission;
import java.util.List;
import model.*;
import service.ResponseList;

public class ShopClientMain {

    public static void main(String[] args) {

        //SelectAll();
        SelectFiltered("a", "a", 5000);
    }

    private static void SelectAll() {
        ShopClient client = new ShopClient();
        ResponseList allProducts = client.getAllProducts(ResponseList.class);

        List<Product> lp = allProducts.getList();

        for (Product p : allProducts.getList()) {
            System.out.println(p.getName());
        }
    }

    private static void SelectFiltered(String string, String string1, int par) {
        ShopClient client = new ShopClient();
        ResponseList products = client.findProducts(string, string1, par);

        List<Product> lp = products.getList();

        for (Product p : products.getList()) {
            System.out.println(p.getName());
        }
    }
}
