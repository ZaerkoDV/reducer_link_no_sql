package com.instinctools.reducerlink.dao;

import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.UserPhoto;

public interface UserPhotoDao extends BaseDao<UserPhoto, ObjectId> {
    public UserPhoto getUserPhotoByIdUser(ObjectId idUser);
    public ObjectId getIdUserPhotoByIdUser(ObjectId idUser);
}
