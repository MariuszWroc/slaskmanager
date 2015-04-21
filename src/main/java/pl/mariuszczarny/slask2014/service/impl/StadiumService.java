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
import pl.mariuszczarny.slask2014.dao.impl.StadiumDao;
import pl.mariuszczarny.slask2014.model.Club;
import pl.mariuszczarny.slask2014.model.Stadium;
import pl.mariuszczarny.slask2014.service.IStadiumService;

/**
 *
 * @author Mariusz
 */
@Service("stadiumService")
@Transactional(readOnly = true)
public class StadiumService implements IStadiumService{

    @Autowired
    StadiumDao stadiumDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Stadium stadium) {
        getStadiumDao().add(stadium);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Stadium stadium) {
        getStadiumDao().delete(stadium);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Stadium stadium) {
        getStadiumDao().update(stadium);
    }

    @Override
    public Stadium findById(Long id) {
        return getStadiumDao().findById(id);
    }

    @Override
    public List<Stadium> findAllByCriteria() {
        return getStadiumDao().findAllByCriteria();
    }

    public StadiumDao getStadiumDao() {
        return stadiumDao;
    }

    public void setStadiumDao(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
    }

    @Override
    public List<Stadium> findByClub(Club club) {
        return getStadiumDao().findByClub(club);
    }
    
}
