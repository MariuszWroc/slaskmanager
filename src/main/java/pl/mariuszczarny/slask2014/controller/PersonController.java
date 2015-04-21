/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;
import pl.mariuszczarny.slask2014.model.Person;
import pl.mariuszczarny.slask2014.service.IPersonService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "personController")
@SessionScoped
public class PersonController implements Serializable {

    @ManagedProperty(value = "#{personService}")
    IPersonService personService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";

    List<Person> personList;
    Person selectedPerson;
    String name;
    String surname;
    Date birthDate;
    String nation;
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
        System.out.println(selectedPerson);
        try {
             selectedPerson.setBirthDate(birthDate);
             selectedPerson.setName(name);
             selectedPerson.setNation(nation);
             selectedPerson.setSurname(surname);
            getPersonService().update(selectedPerson);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedPerson.toString();
    }
    
    public String save()
    {
        System.out.println("Start saving");
        Person person = new Person();
         try {
             person.setId((long)getPersonService().findAllByCriteria().size()+1);
             person.setBirthDate(birthDate);
             person.setName(name);
             person.setNation(nation);
             person.setSurname(surname);
            getPersonService().add(person);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
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
        personList = new ArrayList<Person>();
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
