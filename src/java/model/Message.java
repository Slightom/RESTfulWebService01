package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message{

    private long id;
    private String message;
    private Date created;
    private String author;
    
    private List<Link> links = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Message() {

    }

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String toString(){
        return "<" +getId() + ", " + getAuthor() + ", " + getCreated() + ", " + getMessage() + ">";
    }
    
    public void addLink(String rel, String link) {
        Link newLink = new Link(rel, link);
        
        for(Link l: links){
            if(l.getRel() == newLink.getRel()){
                return;
            }
        }
        
        links.add(newLink);
    }
}
