package com.instinctools.reducerlink.service;

import java.util.List;
import org.bson.types.ObjectId;
import com.instinctools.reducerlink.model.UserCorespondence;
import com.instinctools.reducerlink.service.support.ValidationResult;

public interface UserCorespondenceService {
    public List<UserCorespondence> getListUserCorespondenceByIdUser(ObjectId idUser);
    public ValidationResult<UserCorespondence> createUserCorespondence(UserCorespondence userCorespondnce);
    public ValidationResult<UserCorespondence> updateUserCorespondence(UserCorespondence userCorespondnce);
    public Boolean deleteUserCorespondence(ObjectId idUser);
}
