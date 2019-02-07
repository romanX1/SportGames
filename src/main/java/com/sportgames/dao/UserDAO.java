package com.sportgames.dao;


import com.sportgames.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDAO {
    User findById(Long id);
    List<User> getAll();
    void add(User user);
    void delete(Long id);
    User findByName(String name);
    UserDetails findByLogin(String login);
    List<User> getUsersByEventTime(String time);
    List<User> getUsersByEventId(Long eventId);
}
