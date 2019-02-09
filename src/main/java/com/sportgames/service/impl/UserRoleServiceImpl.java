package com.sportgames.service.impl;

import com.sportgames.dao.UserDAO;
import com.sportgames.dao.UserRoleDAO;
import com.sportgames.model.UserRole;
import com.sportgames.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDAO dao;

    @Override
    public void add(UserRole userRole) {
        dao.saveAndFlush(userRole);
    }

    @Override
    public void delete(UserRole userRole) {
        dao.delete(userRole);

    }

    @Override
    public UserRole findByAuthority(String authority) {
        return dao.findByAuthority(authority);
    }

    @Override
    public List<UserRole> gelAll() {
        return dao.findAll();
    }
}
