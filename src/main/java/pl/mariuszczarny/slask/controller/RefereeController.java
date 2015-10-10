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
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.model.Referee;
import pl.mariuszczarny.slask.service.IPersonService;
import pl.mariuszczarny.slask.service.IRefereeService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "refereeController")
@SessionScoped
public class RefereeController implements Serializable {

    @ManagedProperty(value = "#{refereeService}")
    IRefereeService refereeService;
    @ManagedProperty(value = "#{personService}")
    IPersonService personService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;
    
    @ManagedProperty(value = "#{mainMenuController}")
    MainMenuController menuController;
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";

    List<Referee> refereeList;
    Person personToAdd;
    Referee selectedReferee;
    Integer refereeing;
    Integer punishing;
    Long personId;
    private Long id;

    public RefereeController() {
        id=0L;
        personToAdd=new Person();
        selectedReferee= new Referee();
        personId=0L;
        refereeing=0;
        punishing=0;
    }
    
    public String prepareEdit() {
        return "EditReferee";
    }
    
    public String prepareAdd()
    {
        return "AddReferee";
    }
    
    public void destroy() {
        getRefereeService().delete(selectedReferee);
    }
    
    public String update()
    {
        System.out.println(selectedReferee);
        try {
             selectedReferee.setId((long)getRefereeService().findAllByCriteria().size()+1);
            // selectedReferee.setPersonidPerson(personToAdd);
             selectedReferee.setPunishing(punishing);
             selectedReferee.setRefereeing(refereeing);
            getRefereeService().update(selectedReferee);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedReferee.toString();
    }
    
    public String save()
    {
        System.out.println("Start saving");
        Referee referee = new Referee();
         try {
             referee.setId(id);
            // referee.setPersonidPerson(personToAdd);
             referee.setPunishing(punishing);
             referee.setRefereeing(refereeing);
            getRefereeService().add(referee);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + referee.toString();
    }

    public IRefereeService getRefereeService() {
        return refereeService;
    }

    public void setRefereeService(IRefereeService refereeService) {
        this.refereeService = refereeService;
    }

    public List<Referee> getRefereeList() {
        getMessageController().getMessageList().add("pokaż listę sędziów");
        refereeList = new ArrayList<Referee>();
//        if(getMenuController().getRefereeId()>=0){
            //session cast error needs a fix Mariusz youre up
            //refereeList.add(getRefereeService().findById(getMenuController().getRefereeId()));
//        }else{
            refereeList.addAll(getRefereeService().findAllByCriteria());
//        }
        return refereeList;
    }

    public void setRefereeList(List<Referee> refereeList) {
        this.refereeList = refereeList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }
    
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
        personToAdd=getPersonService().findById(this.personId);
    }

    public IPersonService getPersonService() {
        return personService;
    }

    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    public Referee getSelectedReferee() {
        return selectedReferee;
    }

    public void setSelectedReferee(Referee selectedReferee) {
        this.selectedReferee = selectedReferee;
    }

    public Integer getRefereeing() {
        return refereeing;
    }

    public void setRefereeing(Integer refereeing) {
        this.refereeing = refereeing;
    }

    public Integer getPunishing() {
        return punishing;
    }

    public void setPunishing(Integer punishing) {
        this.punishing = punishing;
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
}
