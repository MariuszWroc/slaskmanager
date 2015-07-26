/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pl.mariuszczarny.slask.model.Club;
import pl.mariuszczarny.slask.model.Game;
import pl.mariuszczarny.slask.model.User;
import pl.mariuszczarny.slask.service.IGameService;
import pl.mariuszczarny.slask.service.IUserService;

/**
 *
 * @author Jacek
 */
@ManagedBean(name = "mainMenuController")
@SessionScoped
public class MainMenuController implements Serializable{
    
    @ManagedProperty(value = "#{gameService}")
    IGameService gameService;
    @ManagedProperty(value = "#{userService}")
    IUserService userService;
    
    private String login;
    private Club playersClub;
    private User user;
    private List<Game> saveGames;
    private Game activeGame;
    private boolean disabled;
    private boolean clubSellected;
   
    public MainMenuController ()
    {
        login="";
        playersClub = new Club();
        saveGames = new ArrayList<>();
        activeGame = null;
        disabled = true;
        clubSellected=true;
    }

    public Club getPlayersClub() {
        return playersClub;
    }

    public void setPlayersClub(Club playersClub) {
        this.playersClub = playersClub;
    }   

    public IGameService getGameService() {
        return gameService;
    }

    public void setGameService(IGameService gameService) {
        this.gameService = gameService;
    }

    public List<Game> getSaveGames() {
        user = getUserService().findByLogin(login);
        saveGames = getGameService().findAllByUser(user);
        return saveGames;
    }

    public void setSaveGames(List<Game> saveGames) {
        this.saveGames = saveGames;
    } 

    public User getUser() {
        return user;
    }
    
    public String create(){
        return "Usermain";
    }
    
    public String load(){
        if(activeGame!=null){
            playersClub = activeGame.getClubidClub();
            return "Usermain";
        }else{
            return null;
        }
    }
    
    public void delete(){
       if(activeGame!=null){
           saveGames.remove(activeGame);
        } 
    }
    
    public void backUp(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Data base was souccessfully exported to csv") );
    }
    
    public void select(){
        disabled=false;
    }
    
    public void unSelect(){
        disabled=true;
    }
    
    public void selectClub(){
        clubSellected=false;
    }
    
    public void unSelectClub(){
        clubSellected=true;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Game getActiveGame() {
        return activeGame;
    }

    public void setActiveGame(Game activeGame) {
        this.activeGame = activeGame;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isClubSellected() {
        return clubSellected;
    }

    public void setClubSellected(boolean clubSellected) {
        this.clubSellected = clubSellected;
    }
}
