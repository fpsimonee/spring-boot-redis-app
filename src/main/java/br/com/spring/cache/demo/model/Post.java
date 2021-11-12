package br.com.spring.cache.demo.model;

import java.io.Serializable;

public class Post implements Serializable {

    private String createdAt;
    private String name;
    private String description;
    private String text;
    private String id;

    public Post() {
    }

    public Post(String createdAt, String name, String description, String text, String id) {
        this.createdAt = createdAt;
        this.name = name;
        this.description = description;
        this.text = text;
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
