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
@Table(name = "finance")
@NamedQueries({
    @NamedQuery(name = "Finance.findAll", query = "SELECT f FROM Finance f"),
    @NamedQuery(name = "Finance.findByIdFinance", query = "SELECT f FROM Finance f WHERE f.id = :idFinance")})
public class Finance extends AbstractEntity{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFinance", nullable = false)
    private Long id;
    
    @Column(name = "Budget")
    private Integer budget;
    
    @Column(name = "TransferBudget")
    private Integer transferBudget;
    
    @Column(name = "WageBudget")
    private Integer wageBudget;
    
    @Column(name = "StadiumCost")
    private Integer stadiumCost;
    
    @Column(name = "AvgTicketCost")
    private Integer avgTicketCost;
    
    @Column(name = "AvgSeasonTicketCost")
    private Integer avgSeasonTicketCost;
    
    @Column(name = "SeasonTicketsNumber")
    private Integer seasonTicketsNumber;
    
    @Column(name = "Dept")
    private Integer dept;
    
    @Column(name = "FromSponsors")
    private Integer fromSponsors;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "financeidFinance", fetch = FetchType.LAZY)
    private List<Club> clubList;

    public Finance() {
    }

    public Finance(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getTransferBudget() {
        return transferBudget;
    }

    public void setTransferBudget(Integer transferBudget) {
        this.transferBudget = transferBudget;
    }

    public Integer getWageBudget() {
        return wageBudget;
    }

    public void setWageBudget(Integer wageBudget) {
        this.wageBudget = wageBudget;
    }

    public Integer getStadiumCost() {
        return stadiumCost;
    }

    public void setStadiumCost(Integer stadiumCost) {
        this.stadiumCost = stadiumCost;
    }

    public Integer getAvgTicketCost() {
        return avgTicketCost;
    }

    public void setAvgTicketCost(Integer avgTicketCost) {
        this.avgTicketCost = avgTicketCost;
    }

    public Integer getAvgSeasonTicketCost() {
        return avgSeasonTicketCost;
    }

    public void setAvgSeasonTicketCost(Integer avgSeasonTicketCost) {
        this.avgSeasonTicketCost = avgSeasonTicketCost;
    }

    public Integer getSeasonTicketsNumber() {
        return seasonTicketsNumber;
    }

    public void setSeasonTicketsNumber(Integer seasonTicketsNumber) {
        this.seasonTicketsNumber = seasonTicketsNumber;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Integer getFromSponsors() {
        return fromSponsors;
    }

    public void setFromSponsors(Integer fromSponsors) {
        this.fromSponsors = fromSponsors;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }
    
}
