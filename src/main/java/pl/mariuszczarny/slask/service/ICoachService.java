package pl.mariuszczarny.slask.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask.model.Coach;

/**
 *
 * @author Mariusz
 */
public interface ICoachService {
     void add(Coach coach);

     void delete(Coach coach);

     void update(Coach coach);

     Coach findById(Long id);
    
     List<Coach> findCoachAndPerson();

     List<Coach> findAllByCriteria();

}
