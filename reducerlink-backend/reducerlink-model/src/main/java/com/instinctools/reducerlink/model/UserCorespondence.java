package com.instinctools.reducerlink.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = UserCorespondence.COLLECTION_NAME)
public class UserCorespondence extends BaseEntity<ObjectId> {
    public static final String COLLECTION_NAME = "user_corespondence";

    @Id
    private ObjectId id;

    private String email;

    private String skype;

    private String phone;

    private String ipAddress;

    @DBRef
    private User user;

    public ObjectId getId() {
        return id;
    }

    public UserCorespondence setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserCorespondence setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSkype() {
        return skype;
    }

    public UserCorespondence setSkype(String skype) {
        this.skype = skype;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserCorespondence setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public UserCorespondence setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserCorespondence setUser(User user) {
        this.user = user;
        return this;
    }
}