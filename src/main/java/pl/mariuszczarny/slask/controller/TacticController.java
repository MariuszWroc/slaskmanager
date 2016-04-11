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

import pl.mariuszczarny.slask.model.Formation;
import pl.mariuszczarny.slask.model.Tactic;
import pl.mariuszczarny.slask.service.IFormationService;
import pl.mariuszczarny.slask.service.ITacticService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "tacticController")
@SessionScoped
public class TacticController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(TacticController.class);
	private IFormationService formationService;
	private ITacticService tacticService;
	private MessageController messageController;
	private boolean firstLoad = true;
	private List<Formation> formationList;
	private String tacticName;
	private Integer attack;
	private Integer marking;
	private Integer offside;
	private Integer pressing;
	private Integer tempo;
	private Integer playWide;
	private Integer playHigh;
	private Integer flair;
	private Integer longPass;
	private Integer playToDefenders;
	private Formation selectedFormation;
	private Tactic selectedTactic;
	private Long id;

	public TacticController() {
		id = 0L;
		selectedFormation = new Formation();
		tacticName = "";
		attack = 0;
		marking = 0;
		offside = 0;
		pressing = 0;
		tempo = 0;
		playWide = 0;
		playHigh = 0;
		flair = 0;
		longPass = 0;
		playToDefenders = 0;
		selectedTactic = new Tactic();
	}

	public String prepareEdit() {
		return "EditTactic";
	}

	public String prepareAdd() {
		return "AddTactic";
	}

	public void destroy() {
		getFormationService().delete(selectedFormation);
	}

	public String update() {
		logger.info("selectedFormation " + selectedFormation);
		try {
			selectedTactic.setId((long) getTacticService().findAllByCriteria().size() + 1);
			selectedTactic.setAttack(attack);
			selectedTactic.setFlair(flair);
			selectedTactic.setLongPass(longPass);
			selectedTactic.setMarking(marking);
			selectedTactic.setOffside(offside);
			selectedTactic.setPlayHigh(playHigh);
			selectedTactic.setPlayToDefenders(playToDefenders);
			selectedTactic.setPlayWide(playWide);
			selectedTactic.setPressing(pressing);
			selectedTactic.setTacticName(tacticName);
			selectedTactic.setTempo(tempo);
			getTacticService().update(selectedTactic);
		} catch (DataAccessException e) {
			logger.warn(e.getMessage(), e);
		}
		return selectedTactic.toString();
	}

	public String save() {
		logger.info("Start saving");
		Tactic tactic = new Tactic();
		try {
			tactic.setId(id);
			tactic.setAttack(attack);
			tactic.setFlair(flair);
			tactic.setLongPass(longPass);
			tactic.setMarking(marking);
			tactic.setOffside(offside);
			tactic.setPlayHigh(playHigh);
			tactic.setPlayToDefenders(playToDefenders);
			tactic.setPlayWide(playWide);
			tactic.setPressing(pressing);
			tactic.setTacticName(tacticName);
			tactic.setTempo(tempo);
			getTacticService().add(tactic);
			return SUCCESS;
		} catch (DataAccessException e) {
        	logger.warn(e.getMessage(), e);
		}
		return ERROR + " - " + tactic.toString();
	}

	public ITacticService getTacticService() {
		return tacticService;
	}

	public void setTacticService(ITacticService tacticService) {
		this.tacticService = tacticService;
	}

	public List<Formation> getFormationList() {
		getMessageController().getMessageList().add("pokaż listę taktyk");
		formationList = new ArrayList<>();
		formationList.addAll(getFormationService().findAllByCriteria());
		if (firstLoad) {
			selectedFormation = formationList.get(0);
			firstLoad = false;
		}
		getMessageController().getMessageList().add("pokaż listę taktyk i co się gapisz");
		return formationList;
	}

	public void setFormationList(List<Formation> formationList) {
		this.formationList = formationList;
	}

	public void setMessageController(MessageController messageController) {
		this.messageController = messageController;
	}

	public MessageController getMessageController() {
		return messageController;
	}

	public String getTacticName() {
		return tacticName;
	}

	public void setTacticName(String tacticName) {
		this.tacticName = tacticName;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getMarking() {
		return marking;
	}

	public void setMarking(Integer marking) {
		this.marking = marking;
	}

	public Integer getOffside() {
		return offside;
	}

	public void setOffside(Integer offside) {
		this.offside = offside;
	}

	public Integer getPressing() {
		return pressing;
	}

	public void setPressing(Integer pressing) {
		this.pressing = pressing;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Integer getPlayWide() {
		return playWide;
	}

	public void setPlayWide(Integer playWide) {
		this.playWide = playWide;
	}

	public Integer getPlayHigh() {
		return playHigh;
	}

	public void setPlayHigh(Integer playHigh) {
		this.playHigh = playHigh;
	}

	public Integer getFlair() {
		return flair;
	}

	public void setFlair(Integer flair) {
		this.flair = flair;
	}

	public Integer getLongPass() {
		return longPass;
	}

	public void setLongPass(Integer longPass) {
		this.longPass = longPass;
	}

	public Integer getPlayToDefenders() {
		return playToDefenders;
	}

	public void setPlayToDefenders(Integer playToDefenders) {
		this.playToDefenders = playToDefenders;
	}

	public IFormationService getFormationService() {
		return formationService;
	}

	public void setFormationService(IFormationService formationService) {
		this.formationService = formationService;
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

}
