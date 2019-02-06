package com.sportgames.service;

import com.sportgames.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAll();
    void add(User user);
    User findById(Long id);
    List<User> getUsersByEventTime(String timeEvent);
    String encodePassword (String password);
}