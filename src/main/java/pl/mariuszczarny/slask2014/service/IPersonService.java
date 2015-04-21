package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Person;

/**
 *
 * @author Mariusz
 */
public interface IPersonService {
     void add(Person person);

     void delete(Person person);

     void update(Person person);
    
     Person findById(Long id);

     List<Person> findAllByCriteria();
}
