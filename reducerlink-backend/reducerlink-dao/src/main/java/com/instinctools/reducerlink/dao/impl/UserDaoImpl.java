package com.instinctools.reducerlink.dao.impl;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import com.instinctools.reducerlink.dao.UserDao;
import com.instinctools.reducerlink.model.User;

public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl(MongoEntityInformation<User, Long> metadata, MongoOperations mongoOperations) {
       super(metadata, mongoOperations);
    }
}
