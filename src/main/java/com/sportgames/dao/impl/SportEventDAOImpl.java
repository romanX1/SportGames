package com.sportgames.dao.impl;

import com.sportgames.dao.SportEventDAO;
import com.sportgames.model.SportEvent;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("ALL")
@Repository("SportEventDAO")
public class SportEventDAOImpl implements SportEventDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SportEvent findById(Long id) {
        return null;
    }

    @Override
    public List<SportEvent> getAll() {
        return null;
    }

    @Override
    public void add(SportEvent sportEvent) {
        entityManager.persist(sportEvent);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public SportEvent get(Long id) {
        return null;
    }

    @Override
    public SportEvent findByName(String name) {
        return null;
    }
}
