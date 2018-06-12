package model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Slightom
 */
@XmlRootElement
public class Comment {
    private String author;
    private Date created;
    private String message;

    public Comment() {
    }

    public Comment(String author, String message) {
        this.author = author;
        this.created = new Date();
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}