package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Fixture;

/**
 *
 * @author Mariusz
 */
public interface IFixtureService {
     void add(Fixture fixture);

     void delete(Fixture fixture);

     void update(Fixture fixture);

     Fixture findById(Long id);

     List<Fixture> findAllByCriteria();
}
