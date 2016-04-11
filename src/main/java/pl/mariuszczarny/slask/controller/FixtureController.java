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
import pl.mariuszczarny.slask.model.Fixture;
import pl.mariuszczarny.slask.model.Tournament;
import pl.mariuszczarny.slask.service.IFixtureService;
import pl.mariuszczarny.slask.service.ITournamentService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "fixtureController")
@SessionScoped
public class FixtureController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FixtureController.class);
	private IFixtureService fixtureService;
    private ITournamentService tournamentService;
    private MessageController messageController;
    private Integer seasonYear;
    private List<Fixture> fixtureList;
    private Fixture selectedFixture;
    private Long tournamentId;
    private Long id;
    private Tournament tournamentidTournament;

    public FixtureController() {
        id=0L;
        tournamentId=0L;
        seasonYear=2015;
        tournamentidTournament=new Tournament();
        selectedFixture= new Fixture();
    }
    
    public String prepareEdit() {
        return "EditFixture";
    }
    
    public String prepareAdd()
    {
        return "AddFixture";
    }
    
    public void destroy() {
        getFixtureService().delete(selectedFixture);
    }
    
    public String update()
    {
    	logger.info("selectedFixture " + selectedFixture);
        try {
            selectedFixture.setId(id);
            selectedFixture.setSeasonYear(seasonYear);
        getFixtureService().update(selectedFixture);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedFixture.toString();
    }

    public String save() {
    	logger.info("Start saving");
        try {
            Fixture fixture = new Fixture();
            fixture.setId((long)getFixtureService().findAllByCriteria().size()+1);
            fixture.setSeasonYear(seasonYear);
            getFixtureService().add(fixture);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public IFixtureService getFixtureService() {
        return fixtureService;
    }

    public void setFixtureService(IFixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }

    public List<Fixture> getFixtureList() {
        getMessageController().getMessageList().add("pokaż listę fixture");
        fixtureList = new ArrayList<Fixture>();
        fixtureList.addAll(getFixtureService().findAllByCriteria());
        return fixtureList;
    }

    public void setFixtureList(List<Fixture> fixtureList) {
        this.fixtureList = fixtureList;
    }

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }

    public MessageController getMessageController() {
        return messageController;
    }

    public Integer getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(Integer seasonYear) {
        this.seasonYear = seasonYear;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
        tournamentidTournament=getTournamentService().findById(tournamentId);
    }

    public ITournamentService getTournamentService() {
        return tournamentService;
    }

    public void setTournamentService(ITournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    public Fixture getSelectedFixture() {
        return selectedFixture;
    }

    public void setSelectedFixture(Fixture selectedFixture) {
        this.selectedFixture = selectedFixture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Tournament getTournamentidTournament() {
		return tournamentidTournament;
	}

	public void setTournamentidTournament(Tournament tournamentidTournament) {
		this.tournamentidTournament = tournamentidTournament;
	}
}
