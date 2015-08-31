/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.model;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mariusz
 */
@Entity
@Table(name = "contract")
@NamedQueries({
    @NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c"),
    @NamedQuery(name = "Contract.findByIdContract", query = "SELECT c FROM Contract c WHERE c.id = :idContract"),
    @NamedQuery(name = "Contract.findByFee", query = "SELECT c FROM Contract c WHERE c.fee = :fee"),
    @NamedQuery(name = "Contract.findByWage", query = "SELECT c FROM Contract c WHERE c.wage = :wage"),
    @NamedQuery(name = "Contract.findByDateStart", query = "SELECT c FROM Contract c WHERE c.dateStart = :dateStart"),
    @NamedQuery(name = "Contract.findByDateEnd", query = "SELECT c FROM Contract c WHERE c.dateEnd = :dateEnd")})
public class Contract extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "Fee")
    private BigDecimal fee;
    
    @Column(name = "Wage")
    private BigDecimal wage;
    
    @Column(name = "DateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    
    @Column(name = "DateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    
    @JoinColumn(name = "club_idClub", referencedColumnName = "idClub")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Club clubidClub;
    
    @JoinColumn(name = "player_idPlayer", referencedColumnName = "idPlayer")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Player playeridPlayer;

    public Contract() {
    }

    public Contract(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Club getClubidClub() {
        return clubidClub;
    }

    public void setClubidClub(Club clubidClub) {
        this.clubidClub = clubidClub;
    }

    public Player getPlayeridPlayer() {
        return playeridPlayer;
    }

    public void setPlayeridPlayer(Player playeridPlayer) {
        this.playeridPlayer = playeridPlayer;
    }
    
}
