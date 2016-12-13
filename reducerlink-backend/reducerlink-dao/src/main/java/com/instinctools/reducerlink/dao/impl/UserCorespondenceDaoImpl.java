package com.instinctools.reducerlink.dao.impl;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.instinctools.reducerlink.dao.UserCorespondenceDao;
import com.instinctools.reducerlink.model.User;
import com.instinctools.reducerlink.model.UserCorespondence;

@Repository
public class UserCorespondenceDaoImpl extends BaseDaoImpl<UserCorespondence, ObjectId> implements UserCorespondenceDao {
    public UserCorespondenceDaoImpl() {
        super(UserCorespondence.class);
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public List<UserCorespondence> getListUserCorespondencesByIdUser(ObjectId idUser) {
        Query query = super.createCriteria(Criteria.where("user.id").is(idUser));
        query.with(new Sort(new Order(Direction.ASC, "id")));

        return super.executeQuery(query);
    }

    public Boolean isEmailExist(String email) {
        return !super.executeQuery(createCriteria(
            Criteria.where("email").is(email)
        )).isEmpty();
    }

    public Boolean isSkypeExist(String skype) {
        return !super.executeQuery(createCriteria(
            Criteria.where("skype").is(skype)
        )).isEmpty();
    }

    public Boolean isPhoneExist(String phone) {
        return !super.executeQuery(createCriteria(
            Criteria.where("phone").is(phone)
        )).isEmpty();
    }

    public Boolean isUserIpAddress(ObjectId idUser, String ipAddress) {
        return super.executeQuery(createCriteria(
            Criteria.where("ipAddress").is(ipAddress).and("user.id").is(idUser))
        ).isEmpty();
    }
}