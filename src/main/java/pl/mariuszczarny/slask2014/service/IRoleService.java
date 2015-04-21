/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.service;

import java.util.List;
import pl.mariuszczarny.slask2014.model.Role;

/**
 *
 * @author Mariusz
 */
public interface IRoleService {
     void add(Role role);

     void delete(Role role);

     void update(Role role);

     Role findById(Long id);

     List<Role> findAllByCriteria();
}
