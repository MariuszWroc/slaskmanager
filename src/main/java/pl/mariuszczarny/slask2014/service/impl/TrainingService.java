/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import pl.mariuszczarny.slask2014.dao.impl.TrainingDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszczarny.slask2014.model.Training;
import pl.mariuszczarny.slask2014.service.ITrainingService;

/**
 *
 * @author Mariusz
 */
@Service("trainingService")
@Transactional(readOnly = true)
public class TrainingService implements ITrainingService{
    
    @Autowired
    TrainingDao trainingDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Training training) {
        getTrainingDao().add(training);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Training training) {
        getTrainingDao().delete(training);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Training training) {
        getTrainingDao().update(training);
    }

    @Override
    public Training findById(Long id) {
        return getTrainingDao().findById(id);
    }

    @Override
    public List<Training> findAllByCriteria() {
        return getTrainingDao().findAllByCriteria();
    }

    public TrainingDao getTrainingDao() {
        return trainingDao;
    }

    public void setTrainingDao(TrainingDao trainingDao) {
        this.trainingDao = trainingDao;
    }

}
