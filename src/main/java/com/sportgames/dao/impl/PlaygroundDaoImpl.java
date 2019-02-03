package com.sportgames.dao.impl;



import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.model.Playground;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@SuppressWarnings("ALL")
@Repository("PlaygroundDAO")
public class PlaygroundDaoImpl implements PlaygroundDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Playground findById(Long id) {
        return entityManager.find(Playground.class, id);
    }

    @Override
    public List<Playground> getPlaygroundBySportType(String type) {
        return entityManager.createQuery("SELECT play FROM Playground play " +
                "JOIN play.sports AS sport W" +
                "HERE sport.type = :typeName" , Playground.class).setParameter("typeName", type).getResultList();
    }

    @Override
    public List<Playground> getAll() {
        return entityManager.createQuery("SELECT play FROM Playground play  " , Playground.class).getResultList();
    }

    @Override
    public void add(Playground playground) {
        entityManager.persist(playground);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Playground get(Long id) {
        return null;
    }

    @Override
    public Playground findByName(String name) {
        return null;
    }


}
