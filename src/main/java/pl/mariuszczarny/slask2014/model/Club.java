/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.model;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mariusz
 */
@Entity
@Table(name = "club")
@NamedQueries({
    @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
    @NamedQuery(name = "Club.findByIdClub", query = "SELECT c FROM Club c WHERE c.id = :idClub"),
    @NamedQuery(name = "Club.findByClubName", query = "SELECT c FROM Club c WHERE c.clubName = :clubName"),
    @NamedQuery(name = "Club.findByClubNick", query = "SELECT c FROM Club c WHERE c.clubNick = :clubNick")})
public class Club extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClub", nullable = false)
    private Long id;
    
    @Column(name = "AttendanceAvg")
    private Integer attendanceAvg;
    
    @Column(name = "AttendanceMin")
    private Integer attendanceMin;
    
    @Column(name = "AttendanceMax")
    private Integer attendanceMax;
    
    @Column(name = "TrainingAssets")
    private Integer trainingAssets;
    
    @Column(name = "Youth")
    private Integer youth;
    
    @Size(max = 45)
    @Column(name = "ClubName")
    private String clubName;
    
    @Size(max = 45)
    @Column(name = "ClubNick")
    private String clubNick;
    
    @Column(name = "YearFound")
    private Integer yearFound;
    
    @Column(name = "Morale")
    private Integer morale;
    
    @Column(name = "ClubReputation")
    private Integer clubReputation;
    
    @Size(max = 45)
    @Column(name = "Colours")
    private String colours;
    
    @Column(name = "PointsScored")
    private Integer pointsScored;
    
    @Column(name = "GoalsScored")
    private Integer goalsScored;
    
    @Column(name = "GoalsLost")
    private Integer goalsLost;
    
    @Column(name = "YellowCards")
    private Integer yellowCards;
    
    @Column(name = "RedCards")
    private Integer redCards;
    
    @JoinTable(name = "club_has_arrange", joinColumns = {
        @JoinColumn(name = "club_idClub", referencedColumnName = "idClub")}, inverseJoinColumns = {
        @JoinColumn(name = "arrange_idArrange", referencedColumnName = "idArrange")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Arrange> arrangeList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubidClub", fetch = FetchType.LAZY)
    private List<Contract> contractList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubidClub", fetch = FetchType.LAZY)
    private List<Staff> staffList;
    
    @JoinColumn(name = "formation_idFormation", referencedColumnName = "idFormation")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Formation formationidFormation;
    
    @JoinColumn(name = "training_idTraining", referencedColumnName = "idTraining")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Training trainingidTraining;
    
    @JoinColumn(name = "stadium_idStadium", referencedColumnName = "idStadium")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Stadium stadiumidStadium;
    
    @JoinColumn(name = "tournament_idTournament", referencedColumnName = "idTournament")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tournament tournamentidTournament;
    
    @JoinColumn(name = "finance_idFinance", referencedColumnName = "idFinance")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Finance financeidFinance;
    
    @JoinColumn(name = "coach_idCoach", referencedColumnName = "idCoach")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Coach coachidCoach;

    public Club() {
    }

    public Club(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public Integer getPointsScored() {
		return pointsScored;
	}

	public void setPointsScored(Integer pointsScored) {
		this.pointsScored = pointsScored;
	}

	public Integer getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(Integer goalsScored) {
		this.goalsScored = goalsScored;
	}

	public Integer getGoalsLost() {
		return goalsLost;
	}

	public void setGoalsLost(Integer goalsLost) {
		this.goalsLost = goalsLost;
	}

	public Integer getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(Integer yellowCards) {
		this.yellowCards = yellowCards;
	}

	public Integer getRedCards() {
		return redCards;
	}

	public void setRedCards(Integer redCards) {
		this.redCards = redCards;
	}

	public List<Arrange> getArrangeList() {
        return arrangeList;
    }

    public void setArrangeList(List<Arrange> arrangeList) {
        this.arrangeList = arrangeList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public Formation getFormationidFormation() {
        return formationidFormation;
    }

    public void setFormationidFormation(Formation formationidFormation) {
        this.formationidFormation = formationidFormation;
    }

    public Training getTrainingidTraining() {
        return trainingidTraining;
    }

    public void setTrainingidTraining(Training trainingidTraining) {
        this.trainingidTraining = trainingidTraining;
    }

    public Stadium getStadiumidStadium() {
        return stadiumidStadium;
    }

    public void setStadiumidStadium(Stadium stadiumidStadium) {
        this.stadiumidStadium = stadiumidStadium;
    }

    public Tournament getTournamentidTournament() {
        return tournamentidTournament;
    }

    public void setTournamentidTournament(Tournament tournamentidTournament) {
        this.tournamentidTournament = tournamentidTournament;
    }

    public Finance getFinanceidFinance() {
        return financeidFinance;
    }

    public void setFinanceidFinance(Finance financeidFinance) {
        this.financeidFinance = financeidFinance;
    }

    public Coach getCoachidCoach() {
        return coachidCoach;
    }

    public void setCoachidCoach(Coach coachidCoach) {
        this.coachidCoach = coachidCoach;
    }
}
