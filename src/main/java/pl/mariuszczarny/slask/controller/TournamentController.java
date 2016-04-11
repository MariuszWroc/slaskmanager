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

import static pl.mariuszczarny.slask.controller.utils.StringConstants.*;
import pl.mariuszczarny.slask.model.Tournament;
import pl.mariuszczarny.slask.service.ITournamentService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "tournamentController")
@SessionScoped
public class TournamentController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(TournamentController.class);
	private ITournamentService tournamentService;
	private MessageController messageController;
	private List<Tournament> tournamentList;
	private String tournamentName;
	private Integer tournamentReputation;
	private Integer teamsNumber;
	private Integer relegatesNumber;
	private Tournament selectedTournament;
	private Long id;

	public TournamentController() {
		id = 0L;
		tournamentName = "";
		tournamentReputation = 0;
		teamsNumber = 0;
		relegatesNumber = 0;
		selectedTournament = new Tournament();
	}

	public String prepareEdit() {
		return "EditTournament";
	}

	public String prepareAdd() {
		return "AddTournament";
	}

	public void destroy() {
		getTournamentService().delete(selectedTournament);
	}

	public String update() {
		logger.info("selectedTournament " + selectedTournament);
		try {
			selectedTournament.setId((long) getTournamentService().findAllByCriteria().size() + 1);
			selectedTournament.setRelegatesNumber(getRelegatesNumber());
			selectedTournament.setTeamsNumber(getTeamsNumber());
			selectedTournament.setTournamentName(tournamentName);
			selectedTournament.setTournamentReputation(getTournamentReputation());
			getTournamentService().update(selectedTournament);
		} catch (DataAccessException e) {
			logger.warn(e.getMessage(), e);
		}
		return selectedTournament.toString();
	}

	public String save() {
		logger.info("Start saving");
		Tournament tournament = new Tournament();
		try {
			tournament.setId(id);
			tournament.setRelegatesNumber(getRelegatesNumber());
			tournament.setTeamsNumber(getTeamsNumber());
			tournament.setTournamentName(tournamentName);
			tournament.setTournamentReputation(getTournamentReputation());
			getTournamentService().add(tournament);
			return SAVE_SUCCESS.getValue();
		} catch (DataAccessException e) {
			logger.warn(e.getMessage(), e);
		}
		return ERROR + " - " + tournament.toString();
	}

	public ITournamentService getTournamentService() {
		return tournamentService;
	}

	public void setTournamentService(ITournamentService tournamentService) {
		this.tournamentService = tournamentService;
	}

	public List<Tournament> getTournamentList() {
		getMessageController().getMessageList().add("pokaż listę turnieji");
		tournamentList = new ArrayList<Tournament>();
		tournamentList.addAll(getTournamentService().findAllByCriteria());
		return tournamentList;
	}

	public void setTournamentList(List<Tournament> tournamentList) {
		this.tournamentList = tournamentList;
	}

	public void setMessageController(MessageController messageController) {
		this.messageController = messageController;
	}

	public MessageController getMessageController() {
		return messageController;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public Integer getTournamentReputation() {
		return tournamentReputation;
	}

	public void setTournamentReputation(Integer tournamentReputation) {
		this.tournamentReputation = tournamentReputation;
	}

	public Integer getTeamsNumber() {
		return teamsNumber;
	}

	public void setTeamsNumber(Integer teamsNumber) {
		this.teamsNumber = teamsNumber;
	}

	public Integer getRelegatesNumber() {
		return relegatesNumber;
	}

	public void setRelegatesNumber(Integer relegatesNumber) {
		this.relegatesNumber = relegatesNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
