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
@Table(name = "training")
@NamedQueries({
    @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t"),
    @NamedQuery(name = "Training.findByIdTraining", query = "SELECT t FROM Training t WHERE t.id = :idTraining"),
    @NamedQuery(name = "Training.findByTrainingName", query = "SELECT t FROM Training t WHERE t.trainingName = :trainingName")})
public class Training extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Size(max = 45)
    @Column(name = "TrainingName")
    private String trainingName;
    
    @Column(name = "Pace")
    private Boolean pace;
    
    @Column(name = "Strength")
    private Boolean strength;
    
    @Column(name = "Stamina")
    private Boolean stamina;
    
    @Column(name = "SetPieces")
    private Boolean setPieces;
    
    @Column(name = "Technique")
    private Boolean technique;
    
    @Column(name = "Finishing")
    private Boolean finishing;
    
    @Column(name = "Passing")
    private Boolean passing;
    
    @Column(name = "Marking")
    private Boolean marking;
    
    @Column(name = "Tackling")
    private Boolean tackling;
    
    @Column(name = "Heading")
    private Boolean heading;
    
    @Column(name = "Reflex")
    private Boolean reflex;
    
    @Column(name = "Handling")
    private Boolean handling;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingidTraining", fetch = FetchType.LAZY)
    private List<Club> clubList;

    public Training() {
    }

    public Training(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public Boolean getPace() {
        return pace;
    }

    public void setPace(Boolean pace) {
        this.pace = pace;
    }

    public Boolean getStrength() {
        return strength;
    }

    public void setStrength(Boolean strength) {
        this.strength = strength;
    }

    public Boolean getStamina() {
        return stamina;
    }

    public void setStamina(Boolean stamina) {
        this.stamina = stamina;
    }

    public Boolean getSetPieces() {
        return setPieces;
    }

    public void setSetPieces(Boolean setPieces) {
        this.setPieces = setPieces;
    }

    public Boolean getTechnique() {
        return technique;
    }

    public void setTechnique(Boolean technique) {
        this.technique = technique;
    }

    public Boolean getFinishing() {
        return finishing;
    }

    public void setFinishing(Boolean finishing) {
        this.finishing = finishing;
    }

    public Boolean getPassing() {
        return passing;
    }

    public void setPassing(Boolean passing) {
        this.passing = passing;
    }

    public Boolean getMarking() {
        return marking;
    }

    public void setMarking(Boolean marking) {
        this.marking = marking;
    }

    public Boolean getTackling() {
        return tackling;
    }

    public void setTackling(Boolean tackling) {
        this.tackling = tackling;
    }

    public Boolean getHeading() {
        return heading;
    }

    public void setHeading(Boolean heading) {
        this.heading = heading;
    }

    public Boolean getReflex() {
        return reflex;
    }

    public void setReflex(Boolean reflex) {
        this.reflex = reflex;
    }

    public Boolean getHandling() {
        return handling;
    }

    public void setHandling(Boolean handling) {
        this.handling = handling;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }
    
    public void setByString(String set)
    {
        if(set.equals("Pace"))
            setPace(Boolean.TRUE);
        if(set.equals("Strength"))
            setStrength(Boolean.TRUE);
        if(set.equals("Stamina"))
            setStamina(Boolean.TRUE);
        if(set.equals("SetPieces"))
            setSetPieces(Boolean.TRUE);
        if(set.equals("Technique"))
            setTechnique(Boolean.TRUE);
        if(set.equals("Finishing"))
            setFinishing(Boolean.TRUE);
        if(set.equals("Passing"))
            setPassing(Boolean.TRUE);
        if(set.equals("Marking"))
            setMarking(Boolean.TRUE);
        if(set.equals("Tackling"))
            setTackling(Boolean.TRUE);
        if(set.equals("Heading"))
            setHeading(Boolean.TRUE);
        if(set.equals("Reflex"))
            setReflex(Boolean.TRUE);
        if(set.equals("Handling"))
            setHandling(Boolean.TRUE);
    }
}
