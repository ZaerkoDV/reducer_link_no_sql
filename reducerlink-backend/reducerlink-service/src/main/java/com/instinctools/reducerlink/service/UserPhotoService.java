package com.instinctools.reducerlink.service;

import java.awt.image.BufferedImage;
import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.UserPhoto;

public interface UserPhotoService {
    public BufferedImage getPhotoById(ObjectId idPhoto);
    public UserPhoto saveUserPhoto(ObjectId idUser, long currentTimestamp, byte[] imageFile);
    public Boolean deleteUserPhoto(ObjectId idPhoto);
    public BufferedImage getUserPhotoByIdUser(ObjectId idUser);
    public ObjectId getIdUserPhotoByIdUser(ObjectId idUser);
}
