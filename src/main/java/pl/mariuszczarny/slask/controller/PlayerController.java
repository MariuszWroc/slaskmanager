/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.dao.DataAccessException;
import pl.mariuszczarny.slask.controller.utils.StringConstants;
import pl.mariuszczarny.slask.model.Contract;
import pl.mariuszczarny.slask.model.Person;
import pl.mariuszczarny.slask.model.Player;
import pl.mariuszczarny.slask.model.Position;
import pl.mariuszczarny.slask.service.IContractService;
import pl.mariuszczarny.slask.service.IPersonService;
import pl.mariuszczarny.slask.service.IPlayerService;
import pl.mariuszczarny.slask.service.IPositionService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "playerController")
@SessionScoped
public class PlayerController implements Serializable {

    @ManagedProperty(value = "#{playerService}")
    IPlayerService playerService;
    @ManagedProperty(value = "#{positionService}")
    IPositionService positionService;
    @ManagedProperty(value = "#{personService}")
    IPersonService personService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;
    @ManagedProperty(value = "#{contractService}")
    IContractService contractService;
    @ManagedProperty(value = "#{mainMenuController}")
    MainMenuController menuController;
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";

    List<Contract> playerList;
    Contract selectedContract;
    Player selectedPlayer;
    Long personId;
    Long positionId;
    Person personToAdd;
    Position positionToAdd;
    private Long id;
    private Integer currentForm;
    private Integer reputation;
    private Integer potential;
    private Integer legLeft;
    private Integer legRight;
    private Integer determination;
    private Integer dirtness;
    private Integer influence;
    private Integer injury;
    private Integer pace;
    private Integer strength;
    private Integer stamina;
    private Integer setPieces;
    private Integer technique;
    private Integer finishing;
    private Integer passing;
    private Integer marking;
    private Integer tackling;
    private Integer heading;
    private Integer reflex;
    private Integer handling;
    private Integer weight;
    private Integer height;
    private String bestPosition;
    private String bestPositionShort;
    private String labelText;

    public PlayerController() {
        id=0L;
        labelText="";
        selectedPlayer=new Player();
        personId=0L;
        positionId=0L;
        personToAdd=new Person();
        positionToAdd=new Position();
        currentForm=0;
        reputation=0;
        potential=0;
        legLeft=0;
        legRight=0;
        determination=0;
        dirtness=0;
        influence=0;
        injury=0;
        pace=0;
        strength=0;
        stamina=0;
        setPieces=0;
        technique=0;
        finishing=0;
        passing=0;
        marking=0;
        tackling=0;
        heading=0;
        reflex=0;
        handling=0;
        weight=0;
        height=0;
        bestPosition="";
        bestPositionShort="";
    }
    
    public void destroy() {
        getPlayerService().delete(selectedPlayer);
    }
    
    public String prepareEdit() {
        return "EditPlayer";
    }
    
    public String prepareAdd()
    {
        return "AddPlayer";
    }
    
    public String update()
    {
        System.out.println(selectedPlayer);
        try {
             selectedPlayer.setId((long)getPlayerService().findAllByCriteria().size()+1);
             selectedPlayer.setBestPosition(bestPosition);
             selectedPlayer.setBestPositionShort(bestPositionShort);
             selectedPlayer.setCurrentForm(currentForm);
             selectedPlayer.setDetermination(determination);
             selectedPlayer.setDirtness(dirtness);
             selectedPlayer.setFinishing(finishing);
             selectedPlayer.setHandling(handling);
             selectedPlayer.setHeading(heading);
             selectedPlayer.setHeight(height);
             selectedPlayer.setInfluence(influence);
             selectedPlayer.setInjury(injury);
             selectedPlayer.setLegLeft(legLeft);
             selectedPlayer.setLegRight(legRight);
             selectedPlayer.setMarking(marking);
             selectedPlayer.setPace(pace);
             selectedPlayer.setPassing(passing);
            // selectedPlayer.setPersonidPerson(personToAdd);
            // selectedPlayer.setPositionidPosition(positionToAdd);
             selectedPlayer.setPotential(potential);
             selectedPlayer.setReflex(reflex);
             selectedPlayer.setReputation(reputation);
             selectedPlayer.setSetPieces(setPieces);
             selectedPlayer.setStamina(stamina);
             selectedPlayer.setStrength(strength);
             selectedPlayer.setTackling(tackling);
             selectedPlayer.setTechnique(technique);
             selectedPlayer.setWeight(weight);
            getPlayerService().update(selectedPlayer);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedPlayer.toString();
    }
    
    public String save()
    {
        System.out.println("Start saving");
        Player player = new Player();
         try {
             player.setId(id);
             player.setBestPosition(bestPosition);
             player.setBestPositionShort(bestPositionShort);
             player.setCurrentForm(currentForm);
             player.setDetermination(determination);
             player.setDirtness(dirtness);
             player.setFinishing(finishing);
             player.setHandling(handling);
             player.setHeading(heading);
             player.setHeight(height);
             player.setInfluence(influence);
             player.setInjury(injury);
             player.setLegLeft(legLeft);
             player.setLegRight(legRight);
             player.setMarking(marking);
             player.setPace(pace);
             player.setPassing(passing);
             player.setPersonidPerson(personToAdd);
             player.setPositionidPosition(positionToAdd);
             player.setPotential(potential);
             player.setReflex(reflex);
             player.setReputation(reputation);
             player.setSetPieces(setPieces);
             player.setStamina(stamina);
             player.setStrength(strength);
             player.setTackling(tackling);
             player.setTechnique(technique);
             player.setWeight(weight);
            getPlayerService().add(player);
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + player.toString();
    }

    public IPlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(IPlayerService playerService) {
        this.playerService = playerService;
    }

    public List<Contract> getPlayerList() {
        getMessageController().getMessageList().add("pokaż listę piłkarzy");
        playerList = new ArrayList<Contract>();
        playerList = getContractService().findByClub(getMenuController().getPlayersClub());
        return playerList;
    }

    public void setPlayerList(List<Contract> playerList) {
        this.playerList = playerList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public IPositionService getPositionService() {
        return positionService;
    }

    public void setPositionService(IPositionService positionService) {
        this.positionService = positionService;
    }

    public IPersonService getPersonService() {
        return personService;
    }

    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    public Long getPersonId() {
        return personId;  
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
        personToAdd=getPersonService().findById(this.personId);
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
        positionToAdd=getPositionService().findById(this.positionId);
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(Player selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }

    public Integer getCurrentForm() {
        return currentForm;
    }

    public void setCurrentForm(Integer currentForm) {
        this.currentForm = currentForm;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Integer getPotential() {
        return potential;
    }

    public void setPotential(Integer potential) {
        this.potential = potential;
    }

    public Integer getLegLeft() {
        return legLeft;
    }

    public void setLegLeft(Integer legLeft) {
        this.legLeft = legLeft;
    }

    public Integer getLegRight() {
        return legRight;
    }

    public void setLegRight(Integer legRight) {
        this.legRight = legRight;
    }

    public Integer getDetermination() {
        return determination;
    }

    public void setDetermination(Integer determination) {
        this.determination = determination;
    }

    public Integer getDirtness() {
        return dirtness;
    }

    public void setDirtness(Integer dirtness) {
        this.dirtness = dirtness;
    }

    public Integer getInfluence() {
        return influence;
    }

    public void setInfluence(Integer influence) {
        this.influence = influence;
    }

    public Integer getInjury() {
        return injury;
    }

    public void setInjury(Integer injury) {
        this.injury = injury;
    }

    public Integer getPace() {
        return pace;
    }

    public void setPace(Integer pace) {
        this.pace = pace;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getSetPieces() {
        return setPieces;
    }

    public void setSetPieces(Integer setPieces) {
        this.setPieces = setPieces;
    }

    public Integer getTechnique() {
        return technique;
    }

    public void setTechnique(Integer technique) {
        this.technique = technique;
    }

    public Integer getFinishing() {
        return finishing;
    }

    public void setFinishing(Integer finishing) {
        this.finishing = finishing;
    }

    public Integer getPassing() {
        return passing;
    }

    public void setPassing(Integer passing) {
        this.passing = passing;
    }

    public Integer getMarking() {
        return marking;
    }

    public void setMarking(Integer marking) {
        this.marking = marking;
    }

    public Integer getTackling() {
        return tackling;
    }

    public void setTackling(Integer tackling) {
        this.tackling = tackling;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public Integer getReflex() {
        return reflex;
    }

    public void setReflex(Integer reflex) {
        this.reflex = reflex;
    }

    public Integer getHandling() {
        return handling;
    }

    public void setHandling(Integer handling) {
        this.handling = handling;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(String bestPosition) {
        this.bestPosition = bestPosition;
    }

    public String getBestPositionShort() {
        return bestPositionShort;
    }

    public void setBestPositionShort(String bestPositionShort) {
        this.bestPositionShort = bestPositionShort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IContractService getContractService() {
        return contractService;
    }

    public void setContractService(IContractService contractService) {
        this.contractService = contractService;
    }

    public MainMenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MainMenuController menuController) {
        this.menuController = menuController;
    }
    
    public void onRowSelect(){
        try {
            labelText=selectedContract.getPlayeridPlayer().getPersonidPerson().getName() + " " + selectedContract.getPlayeridPlayer().getPersonidPerson().getSurname();
            FacesContext.getCurrentInstance().getExternalContext().redirect("PlayerProfile.xhtml");                    
        } catch (IOException ex) {}
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public Contract getSelectedContract() {
        return selectedContract;
    }

    public void setSelectedContract(Contract selectedContract) {
        this.selectedContract = selectedContract;
    }
    
    
}
