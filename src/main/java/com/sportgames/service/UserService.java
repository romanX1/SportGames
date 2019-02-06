package com.sportgames.service;

import com.sportgames.model.Playground;
import com.sportgames.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void add(User user);
    User findById(Long id);
    List<User> getUsersByEventTime(String timeEvent);

    List<User> getUsersByEventId(Long eventId);
}