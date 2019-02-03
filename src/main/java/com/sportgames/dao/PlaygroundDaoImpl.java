package com.sportgames.dao;

import java.util.List;

import com.sportgames.model.Playground;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("ALL")
@Repository("playgroundDAO")
public class PlaygroundDaoImpl implements PlaygroundDAO {

    @PersistenceContext
    private EntityManager em;

    public Playground findById(int id) {
        return em.find(Playground.class, id);
    }

}
