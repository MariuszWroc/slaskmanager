/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;
import pl.mariuszczarny.slask.controller.utils.StringConstants;
import pl.mariuszczarny.slask.model.Stadium;
import pl.mariuszczarny.slask.service.IStadiumService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "stadiumController")
@SessionScoped
public class StadiumController implements Serializable {
    @ManagedProperty(value = "#{stadiumService}")
    IStadiumService stadiumService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;
    @ManagedProperty(value = "#{mainMenuController}")
    MainMenuController menuController;
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";
    
    private Long idStadium;

    public Long getIdStadium() {
        return idStadium;
    }

    public void setIdStadium(Long idStadium) {
        this.idStadium = idStadium;
    }
    private List<Stadium> stadiumList;
    private List<Stadium> leagueStadiumList;
    private Stadium selectedStadium;
    private String stadiumName;
    private Integer yearBuild;
    private Integer sitsNumber;
    private Integer modernity;
    private Integer fieldWidth;
    private Integer fieldHeight;
    private Long id;


    public StadiumController() {
        id=0L;
        stadiumName="";
        yearBuild=1900;
        sitsNumber=0;
        modernity=0;
        fieldWidth=0;
        fieldHeight=0;
        selectedStadium= new Stadium();
    }
    
    public String prepareEdit() {
        return "EditStadium";
    }
    
    public String prepareAdd()
    {
        return "AddStadium";
    }
    
    public void destroy() {
        getStadiumService().delete(selectedStadium);
    }
    
    public String update()
    {
        System.out.println(selectedStadium);
        try {
            selectedStadium.setId((long)getStadiumService().findAllByCriteria().size()+1);
             selectedStadium.setFieldHeight(fieldHeight);
             selectedStadium.setFieldWidth(fieldWidth);
             selectedStadium.setModernity(modernity);
             selectedStadium.setSitsNumber(sitsNumber);
             selectedStadium.setStadiumName(stadiumName);
             selectedStadium.setYearBuild(yearBuild);
            getStadiumService().update(selectedStadium);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedStadium.toString();
    }
    
    public String save()
    {
        System.out.println("Start saving");
        Stadium stadium = new Stadium();
         try {
             stadium.setId(id);
             stadium.setFieldHeight(fieldHeight);
             stadium.setFieldWidth(fieldWidth);
             stadium.setModernity(modernity);
             stadium.setSitsNumber(sitsNumber);
             stadium.setStadiumName(stadiumName);
             stadium.setYearBuild(yearBuild);
            getStadiumService().add(stadium);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + stadium.toString();
    }

    public IStadiumService getStadiumService() {
        return stadiumService;
    }

    public void setStadiumService(IStadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    public List<Stadium> getStadiumList() {
        getMessageController().getMessageList().add("pokaż listę stadionów");
        stadiumList = new ArrayList<Stadium>();
        stadiumList.add(getMenuController().getPlayersClub().getStadiumidStadium());
        //session cast error needs a fix Mariusz youre up
//        stadiumList.add(getStadiumService().findById(getMenuController().getStadiumId()));
        return stadiumList;
    }

    public void setStadiumList(List<Stadium> stadiumList) {
        this.stadiumList = stadiumList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public Stadium getSelectedStadium() {
        return selectedStadium;
    }

    public void setSelectedStadium(Stadium selectedStadium) {
        this.selectedStadium = selectedStadium;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Integer getYearBuild() {
        return yearBuild;
    }

    public void setYearBuild(Integer yearBuild) {
        this.yearBuild = yearBuild;
    }

    public Integer getSitsNumber() {
        return sitsNumber;
    }

    public void setSitsNumber(Integer sitsNumber) {
        this.sitsNumber = sitsNumber;
    }

    public Integer getModernity() {
        return modernity;
    }

    public void setModernity(Integer modernity) {
        this.modernity = modernity;
    }

    public Integer getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth(Integer fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    public Integer getFieldHeight() {
        return fieldHeight;
    }

    public void setFieldHeight(Integer fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MainMenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MainMenuController menuController) {
        this.menuController = menuController;
    }

    public List<Stadium> getLeagueStadiumList() {
        getMessageController().getMessageList().add("pokaż listę stadionów");
        leagueStadiumList = new ArrayList<Stadium>();
        leagueStadiumList.add(getMenuController().getSellectedClub().getStadiumidStadium());
        return leagueStadiumList;
    }

    public void setLeagueStadiumList(List<Stadium> leagueStadiumList) {
        this.leagueStadiumList = leagueStadiumList;
    }
}
