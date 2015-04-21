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
import javax.validation.constraints.Size;

/**
 *
 * @author Mariusz
 */
@Entity
@Table(name = "city")
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findByIdCity", query = "SELECT c FROM City c WHERE c.id = :idCity"),
    @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")})
public class City extends AbstractEntity{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCity", nullable = false)
    private Long id;
    
    @Size(max = 45)
    @Column(name = "CityName")
    private String cityName;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityidCity", fetch = FetchType.LAZY)
    private List<Stadium> stadiumList;

    public City() {
    }

    public City(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Stadium> getStadiumList() {
        return stadiumList;
    }

    public void setStadiumList(List<Stadium> stadiumList) {
        this.stadiumList = stadiumList;
    }
    
}
