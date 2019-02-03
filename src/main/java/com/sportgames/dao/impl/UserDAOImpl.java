package com.sportgames.dao.impl;

import com.sportgames.dao.UserDAO;
import com.sportgames.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("ALL")
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return null;
    }
}
