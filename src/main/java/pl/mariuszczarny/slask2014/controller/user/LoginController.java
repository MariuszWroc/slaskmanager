/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.controller.user;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.mariuszczarny.slask2014.controller.MainMenuController;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController implements Serializable{

    @ManagedProperty(value = "#{mainMenuController}")
    MainMenuController mainMenuController;
    
    public String doLogin() throws IOException, ServletException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_check");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();
       
        return null;
    }

    public String doLogout() {
        FacesContext.getCurrentInstance()
            .getExternalContext().invalidateSession();
        SecurityContextHolder.clearContext();
        if(getMainMenuController().getUser()!=null){
            //adding primefaces message
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pomyślnie wylogowano", ""));
            getMainMenuController().setUser(null);
        }
        return "/HomePage.xhtml";
    }

    public MainMenuController getMainMenuController() {
        return mainMenuController;
    }

    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
}
