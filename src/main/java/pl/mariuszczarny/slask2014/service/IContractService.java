package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import pl.mariuszczarny.slask2014.model.Club;
import pl.mariuszczarny.slask2014.model.Contract;

/**
 *
 * @author Mariusz
 */
public interface IContractService {
     void add(Contract contract);

     void delete(Contract contract);

     void update(Contract contract);

     Contract findById(Long id);
     
     List<Contract> findByClub(Club club);

     List<Contract> findAllByCriteria();
}
