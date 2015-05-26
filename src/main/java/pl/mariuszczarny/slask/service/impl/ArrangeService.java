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
import pl.mariuszczarny.slask.dao.impl.ArrangeDao;
import pl.mariuszczarny.slask.model.Arrange;
import pl.mariuszczarny.slask.service.IArrangeService;

/**
 *
 * @author Mariusz
 */
@Service("arrangeService")
@Transactional(readOnly = true)
public class ArrangeService implements IArrangeService{
    
    @Autowired
    ArrangeDao arrangeDao;

    @Transactional(readOnly = false)
    @Override
    public void add(Arrange arrange) {
        getArrangeDao().add(arrange);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Arrange arrange) {
        getArrangeDao().delete(arrange);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Arrange arrange) {
        getArrangeDao().update(arrange);
    }

    @Override
    public Arrange findById(Long id) {
        return getArrangeDao().findById(id);
    }

    @Override
    public List<Arrange> findAllByCriteria() {
        return getArrangeDao().findAllByCriteria();
    }

    public ArrangeDao getArrangeDao() {
        return arrangeDao;
    }

    public void setArrangeDao(ArrangeDao arrangeDao) {
        this.arrangeDao = arrangeDao;
    }
    
}
