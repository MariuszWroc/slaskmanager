/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mariuszczarny.slask.dao.impl.ContractDao;
import pl.mariuszczarny.slask.model.Contract;
import pl.mariuszczarny.slask.service.IContractService;

/**
 *
 * @author Mariusz
 */
@Service("contractService")
@Transactional(readOnly = true)
public class ContractService implements IContractService{
    
    @Autowired
    ContractDao contractDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Contract contract) {
        getContractDao().add(contract);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Contract contract) {
        getContractDao().delete(contract);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Contract contract) {
        getContractDao().update(contract);
    }

    @Override
    public Contract findById(Long id) {
        return getContractDao().findById(id);
    }

    @Override
    public List<Contract> findAllByCriteria() {
        return getContractDao().findAllByCriteria();
    }

    public ContractDao getContractDao() {
        return contractDao;
    }

    public void setContractDao(ContractDao contractDao) {
        this.contractDao = contractDao;
    }

    @Override
    public List<Contract> findByClub(Long id) {
        return getContractDao().findByClub(id);
    }
}
