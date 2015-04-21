/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.dao;

import java.util.List;
import pl.mariuszczarny.slask2014.model.Staff;

/**
 *
 * @author Mariusz
 */
public interface IStaffDao extends IGenericDao<Staff>{
     List<Staff> findStaffAndPerson();
}
