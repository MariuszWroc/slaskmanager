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
@Table(name = "tournament")
@NamedQueries({
    @NamedQuery(name = "Tournament.findAll", query = "SELECT t FROM Tournament t"),
    @NamedQuery(name = "Tournament.findByIdTournament", query = "SELECT t FROM Tournament t WHERE t.id = :idTournament"),
    @NamedQuery(name = "Tournament.findByTournamentName", query = "SELECT t FROM Tournament t WHERE t.tournamentName = :tournamentName")})
public class Tournament extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTournament", nullable = false)
    private Long id;
    
    @Size(max = 45)
    @Column(name = "TournamentName")
    private String tournamentName;
    
    @Column(name = "TournamentReputation")
    private Integer tournamentReputation;
    
    @Column(name = "TeamsNumber")
    private Integer teamsNumber;
    
    @Column(name = "RelegatesNumber")
    private Integer relegatesNumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tournamentidTournament", fetch = FetchType.LAZY)
    private List<Fixture> fixtureList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tournamentidTournament", fetch = FetchType.LAZY)
    private List<Club> clubList;

    public Tournament() {
    }

    public Tournament(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Fixture> getFixtureList() {
        return fixtureList;
    }

    public void setFixtureList(List<Fixture> fixtureList) {
        this.fixtureList = fixtureList;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }
    
}
