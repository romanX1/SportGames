package com.sportgames.service.impl;

import com.sportgames.dao.UserDAO;
import com.sportgames.model.User;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO dao;
    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); //new BCryptPasswordEncoder();


    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public User findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<User> getUsersByEventTime(String timeEvent) {
        return dao.getUsersByEventTime(timeEvent);
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return dao.findByLogin(s);
      
    @Override
    public List<User> getUsersByEventId(Long eventId) {
        return dao.getUsersByEventId(eventId);
    }
}
