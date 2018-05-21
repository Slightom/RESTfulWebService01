package model;

public class Product {

    private String name;
    private int price;
    private String maker;

    public Product(String namex, int pricex, String makerx) {
        this.name = namex;
        this.price = pricex;
        this.maker = makerx;
    }
    
    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
