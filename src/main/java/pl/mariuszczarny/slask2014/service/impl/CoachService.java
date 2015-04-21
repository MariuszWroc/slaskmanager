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
import pl.mariuszczarny.slask2014.dao.impl.CoachDao;
import pl.mariuszczarny.slask2014.model.Coach;
import pl.mariuszczarny.slask2014.service.ICoachService;

/**
 *
 * @author Mariusz
 */
@Service("coachService")
@Transactional(readOnly = true)
public class CoachService implements ICoachService{
    
    @Autowired
    CoachDao coachDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Coach coach) {
        getCoachDao().add(coach);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Coach coach) {
        getCoachDao().delete(coach);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Coach coach) {
        getCoachDao().update(coach);
    }

    @Override
    public Coach findById(Long id) {
        return getCoachDao().findById(id);
    }

    @Override
    public List<Coach> findCoachAndPerson() {
        return getCoachDao().findCoachAndPerson();
    }

    @Override
    public List<Coach> findAllByCriteria() {
        return getCoachDao().findAllByCriteria();
    }

    public CoachDao getCoachDao() {
        return coachDao;
    }

    public void setCoachDao(CoachDao coachDao) {
        this.coachDao = coachDao;
    }
    
}
