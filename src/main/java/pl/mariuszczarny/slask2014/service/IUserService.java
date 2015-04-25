/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.service;

import pl.mariuszczarny.slask2014.model.User;

/**
 *
 * @author Jacek
 */
public interface IUserService {
    User findByLogin(String login);
    public Long count();
    void add(User entity);
}
