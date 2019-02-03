package com.sportgames.dao.impl;

import com.sportgames.dao.SportDAO;
import com.sportgames.model.Sport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("SportDAO")
public class SportDAOImpl implements SportDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Sport findById(Long id) {
        return null;
    }

    @Override
    public List<Sport> getAll() {
        return entityManager.createQuery("FROM Sport",Sport.class).getResultList();
    }

    @Override
    public void add(Sport sport) {
        entityManager.persist(sport);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Sport get(Long id) {
        return null;
    }

    @Override
    public Sport findByName(String name) {
        return null;
    }
}
