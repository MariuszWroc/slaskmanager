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
import pl.mariuszczarny.slask2014.dao.impl.FinanceDao;
import pl.mariuszczarny.slask2014.model.Finance;
import pl.mariuszczarny.slask2014.service.IFinanceService;

/**
 *
 * @author Mariusz
 */
@Service("financeService")
@Transactional(readOnly = true)
public class FinanceService implements IFinanceService{
    
    @Autowired
    FinanceDao financeDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Finance finance) {
        getFinanceDao().add(finance);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Finance finance) {
        getFinanceDao().delete(finance);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Finance finance) {
        getFinanceDao().update(finance);
    }

    @Override
    public Finance findById(Long id) {
        return getFinanceDao().findById(id);
    }

    @Override
    public List<Finance> findAllByCriteria() {
        return getFinanceDao().findAllByCriteria();
    }

    public FinanceDao getFinanceDao() {
        return financeDao;
    }

    public void setFinanceDao(FinanceDao financeDao) {
        this.financeDao = financeDao;
    }
    
}
