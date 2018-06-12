package service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SearchParam {
    String name;
    String maker;
    int priceLowerThan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getPriceLowerThan() {
        return priceLowerThan;
    }

    public void setPriceLowerThan(int priceLowerThan) {
        this.priceLowerThan = priceLowerThan;
    }
    
}
