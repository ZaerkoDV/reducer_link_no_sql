package com.instinctools.reducerlink.dao;

import java.util.List;
import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.User;
import com.instinctools.reducerlink.model.UserCorespondence;

public interface UserCorespondenceDao extends BaseDao<UserCorespondence, Long> {
    public User getUserByEmail(String email);
    public List<UserCorespondence> getListUserCorespondencesByIdUser(ObjectId idUser);
    public List<String> getListEmailByIdUser(ObjectId idUser);
    public Boolean isEmailExist(String email);
    public Boolean isSkypeExist(String skype);
    public Boolean isPhoneExist(String phone);
    public Boolean isUserIpAddress(ObjectId idUser, String ipAddress);
}
