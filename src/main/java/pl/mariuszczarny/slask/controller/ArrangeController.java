/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;
import pl.mariuszczarny.slask.model.Arrange;
import pl.mariuszczarny.slask.model.Fixture;
import pl.mariuszczarny.slask.model.Referee;
import pl.mariuszczarny.slask.service.IArrangeService;
import pl.mariuszczarny.slask.service.IFixtureService;
import pl.mariuszczarny.slask.service.IRefereeService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "arrangeController")
@SessionScoped
public class ArrangeController implements Serializable {

    @ManagedProperty(value = "#{arrangeService}")
    IArrangeService arrangeService;
    @ManagedProperty(value = "#{refereeService}")
    IRefereeService refereeService;
    @ManagedProperty(value = "#{fixtureService}")
    IFixtureService fixtureService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;

    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";

    List<Arrange> arrangeList;
    Arrange selectedArrange;
    Long fixtureId;
    private Long id;
    Long refereeId;
    Date arrangeDate;
    private Fixture fixtureidFixture;
    private Referee refereeidReferee;

    public ArrangeController() {
        id=0L;
        selectedArrange = new Arrange();
        fixtureId = 0L;
        refereeId = 0L;
        arrangeDate = new Date();
        fixtureidFixture = new Fixture();
        refereeidReferee = new Referee();
    }

    public String prepareEdit() {
        return "EditMatch";
    }

    public String prepareAdd() {
        return "AddMatch";
    }

    public void destroy() {
        getArrangeService().delete(selectedArrange);
    }

    public String update() {
        System.out.println(selectedArrange);
        try {
            selectedArrange.setId((long)getArrangeService().findAllByCriteria().size()+1);
            selectedArrange.setArrangeDate(arrangeDate);
            //selectedArrange.setFixtureidFixture(fixtureidFixture);
            //selectedArrange.setRefereeidReferee(refereeidReferee);
            getArrangeService().update(selectedArrange);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return selectedArrange.toString();
    }

    public String save() {
        System.out.println("Start saving");
        Arrange arrange = new Arrange();
        try {
            arrange.setId(id);
            arrange.setArrangeDate(arrangeDate);
            //arrange.setFixtureidFixture(fixtureidFixture);
            //arrange.setRefereeidReferee(refereeidReferee);
            getArrangeService().add(arrange);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ERROR + " - " + arrange.toString();
    }

    public List<Arrange> getArrangeList() {
        getMessageController().getMessageList().add("pokaż listę meczy");
        arrangeList = new ArrayList<Arrange>();
        arrangeList.addAll(getArrangeService().findAllByCriteria());
        return arrangeList;
    }

    public void setArrangeList(List<Arrange> arrangeList) {
        this.arrangeList = arrangeList;
    }

    public IArrangeService getArrangeService() {
        return arrangeService;
    }

    public void setArrangeService(IArrangeService arrangeService) {
        this.arrangeService = arrangeService;
    }

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }

    public MessageController getMessageController() {
        return messageController;
    }

    public Long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Long fixtureId) {
        this.fixtureId = fixtureId;
        fixtureidFixture = getFixtureService().findById(this.fixtureId);
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
        refereeidReferee = getRefereeService().findById(this.refereeId);
    }

    public Date getArrangeDate() {
        return arrangeDate;
    }

    public void setArrangeDate(Date arrangeDate) {
        this.arrangeDate = arrangeDate;
    }

    public IRefereeService getRefereeService() {
        return refereeService;
    }

    public void setRefereeService(IRefereeService refereeService) {
        this.refereeService = refereeService;
    }

    public IFixtureService getFixtureService() {
        return fixtureService;
    }

    public void setFixtureService(IFixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }

    public Arrange getSelectedArrange() {
        return selectedArrange;
    }

    public void setSelectedArrange(Arrange selectedArrange) {
        this.selectedArrange = selectedArrange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}