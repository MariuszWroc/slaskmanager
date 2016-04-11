/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pl.mariuszczarny.slask.model.Game;

/**
 *
 * @author Mariusz
 */
@Repository
public class GameDao extends GenericExtendedDao<Game>{

    @SuppressWarnings({ "unchecked" })
	public List<Game> findAllByUser(Long idUser) {
       String hql = "FROM Game G WHERE G.useridUser = " + idUser;
       Query query = getSession().createQuery(hql);
       List<Game> games = query.list();
       return games;
    }
    
}
