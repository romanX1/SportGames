package com.sportgames.dao.impl;

import com.sportgames.dao.UserRoleDAO;
import com.sportgames.model.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("ALL")
@Repository("UserRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(UserRole userRole) {
        entityManager.persist(userRole);
    }

    @Override
    public void delete(UserRole userRole) {
        entityManager.remove(userRole);
    }

    @Override
    public UserRole findByAuthority(String authority) {
        return entityManager
                .createQuery("SELECT r FROM UserRole As r WHERE r.authority = :param", UserRole.class)
                .setParameter("param", authority)
                .getSingleResult();
    }

    @Override
    public List<UserRole> gelAll() {
        return entityManager.createQuery("SELECT u FROM UserRole u" , UserRole.class).getResultList();
    }
}
