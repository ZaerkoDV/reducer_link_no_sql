package com.instinctools.reducerlink.dao;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public interface BaseDao<T, ID extends Serializable> {
   public Query createCriteria(Criteria criteria);
   public T findOne(ObjectId id);
   public T save(T object);
   public List<T> findAll();
   public void delete(ObjectId id);
   public void delete(T object);
}
