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
@Table(name = "stadium")
@NamedQueries({
    @NamedQuery(name = "Stadium.findAll", query = "SELECT s FROM Stadium s"),
    @NamedQuery(name = "Stadium.findByIdStadium", query = "SELECT s FROM Stadium s WHERE s.id = :idStadium"),
    @NamedQuery(name = "Stadium.findByStadiumName", query = "SELECT s FROM Stadium s WHERE s.stadiumName = :stadiumName")})
public class Stadium extends AbstractEntity{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Size(max = 45)
    @Column(name = "StadiumName")
    private String stadiumName;
    
    @Column(name = "SitsNumber")
    private Integer sitsNumber;
    
    @Column(name = "YearBuild")
    private Integer yearBuild;
    
    @Column(name = "Modernity")
    private Integer modernity;
    
    @Column(name = "FieldWidth")
    private Integer fieldWidth;
    
    @Column(name = "FieldHeight")
    private Integer fieldHeight;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadiumidStadium", fetch = FetchType.LAZY)
    private List<Club> clubList;
    
    @JoinColumn(name = "city_idCity", referencedColumnName = "idCity")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private City cityidCity;

    public Stadium() {
    }

    public Stadium(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Integer getSitsNumber() {
        return sitsNumber;
    }

    public void setSitsNumber(Integer sitsNumber) {
        this.sitsNumber = sitsNumber;
    }

    public Integer getYearBuild() {
        return yearBuild;
    }

    public void setYearBuild(Integer yearBuild) {
        this.yearBuild = yearBuild;
    }

    public Integer getModernity() {
        return modernity;
    }

    public void setModernity(Integer modernity) {
        this.modernity = modernity;
    }

    public Integer getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth(Integer fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    public Integer getFieldHeight() {
        return fieldHeight;
    }

    public void setFieldHeight(Integer fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

    public City getCityidCity() {
        return cityidCity;
    }

    public void setCityidCity(City cityidCity) {
        this.cityidCity = cityidCity;
    }
    
}
