package com.instinctools.reducerlink.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class BaseDaoImpl<T, ID extends Serializable> {

    @Autowired
    private MongoTemplate mongoTemplate;

    protected Class<T> domainClass;

    public BaseDaoImpl(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    public Query createCriteria(Criteria criteria) {
        return Query.query(new Criteria()).addCriteria(criteria);
    }

    public List<T> executeQuery(Query query) {
        return mongoTemplate.find(query, domainClass);
    }
    
    public List<T> getCollection(String collection, String field){
        return mongoTemplate.getCollection(collection).distinct(field);
    }
    
    public T findOne(ObjectId id) {
        return mongoTemplate.findOne(createCriteria(Criteria.where("id").is(id)), domainClass);
    }

    public T save(T object) {
        mongoTemplate.save(object);
        return object;
    }

    public List<T> findAll() {
        return mongoTemplate.findAll(domainClass);
    }

    public long count() {
        return mongoTemplate.count(new Query(), domainClass);
    }

    public long count(Query query) {
        return mongoTemplate.count(query, domainClass);
    }

    public void delete(ObjectId id) {
        mongoTemplate.remove(createCriteria(Criteria.where("id").is(id)), domainClass);
    }

    public void delete(T object) {
        mongoTemplate.remove(object);
    }
}
