/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.service;

import java.util.List;
import pl.mariuszczarny.slask2014.model.Game;
import pl.mariuszczarny.slask2014.model.User;

/**
 *
 * @author Mariusz
 */
public interface IGameService {
     void add(Game game);

     void delete(Game game);

     void update(Game game);

     Game findById(Long id);

     List<Game> findAllByCriteria();
     
     List<Game> findAllByUser(User user);
}
