/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import pl.mariuszczarny.slask.controller.utils.StringConstants;
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.service.IPersonService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "personController")
@SessionScoped
public class PersonController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	private IPersonService personService;
    private MessageController messageController;
    private List<Person> personList;
    private Person selectedPerson;
    private String name;
    private String surname;
    private Date birthDate;
    private String nation;
    private Long id;

    public PersonController() {
        id=0L;
        name="";
        surname="";
        birthDate= new Date();
        nation="";
        selectedPerson= new Person();
    }
    
    public String prepareEdit() {
        return "EditPerson";
    }
    
    public String prepareAdd()
    {
        return "AddPerson";
    }
    
    public void destroy() {
        getPersonService().delete(selectedPerson);
    }
    
    public String update()
    {
    	logger.info("selectedPerson " + selectedPerson);
        try {
             selectedPerson.setBirthDate(birthDate);
             selectedPerson.setName(name);
             selectedPerson.setNation(nation);
             selectedPerson.setSurname(surname);
            getPersonService().update(selectedPerson);
        } catch (DataAccessException e) {
        	logger.warn(e.getMessage(), e);
        }  
        return selectedPerson.toString();
    }
    
    public String save()
    {
    	logger.info("Start saving");
        Person person = new Person();
         try {
             person.setId((long)getPersonService().findAllByCriteria().size()+1);
             person.setBirthDate(birthDate);
             person.setName(name);
             person.setNation(nation);
             person.setSurname(surname);
            getPersonService().add(person);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
        	logger.warn(e.getMessage(), e);
        }   
        return ERROR + " - " + person.toString();
    }

    public IPersonService getPersonService() {
        return personService;
    }

    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    public List<Person> getPersonList() {
        getMessageController().getMessageList().add("pokaż listę osób");
        personList = new ArrayList<>();
        personList.addAll(getPersonService().findAllByCriteria());
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
