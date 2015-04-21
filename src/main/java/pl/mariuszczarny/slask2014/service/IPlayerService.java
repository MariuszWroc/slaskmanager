package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Player;

/**
 *
 * @author Mariusz
 */
public interface IPlayerService {
     void add(Player player);

     void delete(Player player);

     void update(Player player);

     Player findById(Long id);

     List<Player> findAllByCriteria();
    
     List<Player> findPlayerAndPerson();
}
