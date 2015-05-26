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
import pl.mariuszczarny.slask.dao.impl.StaffDao;
import pl.mariuszczarny.slask.model.Club;
import pl.mariuszczarny.slask.model.Staff;
import pl.mariuszczarny.slask.service.IStaffService;

/**
 *
 * @author Mariusz
 */
@Service("staffService")
@Transactional(readOnly = true)
public class StaffService implements IStaffService {

    @Autowired
    StaffDao staffDao;

    @Override
    @Transactional(readOnly = false)
    public void add(Staff staff) {
        getStaffDao().add(staff);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Staff staff) {
        getStaffDao().delete(staff);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Staff staff) {
        getStaffDao().update(staff);
    }

    @Override
    public Staff findById(Long id) {
        return getStaffDao().findById(id);
    }

    @Override
    public List<Staff> findAllByCriteria() {
        return getStaffDao().findAllByCriteria();
    }

    @Override
    public List<Staff> findStaffAndPerson() {
        return getStaffDao().findStaffAndPerson();
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public List<Staff> findStaffByClub(Club club) {
        return getStaffDao().findStaffByClub(club);
    }
    
}
