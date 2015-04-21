package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Referee;

/**
 *
 * @author Mariusz
 */
public interface IRefereeService {
     void add(Referee referee);

     void delete(Referee referee);

     void update(Referee referee);

     Referee findById(Long id);

     List<Referee> findAllByCriteria();
    
     List<Referee> findRefereeAndPerson();
}
