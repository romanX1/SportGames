package com.sportgames.dao.impl;

import com.sportgames.dao.SportDAO;
import com.sportgames.model.Sport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("ALL")
@Repository("SportDAO")
public class SportDAOImpl implements SportDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Sport findById(Long id) {
        return entityManager.find(Sport.class, id);
    }

    @Override
    public List<Sport> getAll() {
        return entityManager.createQuery("SELECT s FROM Sport s  " , Sport.class).getResultList();
    }

    @Override
    public void add(Sport sport) {
        entityManager.persist(sport);
    }

    @Override
    public void delete(Long id) {
        Sport sport = entityManager.find(Sport.class, id);
        entityManager.remove(sport);
    }



    @Override
    public Sport findByName(String name) {
        return entityManager.find(Sport.class, name);
    }
}
