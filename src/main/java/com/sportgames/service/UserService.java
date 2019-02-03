package com.sportgames.service;

import com.sportgames.model.Playground;
import com.sportgames.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void add(User user);
}

