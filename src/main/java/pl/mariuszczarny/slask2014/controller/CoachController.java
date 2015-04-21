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
import org.springframework.dao.DataAccessException;
import pl.mariuszczarny.slask2014.model.Coach;
import pl.mariuszczarny.slask2014.model.Person;
import pl.mariuszczarny.slask2014.service.ICoachService;
import pl.mariuszczarny.slask2014.service.IPersonService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "coachController")
@SessionScoped
public class CoachController implements Serializable {

    @ManagedProperty(value = "#{coachService}")
    ICoachService coachService;
    @ManagedProperty(value = "#{personService}")
    IPersonService personService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";

    List<Coach> coachList;
    Coach selectedCoach;
    Long personId;
    private Long id;
    private Integer tacticalKnowledge;
    private Integer treningMental;
    private Integer treningTactic;
    private Integer treningTechnique;
    private Integer motivating;
    private Integer management;
    private Integer discipline;
    private Integer skillRate;
    Person personToAdd;

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
        System.out.println(selectedCoach);
        try {
             selectedCoach.setDiscipline(discipline);
             selectedCoach.setManagement(management);
             selectedCoach.setMotivating(motivating);
            // selectedCoach.setPersonidPerson(personToAdd);
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
        System.out.println("Start saving");
        Coach coach = new Coach();
         try {
             coach.setId((long)getCoachService().findAllByCriteria().size()+1);
             coach.setDiscipline(discipline);
             coach.setManagement(management);
             coach.setMotivating(motivating);
            // coach.setPersonidPerson(personToAdd);
             coach.setSkillRate(skillRate);
             coach.setTacticalKnowledge(tacticalKnowledge);
             coach.setTreningMental(treningMental);
             coach.setTreningTactic(treningTactic);
             coach.setTreningTechnique(treningTechnique);
            getCoachService().add(coach);
            return SUCCESS;
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
}
