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
import pl.mariuszczarny.slask.model.Coach;
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.service.ICoachService;
import pl.mariuszczarny.slask.service.IPersonService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "coachController")
@SessionScoped
public class CoachController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CoachController.class);
	private ICoachService coachService;
	private IPersonService personService;
    private MessageController messageController;
    private List<Coach> coachList;
    private Coach selectedCoach;
    private Long personId;
    private Long id;
    private Integer tacticalKnowledge;
    private Integer treningMental;
    private Integer treningTactic;
    private Integer treningTechnique;
    private Integer motivating;
    private Integer management;
    private Integer discipline;
    private Integer skillRate;
    private Person personToAdd;

    public CoachController() {
        id=0L;
        personToAdd=new Person();
        personId=0L;
        tacticalKnowledge=0;
        treningMental=0;
        treningTactic=0;
        treningTechnique=0;
        motivating=0;
        management=0;
        discipline=0;
        skillRate=0;
    }
    
    public void destroy() {
        getCoachService().delete(selectedCoach);
    }
    
    public String prepareEdit() {
        return "EditCoach";
    }
    
    public String prepareAdd()
    {
        return "AddCoach";
    }
    
    public String update()
    {
    	logger.info("selectedCoach" + selectedCoach);
        try {
             selectedCoach.setDiscipline(discipline);
             selectedCoach.setManagement(management);
             selectedCoach.setMotivating(motivating);
             selectedCoach.setSkillRate(skillRate);
             selectedCoach.setTacticalKnowledge(tacticalKnowledge);
             selectedCoach.setTreningMental(treningMental);
             selectedCoach.setTreningTactic(treningTactic);
             selectedCoach.setTreningTechnique(treningTechnique);
            getCoachService().update(selectedCoach);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedCoach.toString();
    }
    
    public String save()
    {
    	logger.info("Start saving");
        Coach coach = new Coach();
         try {
             coach.setId((long)getCoachService().findAllByCriteria().size()+1);
             coach.setDiscipline(discipline);
             coach.setManagement(management);
             coach.setMotivating(motivating);
             coach.setSkillRate(skillRate);
             coach.setTacticalKnowledge(tacticalKnowledge);
             coach.setTreningMental(treningMental);
             coach.setTreningTactic(treningTactic);
             coach.setTreningTechnique(treningTechnique);
            getCoachService().add(coach);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + coach.toString();
    }

    public ICoachService getCoachService() {
        return coachService;
    }

    public void setCoachService(ICoachService coachService) {
        this.coachService = coachService;
    }

    public List<Coach> getCoachList() {
        getMessageController().getMessageList().add("pokaż listę trenerów");
        coachList = new ArrayList<Coach>();
        coachList.addAll(getCoachService().findAllByCriteria());
        return coachList;
    }

    public void setCoachList(List<Coach> coachList) {
        this.coachList = coachList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public IPersonService getPersonService() {
        return personService;
    }

    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    public Coach getSelectedCoach() {
        return selectedCoach;
    }

    public void setSelectedCoach(Coach selectedCoach) {
        this.selectedCoach = selectedCoach;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
        personToAdd=getPersonService().findById(this.personId);
    }

    public Integer getTacticalKnowledge() {
        return tacticalKnowledge;
    }

    public void setTacticalKnowledge(Integer tacticalKnowledge) {
        this.tacticalKnowledge = tacticalKnowledge;
    }

    public Integer getTreningMental() {
        return treningMental;
    }

    public void setTreningMental(Integer treningMental) {
        this.treningMental = treningMental;
    }

    public Integer getTreningTactic() {
        return treningTactic;
    }

    public void setTreningTactic(Integer treningTactic) {
        this.treningTactic = treningTactic;
    }

    public Integer getTreningTechnique() {
        return treningTechnique;
    }

    public void setTreningTechnique(Integer treningTechnique) {
        this.treningTechnique = treningTechnique;
    }

    public Integer getMotivating() {
        return motivating;
    }

    public void setMotivating(Integer motivating) {
        this.motivating = motivating;
    }

    public Integer getManagement() {
        return management;
    }

    public void setManagement(Integer management) {
        this.management = management;
    }

    public Integer getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Integer discipline) {
        this.discipline = discipline;
    }

    public Integer getSkillRate() {
        return skillRate;
    }

    public void setSkillRate(Integer skillRate) {
        this.skillRate = skillRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Person getPersonToAdd() {
		return personToAdd;
	}

	public void setPersonToAdd(Person personToAdd) {
		this.personToAdd = personToAdd;
	}
}
