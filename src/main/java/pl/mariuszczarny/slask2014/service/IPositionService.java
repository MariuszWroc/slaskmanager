package pl.mariuszczarny.slask2014.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import pl.mariuszczarny.slask2014.model.Position;

/**
 *
 * @author Mariusz
 */
public interface IPositionService {
     void add(Position position);

     void delete(Position position);

     void update(Position position);

     Position findById(Long id);

     List<Position> findAllByCriteria();
}
