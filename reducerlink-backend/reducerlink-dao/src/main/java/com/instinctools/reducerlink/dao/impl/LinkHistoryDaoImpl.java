package com.instinctools.reducerlink.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
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

        MAP_ORDER_BY.put("tag", "l.tag");
        MAP_ORDER_BY.put("comment", "l.comment");
        MAP_ORDER_BY.put("id", "l.id");
        MAP_ORDER_BY.put("createdAtTimestamp", "createdAtTimestamp");
    }

    public Long getNumberLinkVisits(ObjectId idLink) {
        return null;
    }

    public LinkHistory getLinkHistoryByIdLink(ObjectId idLink){
        return null;
    }

    public List<LinkHistory> getListAllLink(String orderBy, boolean orderAsc, int pageNum, int pageSize) {
        return null;
    }

    public List<Link> getListLinkBetweenDate(long startTimestamp, long endTimestamp) {
        return null;
    }

    public List<LinkHistory> getListLinkByIdUser(ObjectId idUser, String orderBy, boolean orderAsc, int pageNum, int pageSize) {
        return null;
    }

    public List<LinkHistory> getListLinkByTag(String tag, String orderBy, boolean orderAsc) {
        return null;
    }
}
