package com.instinctools.reducerlink.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import com.instinctools.reducerlink.dao.UserDao;
import com.instinctools.reducerlink.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, ObjectId> implements UserDao {
    private static final Map<String, String> MAP_ORDER_BY;
    private static final Map<String, String> MAP_STATUS;

    public UserDaoImpl() {
        super(User.class);
    }

    static {
        MAP_ORDER_BY = new HashMap<String, String>();

        MAP_ORDER_BY.put("status", "status");
        MAP_ORDER_BY.put("firstName", "firstName");
        MAP_ORDER_BY.put("lastName", "lastName");
        MAP_ORDER_BY.put("middleName", "middleName");
        MAP_ORDER_BY.put("birth", "birth");
    }

    static {
        MAP_STATUS = new HashMap<String, String>();

        MAP_STATUS.put("active", "active");
        MAP_STATUS.put("blocked", "blocked");
    }

    public List<User> getListUserByLastName(User inputUser, int pageNum, int pageSize) {
        return super.executeQuery(createCriteria(
            Criteria.where("lastName").is(inputUser.getLastName()))
            .skip((pageNum-1) * pageSize)
            .limit(pageSize)
        );
    }

    public long countTotalUser() {
        return super.count();
    }

    public List<User> getListUserWithStatus(User inputUser, String orderBy, boolean orderAsc, int pageNum, int pageSize) {
        Query query = createCriteria(
            Criteria.where("status").is(MAP_STATUS.get(inputUser.getStatus()))
        );

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

    public long countUserWithStatus(User inputUser) {
        return super.count(createCriteria(
            Criteria.where("status").is(MAP_STATUS.get(inputUser.getStatus())))
        );
    }
}
