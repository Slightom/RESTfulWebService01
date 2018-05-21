package service;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import model.Product;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseList {

    @XmlElement(name = "products")
    private List<Product> list;

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> listx) {
        this.list = listx;
    }

    @Override
    public String toString() {
        return "ResponseList{" + "list=" + list + '}';
    }
}
