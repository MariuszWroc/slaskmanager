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
import pl.mariuszczarny.slask.dao.ICoachDao;
import pl.mariuszczarny.slask.model.Coach;
import pl.mariuszczarny.slask.model.Person;

/**
 *
 * @author Mariusz
 */
@Repository
public class CoachDao extends GenericDao<Coach> implements ICoachDao{
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Coach> findCoachAndPerson() {
        Criteria criteria = getSession().createCriteria(Coach.class);
            criteria.setFetchMode(Person.class.toString(), FetchMode.JOIN);
        return criteria.list();
    }
}
