package com.instinctools.reducerlink.service;

import java.util.List;
import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.Link;
import com.instinctools.reducerlink.model.User;
import com.instinctools.reducerlink.model.UserSecurity;
import com.instinctools.reducerlink.service.support.PagedResult;
import com.instinctools.reducerlink.service.support.ValidationResult;

public interface UserService {
    public User getUserById(ObjectId idUser);
    public User getUserByToken(String token);
    public ValidationResult<UserSecurity> signup(UserSecurity userSecurity);
    public ValidationResult<User> update(User inputUser);
    public List<Link> deleteUser(ObjectId idUser);
    public ValidationResult<String> login(String login, String password);
    public ValidationResult<Boolean> logout(String token);
    public PagedResult<User> getListUserByLastName(User inputUser, int pageNum, int pageSize);
    public PagedResult<User> getListUserWithStatus(User inputUser, String orderBy, boolean orderAsc, int pageNum, int pageSize);
}
