package com.instinctools.reducerlink.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = User.COLLECTION_NAME)
public class User extends BaseEntity<ObjectId> {
    public static final String COLLECTION_NAME = "user";

    @Id
    private ObjectId id;

    private String firstName;

    private String lastName;

    private String middleName;

    private Long birth;

    private String status;

    public ObjectId getId() {
        return id;
    }

    public User setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public User setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Long getBirth() {
        return birth;
    }

    public User setBirth(Long birth) {
        this.birth = birth;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public User setStatus(String status) {
        this.status = status;
        return this;
    }
}
