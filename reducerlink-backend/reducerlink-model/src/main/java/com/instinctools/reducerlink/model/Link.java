package com.instinctools.reducerlink.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Link.COLLECTION_NAME)
public class Link extends BaseEntity<Long> {
    public static final String COLLECTION_NAME = "link";

    @Id
    private Long id;

    private String tag;

    private String comment;

    private String shortUrl;

    private String fullUrl;

    @DBRef
    private User user;

    public Long getId() {
        return id;
    }

    public Link setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Link setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Link setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public Link setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
        return this;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public Link setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Link setUser(User user) {
        this.user = user;
        return this;
    }
}