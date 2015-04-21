/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pl.mariuszczarny.slask2014.model.Game;
import pl.mariuszczarny.slask2014.model.User;

/**
 *
 * @author Mariusz
 */
@Repository
public class GameDao extends GenericExtendedDao<Game>{

    public List<Game> findAllByUser(User user) {
       String hql = "FROM Game G WHERE G.useridUser = 1";// + user.getId();
       Query query = getSession().createQuery(hql);
       List games = query.list();
       return games;
    }
    
}
