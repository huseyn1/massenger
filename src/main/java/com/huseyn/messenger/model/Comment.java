package com.huseyn.messenger.model;
import java.util.Date;

public class Comment {
    
    private int id;
    private String  message;
    private Date created;
    private String author;

    public Comment() {
    }

    public Comment(int id, String message, Date created, String author) {
        this.id = id;
        this.message = message;
        this.created = created;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
}
