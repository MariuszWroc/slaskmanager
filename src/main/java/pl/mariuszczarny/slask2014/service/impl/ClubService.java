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
import pl.mariuszczarny.slask2014.dao.impl.ClubDao;
import pl.mariuszczarny.slask2014.model.Club;
import pl.mariuszczarny.slask2014.service.IClubService;

/**
 *
 * @author Mariusz
 */
@Service("clubService")
@Transactional(readOnly = true)
public class ClubService implements IClubService{
    
    @Autowired
    ClubDao clubDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Club club) {
        getClubDao().add(club);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Club club) {
        getClubDao().delete(club);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Club club) {
        getClubDao().update(club);
    }

    @Override
    public Club findById(Long id) {
        return getClubDao().findById(id);
    }

    @Override
    public List<Club> findAllByCriteria() {
        return getClubDao().findAllByCriteria();
    }

    public ClubDao getClubDao() {
        return clubDao;
    }

    public void setClubDao(ClubDao clubDao) {
        this.clubDao = clubDao;
    }
    
}
