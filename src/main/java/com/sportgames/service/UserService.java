package com.sportgames.service;

import com.sportgames.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAll();
    void add(User user);
    User findById(Long id);
    User findByName(String name);
    List<User> getUsersByEventTime(String timeEvent);
    String encodePassword (String password);
    List<User> getUsersByEventId(Long eventId);
    Map.Entry<User, Long> findFamousUser();

    Long countUsers();
}