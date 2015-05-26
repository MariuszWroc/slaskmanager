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
import pl.mariuszczarny.slask.dao.impl.RoleDao;
import pl.mariuszczarny.slask.model.Role;
import pl.mariuszczarny.slask.service.IRoleService;

/**
 *
 * @author Mariusz
 */
@Service("roleService")
@Transactional(readOnly = true)
public class RoleService implements IRoleService{
    @Autowired
    RoleDao roleDao;

    @Transactional(readOnly = false)
    @Override
    public void add(Role role) {
        getRoleDao().add(role);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Role role) {
        getRoleDao().delete(role);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Role role) {
        getRoleDao().update(role);
    }

    @Override
    public Role findById(Long id) {
        return getRoleDao().findById(id);
    }

    @Override
    public List<Role> findAllByCriteria() {
        return getRoleDao().findAllByCriteria();
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

}
