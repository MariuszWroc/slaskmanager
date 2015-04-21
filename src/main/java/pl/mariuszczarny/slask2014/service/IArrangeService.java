package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Arrange;

/**
 *
 * @author Mariusz
 */
public interface IArrangeService {
     void add(Arrange arrange);

     void delete(Arrange arrange);
    
     void update(Arrange arrange);

     Arrange findById(Long id);

     List<Arrange> findAllByCriteria();
}
