package com.instinctools.reducerlink.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.instinctools.reducerlink.dao.UserSecurityDao;
import com.instinctools.reducerlink.model.User;
import com.instinctools.reducerlink.model.UserSecurity;

@Repository
public class UserSecurityDaoImpl extends BaseDaoImpl<UserSecurity, ObjectId> implements UserSecurityDao {
    public UserSecurityDaoImpl() {
        super(UserSecurity.class);
    }

    public User getUserByLoginPassword(String login, String password) {
        Query query = super.createCriteria(
            Criteria.where("login").is(login).andOperator(
            Criteria.where("password").is(password))
        );
        query.fields().include("user");

        return (User) super.executeQuery(query);
    }

    public String getEncodedPasswordByLogin(String login) {
        Query query = super.createCriteria(Criteria.where("login").is(login));
        query.fields().include("password");

        return super.executeQuery(query).toString();
    }

    public String getOldTokenByLogin(String login) {
        Query query = super.createCriteria(Criteria.where("login").is(login));
        query.fields().include("token");

        return super.executeQuery(query).toString();
    }

    @SuppressWarnings("")
    public String getUserRole(ObjectId idUser) {
        Query query = super.createCriteria(Criteria.where("id").in("user").is(idUser));
        query.fields().include("role");

        return super.executeQuery(query).toString();

//        Criteria criteria = createCriteria()
//                .createAlias("user", "u")
//                .add(Restrictions.eq("u.id", idUser))
//                .setProjection(Projections.property("role"));
//
//            return (String) criteria.uniqueResult();
    }

    public Boolean isLoginExist(String login) {
        return !super.executeQuery(createCriteria(
            Criteria.where("login").is(login)
        )).isEmpty();
    }

    public UserSecurity findUserSecurityByToken(String token) {
        return (UserSecurity) super.executeQuery(createCriteria(
            Criteria.where("token").is(token)
        ));
    }
}
