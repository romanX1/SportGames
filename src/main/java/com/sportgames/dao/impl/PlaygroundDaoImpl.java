package com.sportgames.dao.impl;



import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.model.Playground;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("PlaygroundDAO")
public class PlaygroundDaoImpl implements PlaygroundDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Playground findById(int id) {
        return entityManager.find(Playground.class, id);
    }

    @Override
    public List<Playground> getAll() {
        return entityManager.createQuery("SELECT play FROM Playground play " , Playground.class).getResultList();
    }

    @Override
    public void add(Playground playground) {
        entityManager.persist(playground);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Playground get(int id) {
        return null;
    }

    @Override
    public Playground findByName(String name) {
        return null;
    }


}
