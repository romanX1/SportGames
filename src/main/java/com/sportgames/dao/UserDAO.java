package com.sportgames.dao;


import com.sportgames.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userDAO")
public interface UserDAO extends JpaRepository<User, Long> {

    User findUserById(Long id);
    User findByLogin(String login);
    List<User> findAll();
    List<User> getUsersById(Long sportEventId);
}