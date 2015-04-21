/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import pl.mariuszczarny.slask2014.dao.IStaffDao;
import pl.mariuszczarny.slask2014.model.Club;
import pl.mariuszczarny.slask2014.model.Person;
import pl.mariuszczarny.slask2014.model.Staff;

/**
 *
 * @author Mariusz
 */
@Repository
public class StaffDao extends GenericExtendedDao<Staff> implements IStaffDao {

    @Override
    public List<Staff> findStaffAndPerson() {
        Criteria criteria = getSession().createCriteria(Staff.class);
        criteria.setFetchMode(Person.class.toString(), FetchMode.JOIN);
        List list = criteria.list();
        return list;
    }

    public List findStaffByClub(Club club) {
        String hql = "FROM Staff S WHERE S.clubidClub =" + club.getId();
       Query query = getSession().createQuery(hql);
       List staff = query.list();
       return staff;
    }
}
