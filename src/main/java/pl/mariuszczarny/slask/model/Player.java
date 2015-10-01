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
@Table(name = "player")
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findByIdPlayer", query = "SELECT p FROM Player p WHERE p.id = :id")})
public class Player extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "CurrentForm")
    private Integer currentForm;
    
    @Column(name = "Reputation")
    private Integer reputation;
    
    @Column(name = "Potential")
    private Integer potential;
    
    @Column(name = "LegLeft")
    private Integer legLeft;
    
    @Column(name = "LegRight")
    private Integer legRight;
    
    @Column(name = "Determination")
    private Integer determination;

    @Column(name = "Dirtness")
    private Integer dirtness;

    @Column(name = "Influence")
    private Integer influence;

    @Column(name = "Injury")
    private Integer injury;

    @Column(name = "Pace")
    private Integer pace;

    @Column(name = "Strength")
    private Integer strength;
    
    @Column(name = "Stamina")
    private Integer stamina;
    
    @Column(name = "SetPieces")
    private Integer setPieces;
    
    @Column(name = "Technique")
    private Integer technique;
    
    @Column(name = "Finishing")
    private Integer finishing;
    
    @Column(name = "Passing")
    private Integer passing;
    
    @Column(name = "Marking")
    private Integer marking;
    
    @Column(name = "Tackling")
    private Integer tackling;
    
    @Column(name = "Heading")
    private Integer heading;
    
    @Column(name = "Reflex")
    private Integer reflex;
    
    @Column(name = "Handling")
    private Integer handling;
    
    @Column(name = "Weight")
    private Integer weight;
    
    @Column(name = "Height")
    private Integer height;
    
    @Size(max = 45)
    @Column(name = "BestPosition")
    private String bestPosition;
    
    @Size(max = 45)
    @Column(name = "BestPositionShort")
    private String bestPositionShort;
    
    @JoinColumn(name = "position_idPosition", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Position positionidPosition;
    
    @JoinColumn(name = "person_idPerson", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person personidPerson;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playeridPlayer", fetch = FetchType.LAZY)
    private List<Contract> contractList;

    public Player() {
    }

    public Player(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Position getPositionidPosition() {
        return positionidPosition;
    }

    public void setPositionidPosition(Position positionidPosition) {
        this.positionidPosition = positionidPosition;
    }

    public Person getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(Person personidPerson) {
        this.personidPerson = personidPerson;
    }

    public List<Contract> getContractList() {
        return contractList;
    }
    
    @Override
    public String toString() {
        return id + "|" + currentForm + "|" + reputation + "|" + potential + "|" + legLeft + "|" + legRight + "|" + 
                determination + "|" + dirtness + "|" + influence + "|" + injury + "|" + pace + "|" + strength +
                "|" + stamina + "|" + setPieces + "|" + technique + "|" + finishing + "|" + passing + "|" + marking + 
                "|" + tackling + "|" + heading + "|" + reflex + "|" + handling;
    }
}
