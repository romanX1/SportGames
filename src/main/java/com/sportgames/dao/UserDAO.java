package com.sportgames.dao;


import com.sportgames.model.User;

import java.util.List;

public interface UserDAO {
    User findById(Long id);
    List<User> getAll();
    void add(User user);
    void delete(Long id);
    User findByName(String name);
}
