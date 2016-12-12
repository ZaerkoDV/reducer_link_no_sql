package com.instinctools.reducerlink.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = UserPhoto.COLLECTION_NAME)
public class UserPhoto extends BaseEntity<ObjectId> {
    public static final String COLLECTION_NAME = "user_photo";

    @Id
    private ObjectId id;

    private Long createdAtTimestamp;

    private byte[] photoData;

    @DBRef
    private User user;

    public ObjectId getId() {
        return id;
    }

    public UserPhoto setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public Long getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

    public UserPhoto setCreatedAtTimestamp(Long createdAtTimestamp) {
        this.createdAtTimestamp = createdAtTimestamp;
        return this;
    }

    public byte[] getPhotoData() {
        return photoData;
    }

    public UserPhoto setPhotoData(byte[] photoData) {
        this.photoData = photoData;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserPhoto setUser(User user) {
        this.user = user;
        return this;
    }
}