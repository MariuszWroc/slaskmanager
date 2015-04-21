package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Tactic;

/**
 *
 * @author Mariusz
 */
public interface ITacticService {
     void add(Tactic tactic);

     void delete(Tactic tactic);

     void update(Tactic tactic);

     Tactic findById(Long id);

     List<Tactic> findAllByCriteria();
}
