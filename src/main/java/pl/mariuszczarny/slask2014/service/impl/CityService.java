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
import pl.mariuszczarny.slask2014.dao.impl.CityDao;
import pl.mariuszczarny.slask2014.model.City;
import pl.mariuszczarny.slask2014.service.ICityService;

/**
 *
 * @author Mariusz
 */
@Service("cityService")
@Transactional(readOnly = true)
public class CityService implements ICityService{

    @Autowired
    CityDao cityDao;

    @Transactional(readOnly = false)
    @Override
    public void add(City city) {
        getCityDao().add(city);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(City city) {
        getCityDao().delete(city);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(City city) {
        getCityDao().update(city);
    }

    @Override
    public City findById(Long id) {
        return getCityDao().findById(id);
    }

    @Override
    public List<City> findAllByCriteria() {
        return getCityDao().findAllByCriteria();
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public void setCityDao(CityDao CityDao) {
        this.cityDao = CityDao;
    }
}
