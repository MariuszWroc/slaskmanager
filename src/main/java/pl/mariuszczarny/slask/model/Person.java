/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mariusz
 */
@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findBySurname", query = "SELECT p FROM Person p WHERE p.surname = :surname"),
    @NamedQuery(name = "Person.findByNation", query = "SELECT p FROM Person p WHERE p.nation = :nation")})
public class Person extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    
    @Size(max = 45)
    @Column(name = "Surname")
    private String surname;
    
    @Column(name = "BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    @Size(max = 45)
    @Column(name = "Nation")
    private String nation;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personidPerson", fetch = FetchType.LAZY)
    private List<Player> playerList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personidPerson", fetch = FetchType.LAZY)
    private List<Coach> coachList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personidPerson", fetch = FetchType.LAZY)
    private List<Staff> staffList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personidPerson", fetch = FetchType.LAZY)
    private List<Referee> refereeList;

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Coach> getCoachList() {
        return coachList;
    }

    public void setCoachList(List<Coach> coachList) {
        this.coachList = coachList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Referee> getRefereeList() {
        return refereeList;
    }

    public void setRefereeList(List<Referee> refereeList) {
        this.refereeList = refereeList;
    }
    
    @Override
    public String toString() {
        return id + "|" + name + "|" + surname + "|" + birthDate + "|" +  nation;
    }
}
