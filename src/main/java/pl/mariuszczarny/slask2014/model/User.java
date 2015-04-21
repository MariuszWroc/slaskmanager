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
 * @author Jacek
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.id = :idUser"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findBySname", query = "SELECT u FROM User u WHERE u.sname = :sname"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login")})
public class User extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUser", nullable = false)
    private Long id;
    
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    
    @Size(max = 40)
    @Column(name = "sname")
    private String sname;
    
    @Size(max = 50)
    @Column(name = "login")
    private String login;
    
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)    
    @NotNull
    @Column(name = "enabled")
    private Integer enabled;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useridUser", fetch = FetchType.LAZY)
    private List<Game> gameList;
    
    @OneToMany(mappedBy = "useridUser", fetch = FetchType.LAZY)
    private List<Role> roleList;

    public User() {
    }

    public User(Long id) {
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    
}
