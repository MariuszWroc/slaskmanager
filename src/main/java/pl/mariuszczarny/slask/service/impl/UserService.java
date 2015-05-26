/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszczarny.slask.dao.impl.UserDao;
import pl.mariuszczarny.slask.model.User;
import pl.mariuszczarny.slask.service.IUserService;

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
    public Long count(){
        return getUserDao().count();
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
