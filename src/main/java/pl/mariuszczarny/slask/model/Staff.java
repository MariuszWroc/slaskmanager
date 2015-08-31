/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mariusz
 */
@Entity
@Table(name = "staff")
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByIdStaff", query = "SELECT s FROM Staff s WHERE s.id = :idStaff"),
    @NamedQuery(name = "Staff.findByStaffFunction", query = "SELECT s FROM Staff s WHERE s.staffFunction = :staffFunction")})
public class Staff extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Size(max = 45)
    @Column(name = "StaffFunction")
    private String staffFunction;
    
    @JoinColumn(name = "club_idClub", referencedColumnName = "idClub")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Club clubidClub;
    
    @JoinColumn(name = "person_idPerson", referencedColumnName = "idPerson")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person personidPerson;

    public Staff() {
    }

    public Staff(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffFunction() {
        return staffFunction;
    }

    public void setStaffFunction(String staffFunction) {
        this.staffFunction = staffFunction;
    }

    public Club getClubidClub() {
        return clubidClub;
    }

    public void setClubidClub(Club clubidClub) {
        this.clubidClub = clubidClub;
    }

    public Person getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(Person personidPerson) {
        this.personidPerson = personidPerson;
    }
    
}
