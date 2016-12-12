package com.instinctools.reducerlink.dao;

import java.util.List;
import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.User;

public interface UserDao extends BaseDao<User, ObjectId> {
    public List<User> getListUserByLastName(User inputUser, int pageNum, int pageSize);
    public long countTotalUser();
    public List<User> getListUserWithStatus(User inputUser, String orderBy, boolean orderAsc, int pageNum, int pageSize);
    public long countUserWithStatus(User inputUser);
}
