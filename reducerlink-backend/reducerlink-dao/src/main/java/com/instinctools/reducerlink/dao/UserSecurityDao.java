package com.instinctools.reducerlink.dao;

import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.User;
import com.instinctools.reducerlink.model.UserSecurity;

public interface UserSecurityDao extends BaseDao<UserSecurity, ObjectId> {
    public User getUserByLoginPassword(String login, String password);
    public String getEncodedPasswordByLogin(String login);
    public String getOldTokenByLogin(String login);
    public String getUserRole(ObjectId idUser);
    public Boolean isLoginExist(String login);
    public UserSecurity findUserSecurityByToken(String token);
}
