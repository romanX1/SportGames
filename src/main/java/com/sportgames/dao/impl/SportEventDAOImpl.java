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
        return entityManager.find(SportEvent.class, id);
    }

    @Override
    public List<SportEvent> getAll() {
        return entityManager.createQuery("SELECT se FROM SportEvent se  " , SportEvent.class).getResultList();
    }

    @Override
    public void add(SportEvent sportEvent) {
        entityManager.persist(sportEvent);
    }

    @Override
    public void delete(Long id) {
        SportEvent sportEvent = entityManager.find(SportEvent.class, id);
        entityManager.remove(sportEvent);
    }

    @Override
    public SportEvent findByName(String name) {
        return entityManager.find(SportEvent.class, name);
    }
}
