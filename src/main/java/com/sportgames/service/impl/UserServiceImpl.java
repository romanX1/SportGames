package com.sportgames.service.impl;

import com.sportgames.dao.UserDAO;
import com.sportgames.model.User;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO dao;


    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }
}