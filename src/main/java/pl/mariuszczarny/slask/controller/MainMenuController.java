/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
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
public class MainMenuController  implements Serializable{
    
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
    private boolean loadedGame;
    private String userName;
    private List<Game> joinGames;
    private Game gameToJoin;
    private User userToJoin;
    private boolean loadGames;
   
    public MainMenuController ()
    {
        loadGames = false;
        loadedGame = false;
        login="";
        playersClub = new Club();
        saveGames = new ArrayList<>();
        activeGame = null;
        disabled = true;
        clubSellected=true;
        userName="";
        gameToJoin = null;
        joinGames = new ArrayList<>();
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
        // TODO sprawdzic czy status usera nie jest false
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
        RequestContext.getCurrentInstance().closeDialog("selectClub");
        boolean status = true;
        if(loadedGame){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Fail",  "Nie można stworzyć gry proszę się najpierw wylogować"));
            return null;
        }else{
            return create(status);
        }
    }
    
    public String create(boolean status){
        activeGame = new Game();
        activeGame.setId(generateId());
//        activeGame.setClubidClub(playersClub);
        activeGame.setGameCode(11);
        activeGame.setGameName("lololololo123");
        activeGame.setUseridUser(user);
        activeGame.setUserStatus(status);
        gameService.add(activeGame);
        return "Usermain";
    }
    
    public void redirect(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Usermain.xhtml"); 
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void newGameHandle(){
        RequestContext.getCurrentInstance().openDialog("selectClub");
    }
    
    public String load(){
        if(activeGame!=null){
            playersClub = activeGame.getClubidClub();
            loadedGame=true;
            return "Usermain";
        }else{
            return null;
        }
    }
    
    public void delete(){
       if(activeGame!=null){
          gameService.delete(activeGame);
        } 
    }
    
    public void saveGame(){
        if(activeGame!=null){
            //TODO: należy ustawić aktualną datę i ją wyświetlić
            gameService.update(activeGame);
        }
    }
    
    public void openJoinDialog(){
        RequestContext.getCurrentInstance().openDialog("joinGameDialog");
    }
    
    public String joinGame(){
       RequestContext.getCurrentInstance().closeDialog("joinGameDialog");
       return create(false);
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLoadedGame() {
        return loadedGame;
    }

    public void setLoadedGame(boolean loadedGame) {
        this.loadedGame = loadedGame;
    }
    
     private Long generateId() {
        return gameService.count()+1L;
    }

    public List<Game> getJoinGames() {
        userToJoin = getUserService().findByLogin(userName);
        if(userToJoin!=null){
            joinGames = getGameService().findAllByUser(userToJoin);
        }
        return joinGames;
    }

    public void setJoinGames(List<Game> joinGames) {
        this.joinGames = joinGames;
    }

    public Game getGameToJoin() {
        return gameToJoin;
    }

    public void setGameToJoin(Game gameToJoin) {
        this.gameToJoin = gameToJoin;
    }
}
