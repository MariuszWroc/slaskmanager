/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.stereotype.Repository;
import pl.mariuszczarny.slask2014.dao.IRefereeDao;
import pl.mariuszczarny.slask2014.model.Person;
import pl.mariuszczarny.slask2014.model.Referee;

/**
 *
 * @author Mariusz
 */
@Repository
public class RefereeDao extends GenericExtendedDao<Referee> implements IRefereeDao{
    
    @Override
    public List<Referee> findRefereeAndPerson() {
        Criteria criteria = getSession().createCriteria(Referee.class);
            criteria.setFetchMode(Person.class.toString(), FetchMode.JOIN);
            List list = criteria.list();
        return list;
    }
}
