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
import pl.mariuszczarny.slask.model.Contract;

/**
 *
 * @author Mariusz
 */
@Repository
public class ContractDao extends GenericExtendedDao<Contract> {

    public List<Contract> findByClub(Long id) {
       String hql = "FROM Contract C WHERE C.clubidClub =" + id;
       Query query = getSession().createQuery(hql);
       List Contracts = query.list();
       return Contracts;
    }
}
