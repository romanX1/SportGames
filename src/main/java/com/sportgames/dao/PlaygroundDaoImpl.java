package com.sportgames.dao;



import com.sportgames.model.Playground;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("ALL")
@Repository("playgroundDAO")
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
