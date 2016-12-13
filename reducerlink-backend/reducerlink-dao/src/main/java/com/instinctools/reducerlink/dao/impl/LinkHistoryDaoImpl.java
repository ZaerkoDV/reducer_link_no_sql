package com.instinctools.reducerlink.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.instinctools.reducerlink.dao.LinkHistoryDao;
import com.instinctools.reducerlink.model.Link;
import com.instinctools.reducerlink.model.LinkHistory;

@Repository
public class LinkHistoryDaoImpl extends BaseDaoImpl<LinkHistory, ObjectId> implements LinkHistoryDao {
    private static final Map<String, String> MAP_ORDER_BY;

    public LinkHistoryDaoImpl() {
        super(LinkHistory.class);
    }

    static {
        MAP_ORDER_BY = new HashMap<String, String>();
        MAP_ORDER_BY.put("id", "link.id");
        MAP_ORDER_BY.put("createdAtTimestamp", "createdAtTimestamp");
    }

    public Long getNumberLinkVisits(ObjectId idLink) {
        Query query = super.createCriteria(Criteria.where("link.id").is(idLink));
        query.fields().include("sumClick");

        return super.findOne(query).getSumClick();
    }

    public LinkHistory getLinkHistoryByIdLink(ObjectId idLink){
        Query query = super.createCriteria(Criteria.where("link.id").is(idLink));
        return super.findOne(query);
    }

    public List<LinkHistory> getListAllLink(String orderBy, boolean orderAsc, int pageNum, int pageSize) {
        Query query;

        if (orderAsc) {
             query = super.createQuery().with(new Sort(new Order(Direction.ASC, MAP_ORDER_BY.get(orderBy))));
        } else {
             query = super.createQuery().with(new Sort(new Order(Direction.DESC, MAP_ORDER_BY.get(orderBy))));
        }

        return super.executeQuery(query
            .skip((pageNum-1) * pageSize)
            .limit(pageSize)
        );
    }

    public List<Link> getListLinkBetweenDate(long startTimestamp, long endTimestamp) {
        Query query  = createCriteria(
            Criteria.where("createdAtTimestamp").gte(startTimestamp).andOperator(
            Criteria.where("createdAtTimestamp").lt(endTimestamp))
        );
        query.fields().include("link");

        List<LinkHistory> listLinkHistory = super.executeQuery(query);
        List<Link> listLink = new ArrayList<>();

        if (!listLinkHistory.isEmpty()) {
            for (LinkHistory linkHistory : listLinkHistory) {
                listLink.add(linkHistory.getLink());
            }
        }else {
            listLink = Collections.emptyList();
        }

        return listLink;
    }

    @SuppressWarnings("")
    public List<LinkHistory> getListLinkByIdUser(ObjectId idUser, String orderBy, boolean orderAsc, int pageNum, int pageSize) {
        Query query = createCriteria(Criteria.where("link.user.id").is(idUser));
        
        if (orderAsc) {
             query.with(new Sort(new Order(Direction.ASC, MAP_ORDER_BY.get(orderBy))));
        } else {
             query.with(new Sort(new Order(Direction.DESC, MAP_ORDER_BY.get(orderBy))));
        }

        return super.executeQuery(query
            .skip((pageNum-1) * pageSize)
            .limit(pageSize)
        );
    }
    @SuppressWarnings("")
    public List<LinkHistory> getListLinkByTag(String tag, String orderBy, boolean orderAsc) {
       Query query = createCriteria(Criteria.where("link.tag").is(tag));

       if (orderAsc) {
            query.with(new Sort(new Order(Direction.ASC, MAP_ORDER_BY.get(orderBy))));
       } else {
            query.with(new Sort(new Order(Direction.DESC, MAP_ORDER_BY.get(orderBy))));
       }

       return super.executeQuery(query);
    }
}
