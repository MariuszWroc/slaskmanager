/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszczarny.slask2014.dao.impl.PlayerDao;
import pl.mariuszczarny.slask2014.model.Player;
import pl.mariuszczarny.slask2014.service.IPlayerService;

/**
 *
 * @author Mariusz
 */
@Service("playerService")
@Transactional(readOnly = true)
public class PlayerService implements IPlayerService{
    
    @Autowired
    PlayerDao playerDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Player player) {
        getPlayerDao().add(player);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Player player) {
        getPlayerDao().delete(player);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Player player) {
        getPlayerDao().update(player);
    }

    @Override
    public Player findById(Long id) {
        return getPlayerDao().findById(id);
    }

    @Override
    public List<Player> findAllByCriteria() {
        return getPlayerDao().findAllByCriteria();
    }

    @Override
    public List<Player> findPlayerAndPerson() {
        return getPlayerDao().findPlayerAndPerson();
    }

    public PlayerDao getPlayerDao() {
        return playerDao;
    }

    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
    
}
