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
import javax.validation.constraints.Size;

/**
 *
 * @author Mariusz
 */
@Entity
@Table(name = "formation")
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f"),
    @NamedQuery(name = "Formation.findByIdFormation", query = "SELECT f FROM Formation f WHERE f.id = :idFormation"),
    @NamedQuery(name = "Formation.findByFormationName", query = "SELECT f FROM Formation f WHERE f.formationName = :formationName")})
public class Formation extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Size(max = 45)
    @Column(name = "FormationName")
    private String formationName;
    
    @Column(name = "DefendersNumber")
    private Integer defendersNumber;
    
    @Column(name = "MidfieldNumber")
    private Integer midfieldNumber;
    
    @Column(name = "ForwardNumber")
    private Integer forwardNumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formationidFormation", fetch = FetchType.LAZY)
    private List<Club> clubList;
    
    @JoinColumn(name = "tactic_idTactic", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tactic tacticidTactic;

    public Formation() {
    }

    public Formation(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public Integer getDefendersNumber() {
        return defendersNumber;
    }

    public void setDefendersNumber(Integer defendersNumber) {
        this.defendersNumber = defendersNumber;
    }

    public Integer getMidfieldNumber() {
        return midfieldNumber;
    }

    public void setMidfieldNumber(Integer midfieldNumber) {
        this.midfieldNumber = midfieldNumber;
    }

    public Integer getForwardNumber() {
        return forwardNumber;
    }

    public void setForwardNumber(Integer forwardNumber) {
        this.forwardNumber = forwardNumber;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

    public Tactic getTacticidTactic() {
        return tacticidTactic;
    }

    public void setTacticidTactic(Tactic tacticidTactic) {
        this.tacticidTactic = tacticidTactic;
    }
    
}
