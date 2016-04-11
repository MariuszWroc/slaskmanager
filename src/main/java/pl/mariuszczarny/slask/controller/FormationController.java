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
import pl.mariuszczarny.slask.model.Formation;
import pl.mariuszczarny.slask.model.Tactic;
import pl.mariuszczarny.slask.service.IFormationService;
import pl.mariuszczarny.slask.service.ITacticService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "formationController")
@SessionScoped
public class FormationController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FormationController.class);
	private IFormationService formationService;
    private MessageController messageController;
    private ITacticService tacticService;
    private List<Formation> formationList;
    private Formation selectedFormation;
    private Long tacticId;
    private Long id;
    private String formationName;
    private Integer defendersNumber;
    private Integer midfieldNumber;
    private Integer forwardNumber;
    private Tactic selectedTactic;
	private Tactic tacticidTactic;

    public FormationController() {
        id=0L;
        tacticId=0L;
        formationName="";
        defendersNumber=0;
        midfieldNumber=0;
        forwardNumber=0;
        selectedFormation=new Formation();
        tacticidTactic=new Tactic();
        selectedTactic=new Tactic();
    }
    
    public String prepareEdit() {
        return "EditFormation";
    }
    
    public String prepareAdd()
    {
        return "AddFormation";
    }
    
    public void destroy() {
        getFormationService().delete(selectedFormation);
    }
    
    public String update()
    {
    	logger.info("selectedFormation" + selectedFormation);
        try {
            selectedFormation.setDefendersNumber(defendersNumber);
            selectedFormation.setFormationName(formationName);
            selectedFormation.setForwardNumber(forwardNumber);
            selectedFormation.setMidfieldNumber(midfieldNumber);
        getFormationService().update(selectedFormation);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedFormation.toString();
    }
    
    public String save()
    {
    	logger.info("Start saving");
        Formation formation = new Formation();
         try {
             formation.setId((long)getFormationService().findAllByCriteria().size()+1);
             formation.setDefendersNumber(defendersNumber);
             formation.setFormationName(formationName);
             formation.setForwardNumber(forwardNumber);
             formation.setMidfieldNumber(midfieldNumber);
            getFormationService().add(formation);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + formation.toString();
    }

    public IFormationService getFormationService() {
        return formationService;
    }

    public void setFormationService(IFormationService formationService) {
        this.formationService = formationService;
    }

    public List<Formation> getFormationList() {
        getMessageController().getMessageList().add("pokaż listę formacji");
        formationList = new ArrayList<Formation>();
        formationList.addAll(getFormationService().findAllByCriteria());
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public Long getTacticId() {
        return tacticId;
    }

    public void setTacticId(Long tacticId) {
        this.tacticId = tacticId;
        logger.info("tacticId" + tacticId.toString());
        tacticidTactic=getTacticService().findById(tacticId);
    }

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public Integer getDefendersNumber() {
        return defendersNumber;
    }

    public void setDefendersNumber(Integer defendersNumber) {
        this.defendersNumber = defendersNumber;
    }

    public Integer getMidfieldNumber() {
        return midfieldNumber;
    }

    public void setMidfieldNumber(Integer midfieldNumber) {
        this.midfieldNumber = midfieldNumber;
    }

    public Integer getForwardNumber() {
        return forwardNumber;
    }

    public void setForwardNumber(Integer forwardNumber) {
        this.forwardNumber = forwardNumber;
    }

    public Tactic getSelectedTactic() {
        return selectedTactic;
    }

    public void setSelectedTactic(Tactic selectedTactic) {
        this.selectedTactic = selectedTactic;
    }

    public ITacticService getTacticService() {
        return tacticService;
    }

    public void setTacticService(ITacticService tacticService) {
        this.tacticService = tacticService;
    }

    public Formation getSelectedFormation() {
        return selectedFormation;
    }

    public void setSelectedFormation(Formation selectedFormation) {
        this.selectedFormation = selectedFormation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Tactic getTacticidTactic() {
		return tacticidTactic;
	}

	public void setTacticidTactic(Tactic tacticidTactic) {
		this.tacticidTactic = tacticidTactic;
	}
}
