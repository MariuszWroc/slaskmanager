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
import pl.mariuszczarny.slask.dao.impl.PositionDao;
import pl.mariuszczarny.slask.model.Position;
import pl.mariuszczarny.slask.service.IPositionService;

/**
 *
 * @author Mariusz
 */
@Service("positionService")
@Transactional(readOnly = true)
public class PositionService implements IPositionService{

    @Autowired
    PositionDao positionDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Position position) {
        getPositionDao().add(position);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Position position) {
        getPositionDao().delete(position);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Position position) {
        getPositionDao().update(position);
    }

    @Override
    public Position findById(Long id) {
        return getPositionDao().findById(id);
    }

    @Override
    public List<Position> findAllByCriteria() {
        return getPositionDao().findAllByCriteria();
    }

    public PositionDao getPositionDao() {
        return positionDao;
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
    
}
