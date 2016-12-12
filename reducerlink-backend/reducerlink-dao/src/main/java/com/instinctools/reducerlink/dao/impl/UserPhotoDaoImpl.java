package com.instinctools.reducerlink.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.instinctools.reducerlink.dao.UserPhotoDao;
import com.instinctools.reducerlink.model.UserPhoto;

@Repository
public class UserPhotoDaoImpl extends BaseDaoImpl<UserPhoto, ObjectId> implements UserPhotoDao {
    public UserPhotoDaoImpl() {
       super(UserPhoto.class);
    }

    @SuppressWarnings("")
    public UserPhoto getUserPhotoByIdUser(ObjectId idUser) {
        Query query = super.createCriteria(
            Criteria.where("id").in("user").is(idUser)
        );

        return (UserPhoto) super.executeQuery(query);
    }

    @SuppressWarnings("")
    public ObjectId getIdUserPhotoByIdUser(ObjectId idUser) {
        Query query = super.createCriteria(
            Criteria.where("id").in("user").is(idUser)
        );
        query.fields().include("id");

        return (ObjectId)super.executeQuery(query);
    }
}
