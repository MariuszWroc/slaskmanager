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
@Table(name = "tactic")
@NamedQueries({
    @NamedQuery(name = "Tactic.findAll", query = "SELECT t FROM Tactic t"),
    @NamedQuery(name = "Tactic.findByIdTactic", query = "SELECT t FROM Tactic t WHERE t.id = :idTactic"),
    @NamedQuery(name = "Tactic.findByTacticName", query = "SELECT t FROM Tactic t WHERE t.tacticName = :tacticName")})
public class Tactic extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "Attack")
    private Integer attack;
    
    @Column(name = "Marking")
    private Integer marking;
    
    @Column(name = "Offside")
    private Integer offside;
    
    @Column(name = "Pressing")
    private Integer pressing;
    
    @Column(name = "Tempo")
    private Integer tempo;
    
    @Column(name = "PlayWide")
    private Integer playWide;
    
    @Column(name = "PlayHigh")
    private Integer playHigh;
    
    @Column(name = "Flair")
    private Integer flair;
    
    @Column(name = "LongPass")
    private Integer longPass;
    
    @Column(name = "PlayToDefenders")
    private Integer playToDefenders;
    
    @Size(max = 45)
    @Column(name = "TacticName")
    private String tacticName;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tacticidTactic", fetch = FetchType.EAGER)
    private List<Formation> formationList;

    public Tactic() {
    }

    public Tactic(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getMarking() {
        return marking;
    }

    public void setMarking(Integer marking) {
        this.marking = marking;
    }

    public Integer getOffside() {
        return offside;
    }

    public void setOffside(Integer offside) {
        this.offside = offside;
    }

    public Integer getPressing() {
        return pressing;
    }

    public void setPressing(Integer pressing) {
        this.pressing = pressing;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Integer getPlayWide() {
        return playWide;
    }

    public void setPlayWide(Integer playWide) {
        this.playWide = playWide;
    }

    public Integer getPlayHigh() {
        return playHigh;
    }

    public void setPlayHigh(Integer playHigh) {
        this.playHigh = playHigh;
    }

    public Integer getFlair() {
        return flair;
    }

    public void setFlair(Integer flair) {
        this.flair = flair;
    }

    public Integer getLongPass() {
        return longPass;
    }

    public void setLongPass(Integer longPass) {
        this.longPass = longPass;
    }

    public Integer getPlayToDefenders() {
        return playToDefenders;
    }

    public void setPlayToDefenders(Integer playToDefenders) {
        this.playToDefenders = playToDefenders;
    }

    public String getTacticName() {
        return tacticName;
    }

    public void setTacticName(String tacticName) {
        this.tacticName = tacticName;
    }

    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
    }
    
}
