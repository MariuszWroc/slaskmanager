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

/**
 *
 * @author Mariusz
 */
@Entity
@Table(name = "position")
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p"),
    @NamedQuery(name = "Position.findByIdPosition", query = "SELECT p FROM Position p WHERE p.id = :idPosition")})
public class Position extends AbstractEntity{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPosition", nullable = false)
    private Long id;
    
    @Column(name = "Goalkeeper")
    private Integer goalkeeper;
    
    @Column(name = "DefenderLeft")
    private Integer defenderLeft;
    
    @Column(name = "DefenderCenter")
    private Integer defenderCenter;
    
    @Column(name = "DefenderRight")
    private Integer defenderRight;
    
    @Column(name = "MidfieldDef")
    private Integer midfieldDef;
    
    @Column(name = "MidfieldRight")
    private Integer midfieldRight;
    
    @Column(name = "MidfieldLeft")
    private Integer midfieldLeft;
    
    @Column(name = "MidfieldCenter")
    private Integer midfieldCenter;
    
    @Column(name = "WingerLeft")
    private Integer wingerLeft;
    
    @Column(name = "WingerRight")
    private Integer wingerRight;
    
    @Column(name = "Forward")
    private Integer forward;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "positionidPosition", fetch = FetchType.LAZY)
    private List<Player> playerList;

    public Position() {
    }

    public Position(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoalkeeper() {
        return goalkeeper;
    }

    public void setGoalkeeper(Integer goalkeeper) {
        this.goalkeeper = goalkeeper;
    }

    public Integer getDefenderLeft() {
        return defenderLeft;
    }

    public void setDefenderLeft(Integer defenderLeft) {
        this.defenderLeft = defenderLeft;
    }

    public Integer getDefenderCenter() {
        return defenderCenter;
    }

    public void setDefenderCenter(Integer defenderCenter) {
        this.defenderCenter = defenderCenter;
    }

    public Integer getDefenderRight() {
        return defenderRight;
    }

    public void setDefenderRight(Integer defenderRight) {
        this.defenderRight = defenderRight;
    }

    public Integer getMidfieldDef() {
        return midfieldDef;
    }

    public void setMidfieldDef(Integer midfieldDef) {
        this.midfieldDef = midfieldDef;
    }

    public Integer getMidfieldRight() {
        return midfieldRight;
    }

    public void setMidfieldRight(Integer midfieldRight) {
        this.midfieldRight = midfieldRight;
    }

    public Integer getMidfieldLeft() {
        return midfieldLeft;
    }

    public void setMidfieldLeft(Integer midfieldLeft) {
        this.midfieldLeft = midfieldLeft;
    }

    public Integer getMidfieldCenter() {
        return midfieldCenter;
    }

    public void setMidfieldCenter(Integer midfieldCenter) {
        this.midfieldCenter = midfieldCenter;
    }

    public Integer getWingerLeft() {
        return wingerLeft;
    }

    public void setWingerLeft(Integer wingerLeft) {
        this.wingerLeft = wingerLeft;
    }

    public Integer getWingerRight() {
        return wingerRight;
    }

    public void setWingerRight(Integer wingerRight) {
        this.wingerRight = wingerRight;
    }

    public Integer getForward() {
        return forward;
    }

    public void setForward(Integer forward) {
        this.forward = forward;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
    
}
