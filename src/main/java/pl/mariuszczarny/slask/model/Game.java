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
@Table(name = "game")
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findByIdGame", query = "SELECT g FROM Game g WHERE g.id = :idGame"),
    @NamedQuery(name = "Game.findByGameCode", query = "SELECT g FROM Game g WHERE g.gameCode = :gameCode"),
    @NamedQuery(name = "Game.findBySessionId", query = "SELECT g FROM Game g WHERE g.sessionId = :sessionId"),
    @NamedQuery(name = "Game.findByUserStatus", query = "SELECT g FROM Game g WHERE g.userStatus = :userStatus")})
public class Game extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGame", nullable = false)
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_code")
    private Integer gameCode;
    
    @Size(max = 45)
    @Column(name = "session_id")
    private String sessionId;
    
    @Size(max = 45)
    @Column(name = "game_name")
    private String gameName;
    
    @Column(name = "user_status")
    private Boolean userStatus;
    
    @JoinColumn(name = "club_idClub", referencedColumnName = "idClub")
    @ManyToOne(fetch = FetchType.EAGER)
    private Club clubidClub;
    
    @JoinColumn(name = "user_idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User useridUser;

    public Game() {
    }

    public Game(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGameCode() {
        return gameCode;
    }

    public void setGameCode(Integer gameCode) {
        this.gameCode = gameCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    public Club getClubidClub() {
        return clubidClub;
    }

    public void setClubidClub(Club clubidClub) {
        this.clubidClub = clubidClub;
    }

    public User getUseridUser() {
        return useridUser;
    }

    public void setUseridUser(User useridUser) {
        this.useridUser = useridUser;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
