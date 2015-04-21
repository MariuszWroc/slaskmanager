/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import pl.mariuszczarny.slask2014.dao.IUserDao;
import pl.mariuszczarny.slask2014.model.User;

/**
 *
 * @author Jacek
 */
@Repository
public class UserDao extends GenericExtendedDao<User> implements IUserDao{

    @Override
    public User findUserByLogin(String login) {
        Session session = getSession();
        List list = session
                .createQuery("From User U WHERE U.login= :login")
                .setParameter("login", login).list();
        if(list.isEmpty())
            return null;
        return (User) list.get(0);
    }
    
}
