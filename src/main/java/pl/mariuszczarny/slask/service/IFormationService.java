package pl.mariuszczarny.slask.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask.model.Formation;

/**
 *
 * @author Mariusz
 */
public interface IFormationService {
     void add(Formation formation);

     void delete(Formation formation);

     void update(Formation formation);

     Formation findById(Long id);

     List<Formation> findAllByCriteria();
}
