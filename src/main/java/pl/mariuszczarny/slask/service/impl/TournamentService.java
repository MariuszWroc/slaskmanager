/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszczarny.slask.dao.impl.TournamentDao;
import pl.mariuszczarny.slask.model.Tournament;
import pl.mariuszczarny.slask.service.ITournamentService;

/**
 *
 * @author Mariusz
 */
@Service("tournamentService")
@Transactional(readOnly = true)
public class TournamentService implements ITournamentService{
    
    @Autowired
    TournamentDao tournamentDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Tournament tournament) {
        getTournamentDao().add(tournament);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Tournament tournament) {
        getTournamentDao().delete(tournament);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Tournament tournament) {
        getTournamentDao().update(tournament);
    }

    @Override
    public Tournament findById(Long id) {
        return getTournamentDao().findById(id);
    }

    @Override
    public List<Tournament> findAllByCriteria() {
        return getTournamentDao().findAllByCriteria();
    }

    public TournamentDao getTournamentDao() {
        return tournamentDao;
    }

    public void setTournamentDao(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }
   
}
