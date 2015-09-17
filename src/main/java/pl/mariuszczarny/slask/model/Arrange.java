/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "arrange")
@NamedQueries({
    @NamedQuery(name = "Arrange.findAll", query = "SELECT a FROM Arrange a"),
    @NamedQuery(name = "Arrange.findByIdArrange", query = "SELECT a FROM Arrange a WHERE a.id = :id")})
public class Arrange extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "ArrangeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrangeDate;
    
    @ManyToMany(mappedBy = "arrangeList", fetch = FetchType.LAZY)
    private List<Club> clubList;
    
    @JoinColumn(name = "fixture_idFixture", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fixture fixtureidFixture;
    
    @JoinColumn(name = "referee_idReferee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Referee refereeidReferee;

    public Arrange() {
    }

    public Arrange(Long id) {
        this.id = id;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getArrangeDate() {
        return arrangeDate;
    }

    public void setArrangeDate(Date arrangeDate) {
        this.arrangeDate = arrangeDate;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

    public Fixture getFixtureidFixture() {
        return fixtureidFixture;
    }

    public void setFixtureidFixture(Fixture fixtureidFixture) {
        this.fixtureidFixture = fixtureidFixture;
    }

    public Referee getRefereeidReferee() {
        return refereeidReferee; 
    }

    public void setRefereeidReferee(Referee refereeidReferee) {
        this.refereeidReferee = refereeidReferee;
    }
    
}
