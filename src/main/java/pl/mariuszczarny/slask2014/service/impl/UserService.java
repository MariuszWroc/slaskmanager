/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszczarny.slask2014.dao.impl.UserDao;
import pl.mariuszczarny.slask2014.model.User;
import pl.mariuszczarny.slask2014.service.IUserService;

/**
 *
 * @author Jacek
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserService implements IUserService{
    
    @Autowired
    UserDao userDao;

    @Override
    public User findByLogin(String login) {
        return getUserDao().findUserByLogin(login);
    }

    @Override
    @Transactional(readOnly = false)
    public void add(User entity) {
        getUserDao().add(entity);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    

}
