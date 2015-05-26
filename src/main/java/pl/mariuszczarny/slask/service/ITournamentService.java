package pl.mariuszczarny.slask.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask.model.Tournament;

/**
 *
 * @author Mariusz
 */
public interface ITournamentService {
     void add(Tournament tournament);

     void delete(Tournament tournament);

     void update(Tournament tournament);

     Tournament findById(Long id);

     List<Tournament> findAllByCriteria();
}
