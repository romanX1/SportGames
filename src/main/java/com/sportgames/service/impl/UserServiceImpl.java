package com.sportgames.service.impl;

import com.sportgames.dao.EventDAO;
import com.sportgames.dao.UserDAO;
import com.sportgames.model.User;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    private final UserDAO dao;

    @Autowired
    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAll() {
        return dao.findAll();
    }

    @Override
    public void add(User user) {
        dao.saveAndFlush(user);
    }

    @Override
    public User findById(Long id) {
        return dao.findUserById(id);
    }

    @Override
    public User findByName(String name) {
        return dao.findByLogin(name);
    }

    @Override
    public List<User> getUsersByEventTime(String timeEvent) {
        return null;
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public List<User> getUsersByEventId(Long eventId) {
        return dao.getUsersById(eventId);
    }
}
