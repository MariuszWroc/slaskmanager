/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszczarny.slask2014.dao.impl.RefereeDao;
import pl.mariuszczarny.slask2014.model.Referee;
import pl.mariuszczarny.slask2014.service.IRefereeService;

/**
 *
 * @author Mariusz
 */
@Service("refereeService")
@Transactional(readOnly = true)
public class RefereeService implements IRefereeService{

    @Autowired
    RefereeDao refereeDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Referee referee) {
        getRefereeDao().add(referee);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Referee referee) {
        getRefereeDao().delete(referee);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Referee referee) {
        getRefereeDao().update(referee);
    }

    @Override
    public Referee findById(Long id) {
        return getRefereeDao().findById(id);
    }

    @Override
    public List<Referee> findAllByCriteria() {
        return getRefereeDao().findAllByCriteria();
    }

    @Override
    public List<Referee> findRefereeAndPerson() {
        return getRefereeDao().findRefereeAndPerson();
    }

    public RefereeDao getRefereeDao() {
        return refereeDao;
    }

    public void setRefereeDao(RefereeDao refereeDao) {
        this.refereeDao = refereeDao;
    }
    
}
