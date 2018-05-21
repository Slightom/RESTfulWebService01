package model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Products {

    static private List<Product> products= new ArrayList<Product>();

    public Products(List<Product> productsx) {
        this.products = productsx;
    }
    

    public Products() {
        if(products.isEmpty()){
            products.add(new Product("helikopter", 100000, "DragonFly"));
            products.add(new Product("tabakiera", 5, "AmericanTobacco"));
            products.add(new Product("kajak", 400, "JAKKA"));
            products.add(new Product("baton", 2, "GoodEnergy"));
            products.add(new Product("gitara", 700, "CORT"));
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Products{" + "products=" + products + '}';
    }

}
