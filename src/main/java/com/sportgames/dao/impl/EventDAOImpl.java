package com.sportgames.dao.impl;

import com.sportgames.dao.EventDAO;
import com.sportgames.model.SportEvent;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("SportEventDAO")
public class EventDAOImpl implements EventDAO {

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
    public List<SportEvent> getAllByPlayground(String adr) {
        return entityManager.createQuery("SELECT ev FROM SportEvent ev JOIN ev.playground pg WHERE pg.address LIKE :adr")
                .setParameter("adr", adr).getResultList();
    }

    @Override
    public void add(SportEvent sportEvent) {
        entityManager.persist(sportEvent);
    }
    @Override
    public void update(SportEvent sportEvent) {
        entityManager.merge(sportEvent);
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
