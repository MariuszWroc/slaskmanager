package pl.mariuszczarny.slask.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask.model.City;

/**
 *
 * @author Mariusz
 */

public interface ICityService {
     void add(City city);

     void delete(City city);

     void update(City city);

     City findById(Long id);

     List<City> findAllByCriteria();
}
