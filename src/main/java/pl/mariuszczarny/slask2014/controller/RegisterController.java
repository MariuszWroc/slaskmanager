/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.EmptyResultDataAccessException;
import pl.mariuszczarny.slask2014.model.User;
import pl.mariuszczarny.slask2014.service.IUserService;

/**
 *
 * @author Jacek
 */
@ManagedBean(name = "registercontroller")
@SessionScoped
public class RegisterController implements Serializable{
    private User newUser;
    
    @ManagedProperty(value = "#{userService}")
    IUserService userService;
    
    public RegisterController()
    {
        newUser = new User();
    }
    
    public String save()
    {
        try{
            newUser.setId(4L);
            newUser.setEnabled(1);
            newUser.setLogin("stefan");
            newUser.setName("Kuba");
            newUser.setPassword("123");
            newUser.setSname("Stefanowski");
            getUserService().add(newUser);
//            newUser=(User) getUserService().findByLogin(newUser.getLogin());             
        }
        catch(EmptyResultDataAccessException e){
            System.out.println("Dodać primefaces message dla uzytkownik nie istnieje");
            return null;
        }
        
        return "/login.xhtml";
            
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
