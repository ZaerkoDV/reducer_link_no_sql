package com.instinctools.reducerlink.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = UserSecurity.COLLECTION_NAME)
public class UserSecurity extends BaseEntity<Long> {
    public static final String COLLECTION_NAME = "user_security";

    @Id
    private Long id;

    private String login;

    private String password;

    private String role;

    private String token;

    @DBRef
    private User user;

    @Override
    public Long getId() {
        return id;
    }

    public UserSecurity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserSecurity setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserSecurity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserSecurity setRole(String role) {
        this.role = role;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserSecurity setToken(String token) {
        this.token = token;
        return this;
    }

    public User getUser(){
        return user;
    }

    public UserSecurity setUser(User user) {
        this.user = user;
        return this;
    }
}