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
import pl.mariuszczarny.slask.model.Position;
import pl.mariuszczarny.slask.service.IPositionService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "positionController")
@SessionScoped
public class PositionController implements Serializable {

    @ManagedProperty(value = "#{positionService}")
    IPositionService positionService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";

    List<Position> positionList;
    Position selectedPosition;
    private Integer goalkeeper;
    private Integer defenderLeft;
    private Integer defenderCenter;
    private Integer defenderRight;
    private Integer midfieldDef;
    private Integer midfieldRight;
    private Integer midfieldLeft;
    private Integer midfieldCenter;
    private Integer wingerLeft;
    private Integer wingerRight;
    private Integer forward;
    private Long id;

    public PositionController() {
        id=0L;
        selectedPosition=new Position();
        goalkeeper=0;
        defenderLeft=0;
        defenderCenter=0;
        defenderRight=0;
        midfieldDef=0;
        midfieldRight=0;
        midfieldLeft=0;
        midfieldCenter=0;
        wingerLeft=0;
        wingerRight=0;
        forward=0;
    }
    
    public void destroy() {
        getPositionService().delete(selectedPosition);
    }
    
    public String prepareEdit() {
        return "EditPosition";
    }
    
    public String prepareAdd()
    {
        return "AddPosition";
    }
    
    public String update()
    {
        System.out.println(selectedPosition);
        try {
             selectedPosition.setDefenderCenter(defenderCenter);
             selectedPosition.setDefenderLeft(defenderLeft);
             selectedPosition.setDefenderRight(defenderRight);
             selectedPosition.setForward(forward);
             selectedPosition.setGoalkeeper(goalkeeper);
             selectedPosition.setMidfieldCenter(midfieldCenter);
             selectedPosition.setMidfieldDef(midfieldDef);
             selectedPosition.setMidfieldLeft(midfieldLeft);
             selectedPosition.setMidfieldRight(midfieldRight);
             selectedPosition.setWingerLeft(wingerLeft);
             selectedPosition.setWingerRight(wingerRight);
            getPositionService().update(selectedPosition);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedPosition.toString();
    }
    
    public String save()
    {
        System.out.println("Start saving");
        Position position = new Position();
         try {
             position.setId((long)getPositionService().findAllByCriteria().size()+1);
             position.setDefenderCenter(defenderCenter);
             position.setDefenderLeft(defenderLeft);
             position.setDefenderRight(defenderRight);
             position.setForward(forward);
             position.setGoalkeeper(goalkeeper);
             position.setMidfieldCenter(midfieldCenter);
             position.setMidfieldDef(midfieldDef);
             position.setMidfieldLeft(midfieldLeft);
             position.setMidfieldRight(midfieldRight);
             position.setWingerLeft(wingerLeft);
             position.setWingerRight(wingerRight);
            getPositionService().add(position);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + position.toString();
    }

    public IPositionService getPositionService() {
        return positionService;
    }

    public void setPositionService(IPositionService positionService) {
        this.positionService = positionService;
    }

    public List<Position> getPositionList() {
        getMessageController().getMessageList().add("pokaż listę pozycji");
        positionList = new ArrayList<Position>();
        positionList.addAll(getPositionService().findAllByCriteria());
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(Position selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public Integer getGoalkeeper() {
        return goalkeeper;
    }

    public void setGoalkeeper(Integer goalkeeper) {
        this.goalkeeper = goalkeeper;
    }

    public Integer getDefenderLeft() {
        return defenderLeft;
    }

    public void setDefenderLeft(Integer defenderLeft) {
        this.defenderLeft = defenderLeft;
    }

    public Integer getDefenderCenter() {
        return defenderCenter;
    }

    public void setDefenderCenter(Integer defenderCenter) {
        this.defenderCenter = defenderCenter;
    }

    public Integer getDefenderRight() {
        return defenderRight;
    }

    public void setDefenderRight(Integer defenderRight) {
        this.defenderRight = defenderRight;
    }

    public Integer getMidfieldDef() {
        return midfieldDef;
    }

    public void setMidfieldDef(Integer midfieldDef) {
        this.midfieldDef = midfieldDef;
    }

    public Integer getMidfieldRight() {
        return midfieldRight;
    }

    public void setMidfieldRight(Integer midfieldRight) {
        this.midfieldRight = midfieldRight;
    }

    public Integer getMidfieldLeft() {
        return midfieldLeft;
    }

    public void setMidfieldLeft(Integer midfieldLeft) {
        this.midfieldLeft = midfieldLeft;
    }

    public Integer getMidfieldCenter() {
        return midfieldCenter;
    }

    public void setMidfieldCenter(Integer midfieldCenter) {
        this.midfieldCenter = midfieldCenter;
    }

    public Integer getWingerLeft() {
        return wingerLeft;
    }

    public void setWingerLeft(Integer wingerLeft) {
        this.wingerLeft = wingerLeft;
    }

    public Integer getWingerRight() {
        return wingerRight;
    }

    public void setWingerRight(Integer wingerRight) {
        this.wingerRight = wingerRight;
    }

    public Integer getForward() {
        return forward;
    }

    public void setForward(Integer forward) {
        this.forward = forward;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
