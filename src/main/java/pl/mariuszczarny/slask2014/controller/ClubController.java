/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.springframework.dao.DataAccessException;
import pl.mariuszczarny.slask2014.model.Club;
import pl.mariuszczarny.slask2014.model.Coach;
import pl.mariuszczarny.slask2014.model.Finance;
import pl.mariuszczarny.slask2014.model.Formation;
import pl.mariuszczarny.slask2014.model.Stadium;
import pl.mariuszczarny.slask2014.model.Tournament;
import pl.mariuszczarny.slask2014.model.Training;
import pl.mariuszczarny.slask2014.service.IClubService;
import pl.mariuszczarny.slask2014.service.ICoachService;
import pl.mariuszczarny.slask2014.service.IFinanceService;
import pl.mariuszczarny.slask2014.service.IFormationService;
import pl.mariuszczarny.slask2014.service.IStadiumService;
import pl.mariuszczarny.slask2014.service.ITournamentService;
import pl.mariuszczarny.slask2014.service.ITrainingService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "clubController")
@SessionScoped
public class ClubController implements Serializable {

    @ManagedProperty(value = "#{clubService}")
    IClubService clubService;
    @ManagedProperty(value = "#{coachService}")
    ICoachService coachService;
    @ManagedProperty(value = "#{financeService}")
    IFinanceService financeService;
    @ManagedProperty(value = "#{tournamentService}")
    ITournamentService tournamentService;
    @ManagedProperty(value = "#{stadiumService}")
    IStadiumService stadiumService;
    @ManagedProperty(value = "#{trainingService}")
    ITrainingService trainingService;
    @ManagedProperty(value = "#{formationService}")
    IFormationService formationService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";

    DataModel<Club> clubList;
    private Club selectedClub;
    private Integer attendanceAvg;
    private Integer attendanceMin;
    private Integer attendanceMax;
    private Integer trainingAssets;
    private Integer youth;
    private String clubName;
    private String clubNick;
    private Integer yearFound;
    private Integer morale;
    private Integer clubReputation;
    private Long id;
    private String colours;
    private Formation formationidFormation;
    private Training trainingidTraining;
    private Stadium stadiumidStadium;
    private Tournament tournamentidTournament;
    private Finance financeidFinance;
    private Coach coachidCoach;
    private List<Integer> it;
    
    public ClubController() {
        id=0L;
        selectedClub = new Club();
        attendanceAvg = 0;
        attendanceMin = 0;
        attendanceMax = 0;
        trainingAssets = 0;
        youth = 0;
        clubName = "";
        clubNick = "";
        yearFound = 1900;
        morale = 0;
        clubReputation = 0;
        colours = "";
        formationidFormation = new Formation();
        formationidFormation.setId(0L);
        trainingidTraining = new Training();
        trainingidTraining.setId(0L);
        stadiumidStadium = new Stadium();
        stadiumidStadium.setId(0L);
        tournamentidTournament = new Tournament();
        tournamentidTournament.setId(0L);
        financeidFinance = new Finance();
        financeidFinance.setId(0L);
        coachidCoach = new Coach();
        coachidCoach.setId(0L);
        it = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        List<Club> clubs = new ArrayList<>();
        clubs = getClubService().findAllByCriteria();
        clubList = new ListDataModel<Club>(clubs);
    }
    
    public String prepareEdit() {
        return "EditClub";
    }
    
    public String prepareAdd()
    {
        return "AddClub";
    }
    
    public void destroy() {
        getClubService().delete(selectedClub);
    }
    
    public String update(){
        System.out.println(selectedClub);
        try {
             selectedClub.setAttendanceAvg(attendanceAvg);
             selectedClub.setAttendanceMax(attendanceMax);
             selectedClub.setAttendanceMin(attendanceMin);
             selectedClub.setClubName(clubName);
             selectedClub.setClubNick(clubNick);
             selectedClub.setClubReputation(clubReputation);
             //selectedClub.setCoachidCoach(coachidCoach);
             selectedClub.setColours(colours);
             //selectedClub.setFinanceidFinance(financeidFinance);
             //selectedClub.setFormationidFormation(formationidFormation);
             selectedClub.setMorale(morale);
             //selectedClub.setStadiumidStadium(stadiumidStadium);
             //selectedClub.setTournamentidTournament(tournamentidTournament);
             selectedClub.setTrainingAssets(trainingAssets);
             //selectedClub.setTrainingidTraining(trainingidTraining);
             selectedClub.setYearFound(yearFound);
             selectedClub.setYouth(youth);
        getClubService().update(selectedClub);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedClub.toString();
    }
    
    public String save()
    {
        System.out.println("Start saving");
        Club club = new Club();
         try {
             club.setId((long)getClubService().findAllByCriteria().size()+1);
             club.setAttendanceAvg(attendanceAvg);
             club.setAttendanceMax(attendanceMax);
             club.setAttendanceMin(attendanceMin);
             club.setClubName(clubName);
             club.setClubNick(clubNick);
             club.setClubReputation(clubReputation);
             //club.setCoachidCoach(coachidCoach);
             club.setColours(colours);
             //club.setFinanceidFinance(financeidFinance);
             club.setFormationidFormation(formationidFormation);
             club.setMorale(morale);
             //club.setStadiumidStadium(stadiumidStadium);
             //club.setTournamentidTournament(tournamentidTournament);
             club.setTrainingAssets(trainingAssets);
             //club.setTrainingidTraining(trainingidTraining);
             club.setYearFound(yearFound);
             club.setYouth(youth);
            getClubService().add(club);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + club.toString();
    }

    public IClubService getClubService() {
        return clubService;
    }

    public void setClubService(IClubService clubService) {
        this.clubService = clubService;
    }

    public DataModel<Club> getClubList() {
        getMessageController().getMessageList().add("pokaż listę klubów");
        
        //clubList.addAll(getClubService().findAllByCriteria());
        return clubList;
    }

    public void setClubList(DataModel<Club> clubList) {
        this.clubList = clubList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public ICoachService getCoachService() {
        return coachService;
    }

    public void setCoachService(ICoachService coachService) {
        this.coachService = coachService;
    }

    public IFinanceService getFinanceService() {
        return financeService;
    }

    public void setFinanceService(IFinanceService financeService) {
        this.financeService = financeService;
    }

    public ITournamentService getTournamentService() {
        return tournamentService;
    }

    public void setTournamentService(ITournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    public IStadiumService getStadiumService() {
        return stadiumService;
    }

    public void setStadiumService(IStadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    public ITrainingService getTrainingService() {
        return trainingService;
    }

    public void setTrainingService(ITrainingService trainingService) {
        this.trainingService = trainingService;
    }

    public IFormationService getFormationService() {
        return formationService;
    }

    public void setFormationService(IFormationService formationService) {
        this.formationService = formationService;
    }

    public Formation getFormationId() {
        return formationidFormation;
    }

    public void setFormationId(Long formationId) {
        formationidFormation=getFormationService().findById(formationId);
    }

    public Training getTrainingidTraining() {
        return trainingidTraining;
    }

    public void setTrainingidTraining(Long trainingidTraining) {
        this.trainingidTraining = getTrainingService().findById(trainingidTraining);
    }

    public Stadium getStadiumId() {
        return stadiumidStadium;
    }

    public void setStadiumId(Long stadiumId) {
        stadiumidStadium=getStadiumService().findById(stadiumId);
    }

    public Tournament getTournamentId() {
        return tournamentidTournament;
    }

    public void setTournamentId(Long tournamentId) {
        tournamentidTournament=getTournamentService().findById(tournamentId);
    }

    public Finance getFinanceId() {
        return financeidFinance;
    }

    public void setFinanceId(Long financeId) {
        financeidFinance=getFinanceService().findById(financeId);
    }

    public Coach getCoachId() {
        return coachidCoach;
    }

    public void setCoachId(Long coachId) {
        coachidCoach=getCoachService().findById(coachId);
    }

    public Integer getAttendanceAvg() {
        return attendanceAvg;
    }

    public void setAttendanceAvg(Integer attendanceAvg) {
        this.attendanceAvg = attendanceAvg;
    }

    public Integer getAttendanceMin() {
        return attendanceMin;
    }

    public void setAttendanceMin(Integer attendanceMin) {
        this.attendanceMin = attendanceMin;
    }

    public Integer getAttendanceMax() {
        return attendanceMax;
    }

    public void setAttendanceMax(Integer attendanceMax) {
        this.attendanceMax = attendanceMax;
    }

    public Integer getTrainingAssets() {
        return trainingAssets;
    }

    public void setTrainingAssets(Integer trainingAssets) {
        this.trainingAssets = trainingAssets;
    }

    public Integer getYouth() {
        return youth;
    }

    public void setYouth(Integer youth) {
        this.youth = youth;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubNick() {
        return clubNick;
    }

    public void setClubNick(String clubNick) {
        this.clubNick = clubNick;
    }

    public Integer getYearFound() {
        return yearFound;
    }

    public void setYearFound(Integer yearFound) {
        this.yearFound = yearFound;
    }

    public Integer getMorale() {
        return morale;
    }

    public void setMorale(Integer morale) {
        this.morale = morale;
    }

    public Integer getClubReputation() {
        return clubReputation;
    }

    public void setClubReputation(Integer clubReputation) {
        this.clubReputation = clubReputation;
    }

    public String getColours() {
        return colours;
    }

    public void setColours(String colours) {
        this.colours = colours;
    } 

    public Club getSelectedClub() {
        return selectedClub;
    }

    public void setSelectedClub(Club selectedClub) {
        this.selectedClub = selectedClub;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public List<Integer> getIt() {
        return it;
    }
    
    
}
