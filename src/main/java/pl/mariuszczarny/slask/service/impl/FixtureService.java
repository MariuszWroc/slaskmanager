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
import pl.mariuszczarny.slask.dao.impl.FixtureDao;
import pl.mariuszczarny.slask.model.Fixture;
import pl.mariuszczarny.slask.service.IFixtureService;

/**
 *
 * @author Mariusz
 */
@Service("fixtureService")
@Transactional(readOnly = true)
public class FixtureService implements IFixtureService{
    
    @Autowired
    FixtureDao fixtureDao;

    @Override
    public void add(Fixture fixture) {
        getFixtureDao().add(fixture);
    }

    @Override
    public void delete(Fixture fixture) {
        getFixtureDao().delete(fixture);
    }

    @Override
    public void update(Fixture fixture) {
        getFixtureDao().update(fixture);
    }

    @Override
    public Fixture findById(Long id) {
        return getFixtureDao().findById(id);
    }

    @Override
    public List<Fixture> findAllByCriteria() {
        return getFixtureDao().findAllByCriteria();
    }

    public FixtureDao getFixtureDao() {
        return fixtureDao;
    }

    public void setFixtureDao(FixtureDao fixtureDao) {
        this.fixtureDao = fixtureDao;
    }
    
}
