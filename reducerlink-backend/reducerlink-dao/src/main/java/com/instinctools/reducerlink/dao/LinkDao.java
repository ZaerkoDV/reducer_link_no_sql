package com.instinctools.reducerlink.dao;

import java.util.List;
import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.Link;

public interface LinkDao extends BaseDao<Link, ObjectId> {
  public List<Link> getListLinkByIdUser(ObjectId idUser);
  public long countLinkByUser(ObjectId idUser);
  public List<String> getListUniqueTag() ;
}
