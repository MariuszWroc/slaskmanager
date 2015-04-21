package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Club;
import pl.mariuszczarny.slask2014.model.Staff;

/**
 *
 * @author Mariusz
 */
public interface IStaffService {
     void add(Staff staff);

     void delete(Staff staff);

     void update(Staff staff);

     Staff findById(Long id);

     List<Staff> findAllByCriteria();
    
     List<Staff> findStaffByClub(Club club);
     
     List<Staff> findStaffAndPerson();
}
