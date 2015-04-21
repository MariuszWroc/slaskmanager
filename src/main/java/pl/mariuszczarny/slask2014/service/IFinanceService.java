package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Finance;

/**
 *
 * @author Mariusz
 */
public interface IFinanceService {
     void add(Finance finance);

     void delete(Finance finance);

     void update(Finance finance);

     Finance findById(Long id);

     List<Finance> findAllByCriteria();
}
