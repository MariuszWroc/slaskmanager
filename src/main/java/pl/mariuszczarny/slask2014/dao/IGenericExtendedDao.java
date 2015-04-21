/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Mariusz
 */
public interface IGenericExtendedDao<T> {
    List<T> findByQuery(String query);

    List<T> findAll();
    
    void flushSession();

    void clearSession();
            
    void refresh(T entity);

    void add(T entity) throws DataAccessException;
    
    void merge(T entity) throws DataAccessException;

    void delete(T entity) throws DataAccessException;

    void update(T entity) throws DataAccessException;
    
    void saveOrUpdate(T entity) throws DataAccessException;

    T findById(Long id) throws EmptyResultDataAccessException;

    List<T> findAllByCriteria() throws EmptyResultDataAccessException;
    
    Long count() throws EmptyResultDataAccessException; 
}
