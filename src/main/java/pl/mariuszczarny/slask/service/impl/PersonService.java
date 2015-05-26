/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszczarny.slask.dao.impl.PersonDao;
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.service.IPersonService;

/**
 *
 * @author Mariusz
 */
@Service("personService")
@Transactional(readOnly = true)
public class PersonService implements IPersonService{
    
    @Autowired
    PersonDao personDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Person person) {
        getPersonDao().add(person);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Person person) {
        getPersonDao().delete(person);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Person person) {
        getPersonDao().update(person);
    }

    @Override
    public Person findById(Long id) {
        return getPersonDao().findById(id);
    }

    @Override
    public List<Person> findAllByCriteria() {
        return getPersonDao().findAllByCriteria();
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
    
}
