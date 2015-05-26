/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.dao;

import java.util.List;
import pl.mariuszczarny.slask.model.Coach;

/**
 *
 * @author Mariusz
 */
public interface ICoachDao extends IGenericDao<Coach>{   
     List<Coach> findCoachAndPerson();
}
