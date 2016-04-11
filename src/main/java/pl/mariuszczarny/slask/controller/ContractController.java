/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import pl.mariuszczarny.slask.controller.utils.StringConstants;
import pl.mariuszczarny.slask.model.Club;
import pl.mariuszczarny.slask.model.Contract;
import pl.mariuszczarny.slask.model.Player;
import pl.mariuszczarny.slask.service.IClubService;
import pl.mariuszczarny.slask.service.IContractService;
import pl.mariuszczarny.slask.service.IPlayerService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "contractController")
@SessionScoped
public class ContractController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ContractController.class);
	private IContractService contractService;
	private IClubService clubService;
	private IPlayerService playerService;
    private MessageController messageController;
    private List<Contract> contractList;
    private Contract selectedContract;
    private Club clubidClub;
    private Player playeridPlayer;
    private Long id;
    private BigDecimal fee;
    private BigDecimal wage;
    private Date dateStart;
    private Date dateEnd;

    public ContractController() {
        id=0L;
        clubidClub=new Club();
        clubidClub.setId(0L);
        playeridPlayer=new Player();
        playeridPlayer.setId(0L);
        selectedContract=new Contract();
        fee=BigDecimal.ZERO;
        wage=BigDecimal.ZERO;
        dateStart=new Date();
        dateEnd=new Date();
    }
    
    public String prepareEdit() {
        return "EditContract";
    }
    
    public String prepareAdd()
    {
        return "AddContract";
    }
    
    public void destroy() {
        getContractService().delete(selectedContract);
    }
    
    public String update()
    {
    	logger.info("selectedContract " + selectedContract);
        try {
             selectedContract.setClubidClub(clubidClub);
             selectedContract.setDateEnd(dateEnd);
             selectedContract.setDateStart(dateStart);
             selectedContract.setFee(fee);
             selectedContract.setWage(wage);
            getContractService().update(selectedContract);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedContract.toString();
    }
    
    public String save()
    {
    	logger.info("Start saving");
        Contract contract = new Contract();
         try {
             contract.setId((long)getContractService().findAllByCriteria().size()+1);
             contract.setClubidClub(clubidClub);
             contract.setDateEnd(dateEnd);
             contract.setDateStart(dateStart);
             contract.setFee(fee);
             contract.setWage(wage);
            getContractService().add(contract);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + contract.toString();
    }

    public IContractService getContractService() {
        return contractService;
    }

    public void setContractService(IContractService contractService) {
        this.contractService = contractService;
    }

    public List<Contract> getContractList() {
        getMessageController().getMessageList().add("pokaż listę kontraktów");
        contractList = new ArrayList<Contract>();
        contractList.addAll(getContractService().findAllByCriteria());
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public Long getClubId() {
        return clubidClub.getId();
    }

    public void setClubId(Long clubId) {
    	logger.info("clubId " + clubId);
        clubidClub=getClubService().findById(clubId);
    }

    public Long getPlayerId() {
        return playeridPlayer.getId();
    }

    public void setPlayerId(Long playerId) {
        playeridPlayer=getPlayerService().findById(playerId);
    }

    public IPlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(IPlayerService playerService) {
        this.playerService = playerService;
    }   

    public IClubService getClubService() {
        return clubService;
    }

    public void setClubService(IClubService clubService) {
        this.clubService = clubService;
    }

    public Contract getSelectedContract() {
        return selectedContract;
    }

    public void setSelectedContract(Contract selectedContract) {
        this.selectedContract = selectedContract;
    }

    public Club getClubidClub() {
        return clubidClub;
    }

    public void setClubidClub(Club clubidClub) {
        this.clubidClub = clubidClub;
    }

    public Player getPlayeridPlayer() {
        return playeridPlayer;
    }

    public void setPlayeridPlayer(Player playeridPlayer) {
        this.playeridPlayer = playeridPlayer;
    }
    
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
