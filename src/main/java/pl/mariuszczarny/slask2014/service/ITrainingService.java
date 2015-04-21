package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Training;

/**
 *
 * @author Mariusz
 */
public interface ITrainingService {
     void add(Training training);

     void delete(Training training);
    
     void update(Training training);

     Training findById(Long id);
    
     List<Training> findAllByCriteria();
}
