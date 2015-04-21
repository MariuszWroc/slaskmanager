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
import pl.mariuszczarny.slask2014.dao.impl.GameDao;
import pl.mariuszczarny.slask2014.model.Game;
import pl.mariuszczarny.slask2014.model.User;
import pl.mariuszczarny.slask2014.service.IGameService;

/**
 *
 * @author Mariusz
 */
@Service("gameService")
@Transactional(readOnly = true)
public class GameService implements IGameService{
    @Autowired
    GameDao gameDao;

    @Transactional(readOnly = false)
    @Override
    public void add(Game game) {
        getGameDao().add(game);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Game game) {
        getGameDao().delete(game);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Game game) {
        getGameDao().update(game);
    }

    @Override
    public Game findById(Long id) {
        return getGameDao().findById(id);
    }

    @Override
    public List<Game> findAllByCriteria() {
        return getGameDao().findAllByCriteria();
    }
    
    @Override
    public List<Game> findAllByUser(User user) {
        return getGameDao().findAllByUser(user);
    }

    public GameDao getGameDao() {
        return gameDao;
    }

    public void setGameDao(GameDao gameDao) {
        this.gameDao = gameDao;
    }

}
