package com.instinctools.reducerlink.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.instinctools.reducerlink.dao.UserDao;
import com.instinctools.reducerlink.dao.UserPhotoDao;
import com.instinctools.reducerlink.model.User;
import com.instinctools.reducerlink.model.UserPhoto;
import com.instinctools.reducerlink.service.UserPhotoService;
import com.instinctools.reducerlink.service.base.AuthorizedService;

@Service
public class UserPhotoServiceImpl extends AuthorizedService implements UserPhotoService {
    @Autowired
    private UserPhotoDao userPhotoDao;

    @Autowired
    private UserDao userDao;

    public BufferedImage getPhotoById(ObjectId idPhoto) {
        UserPhoto userPhoto = ensureFound(userPhotoDao.findOne(idPhoto));

        try (ByteArrayInputStream bais = new ByteArrayInputStream(userPhoto.getPhotoData())) {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getUserPhotoByIdUser(ObjectId idUser) {
        UserPhoto userPhoto = ensureFound(userPhotoDao.getUserPhotoByIdUser(idUser));

        try (ByteArrayInputStream bais = new ByteArrayInputStream(userPhoto.getPhotoData())) {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectId getIdUserPhotoByIdUser(ObjectId idUser) {
        return userPhotoDao.getIdUserPhotoByIdUser(idUser);
    }

    public UserPhoto saveUserPhoto(ObjectId idUser, long currentTimestamp, byte[] imageFile) {
        User user = ensureFound(userDao.findOne(idUser));

        return userPhotoDao.save((new UserPhoto())
            .setUser(user)
            .setCreatedAtTimestamp(currentTimestamp)
            .setPhotoData(imageFile)
        );
    }

    public Boolean deleteUserPhoto(ObjectId idPhoto) {
        UserPhoto userPhoto = ensureFound(userPhotoDao.findOne(idPhoto));
        userPhotoDao.delete(userPhoto);

        return true;
    }
}
