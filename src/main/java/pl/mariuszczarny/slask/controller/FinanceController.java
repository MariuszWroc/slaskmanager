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
import pl.mariuszczarny.slask.model.Finance;
import pl.mariuszczarny.slask.service.IFinanceService;


/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "financeController")
@SessionScoped
public class FinanceController implements Serializable {

    @ManagedProperty(value = "#{financeService}")
    IFinanceService financeService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;
    @ManagedProperty(value = "#{mainMenuController}")
    MainMenuController menuController;
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";
    
    List<Finance> financeList;
    Finance selectedFinance;
    private Long id;
    private Integer budget;
    private Integer transferBudget;
    private Integer wageBudget;
    private Integer stadiumCost;
    private Integer avgTicketCost;
    private Integer avgSeasonTicketCost;
    private Integer seasonTicketsNumber;
    private Integer dept;
    private Integer fromSponsors;

    public FinanceController() {
        id=0L;
        selectedFinance=new Finance();
        budget=0;
        transferBudget=0;
        wageBudget=0;
        stadiumCost=0;
        avgTicketCost=0;
        avgSeasonTicketCost=0;
        seasonTicketsNumber=0;
        dept=0;
        fromSponsors=0;
    }
    
    public void destroy() {
        getFinanceService().delete(selectedFinance);
    }
    
    public String prepareEdit() {
        return "EditFinance";
    }
    
    public String prepareAdd()
    {
        return "AddFinance";
    }
    
    public String update()
    {
        System.out.println(selectedFinance);
        try {
            selectedFinance.setAvgSeasonTicketCost(avgSeasonTicketCost);
            selectedFinance.setAvgTicketCost(avgTicketCost);
            selectedFinance.setBudget(budget);
            selectedFinance.setDept(dept);
            selectedFinance.setFromSponsors(fromSponsors);
            selectedFinance.setSeasonTicketsNumber(seasonTicketsNumber);
            selectedFinance.setStadiumCost(stadiumCost);
            selectedFinance.setTransferBudget(transferBudget);
            selectedFinance.setWageBudget(wageBudget);
        getFinanceService().update(selectedFinance);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedFinance.toString();
    }

    public String save() {
        System.out.println("Start saving");
        try {
            Finance finance = new Finance();
            finance.setId((long)getFinanceService().findAllByCriteria().size()+1);
            finance.setAvgSeasonTicketCost(avgSeasonTicketCost);
            finance.setAvgTicketCost(avgTicketCost);
            finance.setBudget(budget);
            finance.setDept(dept);
            finance.setFromSponsors(fromSponsors);
            finance.setSeasonTicketsNumber(seasonTicketsNumber);
            finance.setStadiumCost(stadiumCost);
            finance.setTransferBudget(transferBudget);
            finance.setWageBudget(wageBudget);
            getFinanceService().add(finance);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public IFinanceService getFinanceService() {
        return financeService;
    }

    public void setFinanceService(IFinanceService financeService) {
        this.financeService = financeService;
    }

    public List<Finance> getFinanceList() {
        getMessageController().getMessageList().add("pokaż listę finansów");
        financeList = new ArrayList<Finance>();
        financeList.add(getMenuController().getPlayersClub().getFinanceidFinance());
//        financeList.addAll(getFinanceService().findAllByCriteria());
        return financeList;
    }

    public void setFinanceList(List<Finance> financeList) {
        this.financeList = financeList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public Finance getSelectedFinance() {
        return selectedFinance;
    }

    public void setSelectedFinance(Finance selectedFinance) {
        this.selectedFinance = selectedFinance;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getTransferBudget() {
        return transferBudget;
    }

    public void setTransferBudget(Integer transferBudget) {
        this.transferBudget = transferBudget;
    }

    public Integer getWageBudget() {
        return wageBudget;
    }

    public void setWageBudget(Integer wageBudget) {
        this.wageBudget = wageBudget;
    }

    public Integer getStadiumCost() {
        return stadiumCost;
    }

    public void setStadiumCost(Integer stadiumCost) {
        this.stadiumCost = stadiumCost;
    }

    public Integer getAvgTicketCost() {
        return avgTicketCost;
    }

    public void setAvgTicketCost(Integer avgTicketCost) {
        this.avgTicketCost = avgTicketCost;
    }

    public Integer getAvgSeasonTicketCost() {
        return avgSeasonTicketCost;
    }

    public void setAvgSeasonTicketCost(Integer avgSeasonTicketCost) {
        this.avgSeasonTicketCost = avgSeasonTicketCost;
    }

    public Integer getSeasonTicketsNumber() {
        return seasonTicketsNumber;
    }

    public void setSeasonTicketsNumber(Integer seasonTicketsNumber) {
        this.seasonTicketsNumber = seasonTicketsNumber;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Integer getFromSponsors() {
        return fromSponsors;
    }

    public void setFromSponsors(Integer fromSponsors) {
        this.fromSponsors = fromSponsors;
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
