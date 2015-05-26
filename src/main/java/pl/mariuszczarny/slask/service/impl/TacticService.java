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
import pl.mariuszczarny.slask.dao.impl.TacticDao;
import pl.mariuszczarny.slask.model.Tactic;
import pl.mariuszczarny.slask.service.ITacticService;

/**
 *
 * @author Mariusz
 */
@Service("tacticService")
@Transactional(readOnly = true)
public class TacticService implements ITacticService{
    
    @Autowired
    TacticDao tacticDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Tactic tactic) {
        getTacticDao().add(tactic);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Tactic tactic) {
        getTacticDao().delete(tactic);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Tactic tactic) {
        getTacticDao().update(tactic);
    }

    @Override
    public Tactic findById(Long id) {
        return getTacticDao().findById(id);
    }

    @Override
    public List<Tactic> findAllByCriteria() {
        return getTacticDao().findAllByCriteria();
    }

    public TacticDao getTacticDao() {
        return tacticDao;
    }

    public void setTacticDao(TacticDao tacticDao) {
        this.tacticDao = tacticDao;
    }
    
}
