package com.instinctools.reducerlink.dao;

import java.util.List;
import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.Link;
import com.instinctools.reducerlink.model.LinkHistory;

public interface LinkHistoryDao extends BaseDao<LinkHistory, ObjectId> {
    public Long getNumberLinkVisits(ObjectId idLink);
    public LinkHistory getLinkHistoryByIdLink(ObjectId idLink);
    public List<LinkHistory> getListAllLink(String orderBy, boolean orderAsc, int pageNum, int pageSize);
    public List<Link> getListLinkBetweenDate(long startTimestamp, long endTimestamp);
    public List<LinkHistory> getListLinkByIdUser(ObjectId idUser, String orderBy, boolean orderAsc, int pageNum, int pageSize);
    public List<LinkHistory> getListLinkByTag(String tag, String orderBy, boolean orderAsc);
}
