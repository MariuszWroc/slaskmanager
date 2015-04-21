/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.dao;

import pl.mariuszczarny.slask2014.model.User;

/**
 *
 * @author Jacek
 */
public interface IUserDao extends IGenericDao<User>{
    User findUserByLogin(String login);
}
