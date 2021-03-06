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
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import pl.mariuszczarny.slask.controller.utils.StringConstants;
import pl.mariuszczarny.slask.model.Club;
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.model.Staff;
import pl.mariuszczarny.slask.service.IClubService;
import pl.mariuszczarny.slask.service.IPersonService;
import pl.mariuszczarny.slask.service.IStaffService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "staffController")
@SessionScoped
public class StaffController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(StaffController.class);
	private IStaffService staffService;
    private IPersonService personService;
    private IClubService clubService;
    private MessageController messageController;
    private MainMenuController menuController;
    private List<Staff> staffList;
    private List<Staff> leagueStaffList;
    private Long personId;
    private Long clubId;
    private Person personToAdd;
    private Club clubToAdd;
    private Staff selectedStaff;
    private String staffFunction;
    private Long id;

    public StaffController() {
        id=0L;
        staffFunction="";
        personId=0L;
        clubId=0L;
        selectedStaff= new Staff();
        personToAdd=new Person();
        clubToAdd=new Club();
    }
    
    public String prepareEdit() {
        return "EditStaff";
    }
    
    public String prepareAdd()
    {
        return "AddStaff";
    }
    
    public void destroy() {
        getStaffService().delete(selectedStaff);
    }
    
    public String update()
    {
    	logger.info("selectedStaff " + selectedStaff);
        try {
             selectedStaff.setStaffFunction(staffFunction);
            getStaffService().update(selectedStaff);
        } catch (DataAccessException e) {
            logger.info(e.getMessage(), e); 
        }  
        return selectedStaff.toString();
    }
    
    public String save()
    {
    	logger.info("Start saving");
        Staff staff = new Staff();
         try {
             staff.setId((long)getStaffService().findAllByCriteria().size()+1);
             staff.setStaffFunction(staffFunction);
            getStaffService().add(staff);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + staff.toString();
    }

    public IStaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(IStaffService staffService) {
        this.staffService = staffService;
    }

    public List<Staff> getStaffList() {
        getMessageController().getMessageList().add("pokaż listę personelu");
        staffList = new ArrayList<Staff>();
        staffList.addAll(getStaffService().findStaffByClub(getMenuController().getPlayersClub()));
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
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

    public IClubService getClubService() {
        return clubService;
    }

    public void setClubService(IClubService clubService) {
        this.clubService = clubService;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
        setClubToAdd(getClubService().findById(this.clubId));
    }

    public Person getPersonToAdd() {
        return personToAdd;
    }

    public void setPersonToAdd(Person personToAdd) {
        this.personToAdd = personToAdd;
    }

    public Staff getSelectedStaff() {
        return selectedStaff;
    }

    public void setSelectedStaff(Staff selectedStaff) {
        this.selectedStaff = selectedStaff;
    } 

    public String getStaffFunction() {
        return staffFunction;
    }

    public void setStaffFunction(String staffFunction) {
        this.staffFunction = staffFunction;
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

    public List<Staff> getLeagueStaffList() {
        getMessageController().getMessageList().add("pokaż listę personelu");
        leagueStaffList = new ArrayList<Staff>();
        leagueStaffList.addAll(getStaffService().findStaffByClub(getMenuController().getSellectedClub()));
        return leagueStaffList;
    }

    public void setLeagueStaffList(List<Staff> leagueStaffList) {
        this.leagueStaffList = leagueStaffList;
    }

	public Club getClubToAdd() {
		return clubToAdd;
	}

	public void setClubToAdd(Club clubToAdd) {
		this.clubToAdd = clubToAdd;
	}
}
