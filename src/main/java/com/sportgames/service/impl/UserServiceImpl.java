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

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
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

    @Override
    public Map.Entry<User, Long> findFamousUser() {
        List<User> userList = dao.findAll();
        Map<User, Long> userLongMap = new HashMap<>();
        for (User user : userList) {
            userLongMap.put(user, dao.countUserInEvents(user.getId()));
        }
        Map.Entry<User, Long> userCountMapEntry = userLongMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .findFirst()
                .get();

        return userCountMapEntry;
    }

    @Override
    public Long countUsers() {
        return dao.count();
    }

}
