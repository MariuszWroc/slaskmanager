package pl.mariuszczarny.slask.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask.model.Club;
import pl.mariuszczarny.slask.model.Stadium;

/**
 *
 * @author Mariusz
 */
public interface IStadiumService {
     void add(Stadium stadium);

     void delete(Stadium stadium);

     void update(Stadium stadium);

     Stadium findById(Long id);
     
     List<Stadium> findByClub(Club club);

     List<Stadium> findAllByCriteria();
}
