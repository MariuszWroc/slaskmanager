/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.model;

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
@Table(name="role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByIdRole", query = "SELECT r FROM Role r WHERE r.id = :idRole"),
    @NamedQuery(name = "Role.findByRolename", query = "SELECT r FROM Role r WHERE r.rolename = :rolename")})
public class Role extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRole", nullable = false)
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String rolename;
    
    @JoinColumn(name = "user_idUser", referencedColumnName = "idUser")
    @ManyToOne(fetch = FetchType.LAZY)
    private User useridUser;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public User getUseridUser() {
        return useridUser;
    }

    public void setUseridUser(User useridUser) {
        this.useridUser = useridUser;
    }
    
}
