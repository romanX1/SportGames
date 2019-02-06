package com.sportgames.dao.impl;

import com.sportgames.dao.UserDAO;
import com.sportgames.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u  " , User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }


    @Override
    public User findByName(String name) {
        return entityManager
                .createQuery("SELECT r FROM User As r WHERE r.name = :param", User.class)
                .setParameter("param", name)
                .getSingleResult();
    }

    @Override
    public User findByLogin(String login) {
        return entityManager
                //.createQuery("SELECT u FROM User u JOIN u.login AS login WHERE u.login = :typeName" , User.class)
                .createQuery("SELECT r FROM User As r WHERE r.login = :param", User.class)
                .setParameter("param", login)
                .getSingleResult();
    }

    @Override
    public List<User> getUsersByEventTime(String time) {
        return entityManager.createQuery("SELECT u FROM User u " +
                "JOIN u.time AS time " +
                "WHERE u.time = :typeName" , User.class).setParameter("time", time).getResultList();
    }

    @Override
    public List<User> getUsersByEventId(Long eventId) {
        return entityManager
                .createQuery("SELECT users FROM SportEvent as event " +
                        "JOIN event.users as users " +
                        "WHERE event.id = :eventId", User.class)
                .setParameter("eventId", eventId )
                .getResultList();
    }
}
