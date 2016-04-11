/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import pl.mariuszczarny.slask.model.Club;
import pl.mariuszczarny.slask.model.Stadium;

/**
 *
 * @author Mariusz
 */
@Repository
public class StadiumDao extends GenericExtendedDao<Stadium> {

    @SuppressWarnings("unchecked")
	public List<Stadium> findByClub(Club club) {
        String hql = "FROM Stadium C WHERE C.clubidClub =" + club.getId();
       Query query = getSession().createQuery(hql);
       return query.list();
    }
}
