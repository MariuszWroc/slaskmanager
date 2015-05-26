/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
http://wordgraphs.com/post/604/Generic-DAO-design-pattern-with-Java---Hibernate
 */
package pl.mariuszczarny.slask.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Mariusz
 */
public interface IGenericDao<T> {
     void add(T entity) throws DataAccessException;

     void delete(T entity) throws DataAccessException;

     void update(T entity) throws DataAccessException;

     T findById(Long id) throws EmptyResultDataAccessException;

     List<T> findAllByCriteria() throws EmptyResultDataAccessException;

}
