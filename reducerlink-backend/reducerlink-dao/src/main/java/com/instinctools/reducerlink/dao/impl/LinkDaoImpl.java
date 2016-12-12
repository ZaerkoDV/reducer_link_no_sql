package com.instinctools.reducerlink.dao.impl;

import java.util.List;
import org.bson.types.ObjectId;
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

    @SuppressWarnings("")
    public List<Link> getListLinkByIdUser(ObjectId idUser) {
         Query query = super.createCriteria(Criteria.where("id").in("user").is(idUser));
         return super.executeQuery(query);
    }
    
    @SuppressWarnings("")
    public long countLinkByUser(ObjectId idUser) {
        return super.count(createCriteria(
            Criteria.where("id").in("user").is(idUser)
        ));
    }

    public List<String> getListUniqueTag() {
        //Query query = super.
        //query.fields().include("tag");
        //return super.executeQuery(query);

//       public List<String> getListUniqueTag() {
//           Criteria criteria = createCriteria()
//           .setProjection(Projections.distinct(Projections.property("tag")));
//
//           return criteria.list();
//        }
         return null;
    }
}