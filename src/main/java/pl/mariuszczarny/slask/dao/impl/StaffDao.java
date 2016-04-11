/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import pl.mariuszczarny.slask.dao.IStaffDao;
import pl.mariuszczarny.slask.model.Club;
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.model.Staff;

/**
 *
 * @author Mariusz
 */
@Repository
public class StaffDao extends GenericExtendedDao<Staff> implements IStaffDao {

    @SuppressWarnings("unchecked")
	@Override
    public List<Staff> findStaffAndPerson() {
        Criteria criteria = getSession().createCriteria(Staff.class);
        criteria.setFetchMode(Person.class.toString(), FetchMode.JOIN);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
	public List<Staff> findStaffByClub(Club club) {
       String hql = "FROM Staff S WHERE S.clubidClub =" + club.getId();
       Query query = getSession().createQuery(hql);
       return query.list();
    }
}
