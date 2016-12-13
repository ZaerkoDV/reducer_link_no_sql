package com.instinctools.reducerlink.dao.impl;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.instinctools.reducerlink.dao.LinkDao;
import com.instinctools.reducerlink.model.Link;

@Repository
public class LinkDaoImpl extends BaseDaoImpl<Link, ObjectId> implements LinkDao {
    public LinkDaoImpl() {
        super(Link.class);
    }
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Link> getListLinkByIdUser(ObjectId idUser) {
         Query query = super.createCriteria(Criteria.where("user.id").is(idUser));
         return super.executeQuery(query);
    }
    
    public long countLinkByUser(ObjectId idUser) {
        return super.count(createCriteria(
            Criteria.where("user.id").is(idUser)
        ));
    }

    @SuppressWarnings("unchecked")
    public List<String> getListUniqueTag() {
        return mongoTemplate.getCollection("link").distinct("tag");
    }
}