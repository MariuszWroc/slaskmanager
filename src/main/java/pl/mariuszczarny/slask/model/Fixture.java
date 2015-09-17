/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.model;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mariusz
 */
@Entity
@Table(name = "fixture")
@NamedQueries({
    @NamedQuery(name = "Fixture.findAll", query = "SELECT f FROM Fixture f"),
    @NamedQuery(name = "Fixture.findByIdFixture", query = "SELECT f FROM Fixture f WHERE f.id = :id"),
    @NamedQuery(name = "Fixture.findBySeasonYear", query = "SELECT f FROM Fixture f WHERE f.seasonYear = :seasonYear")})
public class Fixture extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "SeasonYear")
    private Integer seasonYear;
    
    @JoinColumn(name = "tournament_idTournament", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tournament tournamentidTournament;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fixtureidFixture", fetch = FetchType.LAZY)
    private List<Arrange> arrangeList;

    public Fixture() {
    }

    public Fixture(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(Integer seasonYear) {
        this.seasonYear = seasonYear;
    }

    public Tournament getTournamentidTournament() {
        return tournamentidTournament;
    }

    public void setTournamentidTournament(Tournament tournamentidTournament) {
        this.tournamentidTournament = tournamentidTournament;
    }

    public List<Arrange> getArrangeList() {
        return arrangeList;
    }

    public void setArrangeList(List<Arrange> arrangeList) {
        this.arrangeList = arrangeList;
    }
    
}
