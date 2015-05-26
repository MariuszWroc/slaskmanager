package pl.mariuszczarny.slask.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask.model.Club;

/**
 *
 * @author Mariusz
 */
public interface IClubService {
    
     void add(Club club);

     void delete(Club club);

     void update(Club club);

     Club findById(Long id);
    
     List<Club> findAllByCriteria();
}
