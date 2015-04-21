/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import pl.mariuszczarny.slask2014.model.Club;
import pl.mariuszczarny.slask2014.model.Game;
import pl.mariuszczarny.slask2014.model.User;
import pl.mariuszczarny.slask2014.service.IClubService;
import pl.mariuszczarny.slask2014.service.IGameService;
import pl.mariuszczarny.slask2014.service.IUserService;

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
   
    public MainMenuController ()
    {
        login="";
        playersClub = new Club();
        saveGames = new ArrayList<>();
        activeGame = null;
        disabled = true;
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
    
    public String load(){
        if(activeGame!=null){
            playersClub = activeGame.getClubidClub();
            return "Usermain";
        }else{
            return null;
        }
    }
    
    public void select(){
        disabled=false;
    }
    
    public void unSelect(){
        disabled=true;
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
}
