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
@Table(name = "coach")
@NamedQueries({
    @NamedQuery(name = "Coach.findAll", query = "SELECT c FROM Coach c"),
    @NamedQuery(name = "Coach.findByIdCoach", query = "SELECT c FROM Coach c WHERE c.id = :idCoach")})
public class Coach extends AbstractEntity{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCoach", nullable = false)
    private Long id;
    
    @Column(name = "TacticalKnowledge")
    private Integer tacticalKnowledge;
    
    @Column(name = "TreningMental")
    private Integer treningMental;
   
    @Column(name = "TreningTactic")
    private Integer treningTactic;
    
    @Column(name = "TreningTechnique")
    private Integer treningTechnique;
    
    @Column(name = "Motivating")
    private Integer motivating;
    
    @Column(name = "Management")
    private Integer management;
    
    @Column(name = "Discipline")
    private Integer discipline;
    
    @Column(name = "SkillRate")
    private Integer skillRate;
    
    @JoinColumn(name = "person_idPerson", referencedColumnName = "idPerson")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person personidPerson;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coachidCoach", fetch = FetchType.LAZY)
    private List<Club> clubList;

    public Coach() {
    }

    public Coach(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTacticalKnowledge() {
        return tacticalKnowledge;
    }

    public void setTacticalKnowledge(Integer tacticalKnowledge) {
        this.tacticalKnowledge = tacticalKnowledge;
    }

    public Integer getTreningMental() {
        return treningMental;
    }

    public void setTreningMental(Integer treningMental) {
        this.treningMental = treningMental;
    }

    public Integer getTreningTactic() {
        return treningTactic;
    }

    public void setTreningTactic(Integer treningTactic) {
        this.treningTactic = treningTactic;
    }

    public Integer getTreningTechnique() {
        return treningTechnique;
    }

    public void setTreningTechnique(Integer treningTechnique) {
        this.treningTechnique = treningTechnique;
    }

    public Integer getMotivating() {
        return motivating;
    }

    public void setMotivating(Integer motivating) {
        this.motivating = motivating;
    }

    public Integer getManagement() {
        return management;
    }

    public void setManagement(Integer management) {
        this.management = management;
    }

    public Integer getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Integer discipline) {
        this.discipline = discipline;
    }

    public Integer getSkillRate() {
        return skillRate;
    }

    public void setSkillRate(Integer skillRate) {
        this.skillRate = skillRate;
    }

    public Person getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(Person personidPerson) {
        this.personidPerson = personidPerson;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }
    
}
