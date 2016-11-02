package com.instinctools.reducerlink.dao.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class BaseDaoImpl <T, ID extends Serializable> {

    @Autowired
    private MongoOperations mongoOperations;

    protected Class<T> domainClass;

    public BaseDaoImpl(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    public <S extends T> S save(S entity) {
        mongoOperations.save(entity);
        return entity;
    }
}
