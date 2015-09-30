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
@Table(name = "referee")
@NamedQueries({
    @NamedQuery(name = "Referee.findAll", query = "SELECT r FROM Referee r"),
    @NamedQuery(name = "Referee.findByIdReferee", query = "SELECT r FROM Referee r WHERE r.id = :id")})
public class Referee extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "Refereeing")
    private Integer refereeing;
    
    @Column(name = "Punishing")
    private Integer punishing;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refereeidReferee", fetch = FetchType.LAZY)
    private List<Arrange> arrangeList;
    
    @JoinColumn(name = "person_idPerson", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person personidPerson;

    public Referee() {
    }

    public Referee(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRefereeing() {
        return refereeing;
    }

    public void setRefereeing(Integer refereeing) {
        this.refereeing = refereeing;
    }

    public Integer getPunishing() {
        return punishing;
    }

    public void setPunishing(Integer punishing) {
        this.punishing = punishing;
    }

    public List<Arrange> getArrangeList() {
        return arrangeList;
    }

    public void setArrangeList(List<Arrange> arrangeList) {
        this.arrangeList = arrangeList;
    }

    public Person getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(Person personidPerson) {
        this.personidPerson = personidPerson;
    }
    
    @Override
    public String toString() {
        return id + "|" + refereeing;
    }
}
