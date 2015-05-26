/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.stereotype.Repository;
import pl.mariuszczarny.slask.dao.IPlayerDao;
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.model.Player;
 
/**
 *
 * @author Mariusz
 */
@Repository
public class PlayerDao extends GenericExtendedDao<Player> implements IPlayerDao {

    @Override
    public List<Player> findPlayerAndPerson() {
        Criteria criteria = getSession().createCriteria(Player.class);
        criteria.setFetchMode(Person.class.toString(), FetchMode.JOIN);
        List list = criteria.list();
        return list;
    }
}
