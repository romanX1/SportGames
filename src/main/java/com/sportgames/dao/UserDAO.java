package com.sportgames.dao;


import com.sportgames.model.User;

import java.util.List;

public interface UserDAO {
    User findById(int id);
    List<User> list();
    void add(User user);
    void delete(int id);
    User get(int id);
    User findByName(String name);
}
