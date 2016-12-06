package com.instinctools.reducerlink.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public interface BaseDao<T, ID extends Serializable> {
    public <S extends T> S save(S entity);
    public <S extends T> List<S> save(Iterable<S> entities);
    public T findOne(ID id);
    public boolean exists(ID id);
    public Query createCriteria(Criteria criteria);
    public void delete(ID id);
    public void delete(T entity);
    public void delete(Iterable<? extends T> entities);
    public void deleteAll();
    public long count();
    public List<T> findAll();
    public Iterable<T> findAll(Iterable<ID> ids);
    public Page<T> findAll(final Pageable pageable);
    public List<T> findAll(Sort sort);
    public <S extends T> S insert(S entity);
    public <S extends T> List<S> insert(Iterable<S> entities);
    public List<T> findAll(Query query);
}
