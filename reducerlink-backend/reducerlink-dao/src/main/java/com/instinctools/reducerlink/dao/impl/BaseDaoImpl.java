package com.instinctools.reducerlink.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
//import org.springframework.data.repository.support.PageableExecutionUtils;
//import org.springframework.data.repository.support.PageableExecutionUtils.TotalSupplier;

public class BaseDaoImpl<T, ID extends Serializable> implements MongoRepository<T, ID> {
    @Autowired
    private MongoOperations mongoOperations;//final

    @Autowired
    private MongoEntityInformation<T, ID> entityInformation;//final

    public BaseDaoImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        this.entityInformation = metadata;
        this.mongoOperations = mongoOperations;
    }

    public <S extends T> S save(S entity) {
        if (entityInformation.isNew(entity)) {
            mongoOperations.insert(entity, entityInformation.getCollectionName());
        } else {
            mongoOperations.save(entity, entityInformation.getCollectionName());
        }

        return entity;
    }

    public <S extends T> List<S> save(Iterable<S> entities) {
        List<S> result = convertIterableToList(entities);
        boolean allNew = true;

        for (S entity : entities) {
            if (allNew && !entityInformation.isNew(entity)) {
                allNew = false;
            }
        }

        if (allNew) {
            mongoOperations.insertAll(result);
        } else {
            for (S entity : result) {
                save(entity);
            }
        }

        return result;
    }

    public T findOne(ID id) {
        return mongoOperations.findById(id, entityInformation.getJavaType(), entityInformation.getCollectionName());
    }

    public boolean exists(ID id) {
        return mongoOperations.exists(createCriteria(Criteria.where("id").is(id)), entityInformation.getJavaType(), entityInformation.getCollectionName());
    }

    public Query createCriteria(Criteria criteria) {
        return Query.query(new Criteria()).addCriteria(criteria);
    }
    
    public void delete(ID id) {
        //mongoOperations.remove(Query.query(Criteria.where("id").is(id)), entityInformation.getJavaType(), entityInformation.getCollectionName());
        mongoOperations.remove(createCriteria(Criteria.where("id").is(id)), entityInformation.getJavaType(), entityInformation.getCollectionName());
    }

    public void delete(T entity) {
        delete(entityInformation.getId(entity));
    }

    public void delete(Iterable<? extends T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }

    public void deleteAll() {
        mongoOperations.remove(new Query(), entityInformation.getCollectionName());
    }
    
    public long count() {
        return mongoOperations.getCollection(entityInformation.getCollectionName()).count();
    }
    
    public List<T> findAll() {
        return findAll(new Query());
    }

    public Iterable<T> findAll(Iterable<ID> ids) {

        Set<ID> parameters = new HashSet<ID>(tryDetermineRealSizeOrReturn(ids, 10));
        for (ID id : ids) {
            parameters.add(id);
        }

        return findAll(new Query(new Criteria(entityInformation.getIdAttribute()).in(parameters)));
    }

    public Page<T> findAll(final Pageable pageable) {

        Long count = count();
        List<T> list = findAll(new Query().with(pageable));

        return new PageImpl<T>(list, pageable, count);
    }

    public List<T> findAll(Sort sort) {
        return findAll(new Query().with(sort));
    }

    @Override
    public <S extends T> S insert(S entity) {
        mongoOperations.insert(entity, entityInformation.getCollectionName());
        return entity;
    }

    @Override
    public <S extends T> List<S> insert(Iterable<S> entities) {
        List<S> list = convertIterableToList(entities);

        if (list.isEmpty()) {
            return list;
        }

        mongoOperations.insertAll(list);
        return list;
    }

    public List<T> findAll(Query query) {
        if (query == null) {
            return Collections.emptyList();
        }

        return mongoOperations.find(query, entityInformation.getJavaType(), entityInformation.getCollectionName());
    }

    @SuppressWarnings("hiding")
    private <T> List<T> convertIterableToList(Iterable<T> entities) {

        if (entities instanceof List) {
            return (List<T>) entities;
        }

        int capacity = tryDetermineRealSizeOrReturn(entities, 10);

        if (capacity == 0 || entities == null) {
            return Collections.<T> emptyList();
        }

        List<T> list = new ArrayList<T>(capacity);
        for (T entity : entities) {
            list.add(entity);
        }

        return list;
    }

    private int tryDetermineRealSizeOrReturn(Iterable<?> iterable, int defaultSize) {
        return iterable == null ? 0 : (iterable instanceof Collection) ? ((Collection<?>) iterable).size() : defaultSize;
    }
}
