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
import pl.mariuszczarny.slask2014.dao.impl.FormationDao;
import pl.mariuszczarny.slask2014.model.Formation;
import pl.mariuszczarny.slask2014.service.IFormationService;

/**
 *
 * @author Mariusz
 */
@Service("formationService")
@Transactional(readOnly = true)
public class FormationService implements IFormationService{
    
    @Autowired
    FormationDao formationDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Formation formation) {
        getFormationDao().add(formation);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Formation formation) {
        getFormationDao().delete(formation);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Formation formation) {
        getFormationDao().update(formation);
    }

    @Override
    public Formation findById(Long id) {
        return getFormationDao().findById(id);
    }

    @Override
    public List<Formation> findAllByCriteria() {
        return getFormationDao().findAllByCriteria();
    }

    public FormationDao getFormationDao() {
        return formationDao;
    }

    public void setFormationDao(FormationDao formationDao) {
        this.formationDao = formationDao;
    }
    
}
