/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import pl.mariuszczarny.slask.dao.IGenericDao;

/**
 *
 * @author Mariusz
 */
public abstract class GenericDao<T> implements IGenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private Class<T> type;

    protected Class<T> getType() {
        return this.type;
    }

    protected String getClassName() {
        return type.getName();
    }

    @SuppressWarnings("unchecked")
    public GenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void add(T entity) {
        getSession().save(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public T findById(Long id) throws DataAccessException {
        return (T) getSession().byId(type);
//                (T) getHibernateTemplate().get(type, id);
//        T found = type.cast(getHibernateTemplate().get(type, id));
//        if (found == null) {
//            throw new EmptyResultDataAccessException(1);
//        }
//        return found;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllByCriteria() {
        Criteria criteria = getSession().createCriteria(type);
        return criteria.list();
    }

}
