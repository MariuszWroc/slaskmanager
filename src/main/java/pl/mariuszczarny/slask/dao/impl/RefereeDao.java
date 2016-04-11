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
import pl.mariuszczarny.slask.dao.IRefereeDao;
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.model.Referee;

/**
 *
 * @author Mariusz
 */
@Repository
public class RefereeDao extends GenericExtendedDao<Referee> implements IRefereeDao{
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Referee> findRefereeAndPerson() {
        Criteria criteria = getSession().createCriteria(Referee.class);
        criteria.setFetchMode(Person.class.toString(), FetchMode.JOIN);
        return criteria.list();
    }
}
