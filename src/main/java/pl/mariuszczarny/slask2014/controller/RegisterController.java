/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.dao.EmptyResultDataAccessException;
import pl.mariuszczarny.slask2014.controller.utils.StringConstants;

import pl.mariuszczarny.slask2014.model.User;
import pl.mariuszczarny.slask2014.service.IUserService;

/**
 *
 * @author Jacek
 */
@ManagedBean(name = "registercontroller")
@SessionScoped
public class RegisterController implements Serializable{

	private static final long serialVersionUID = 1L;

        private String name;
        private String lastName;
        private String login;
        private String password;
    
    @ManagedProperty(value = "#{userService}")
    private IUserService userService;
    
    public RegisterController()
    {
        name="";
        lastName="";
        login="";
        password="";
        
    }
    
    public String save()
    {
        User newUser = new User();
        try {
            newUser.setId(generateId());
//            newUser.setEnabled(1);
            newUser.setLogin(login);
            newUser.setSname(lastName);
            newUser.setName(name);
            newUser.setPassword(password);
            getUserService().add(newUser);
//            newUser = getUserService().findByLogin(newUser.getLogin());             
        }
        catch(EmptyResultDataAccessException e){
            System.out.println("Dodać primefaces message dla uzytkownik nie istnieje");
            return StringConstants.SAVE_ERROR.getValue() + " - " + newUser.toString();
        }
        System.out.println("test usera " + newUser.getName());
        
        return "/HomePage.xhtml";
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    
    private Long generateId() {
        return getUserService().count()+1L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
