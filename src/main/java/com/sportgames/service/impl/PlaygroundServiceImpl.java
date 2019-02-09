package com.sportgames.service.impl;

import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.model.Playground;
import com.sportgames.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PlaygroundService")
@Transactional
public class PlaygroundServiceImpl implements PlaygroundService {

    private final PlaygroundDAO dao;

    @Autowired
    public PlaygroundServiceImpl(PlaygroundDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Playground> getPlaygroundBySportType(String type) {
        return dao.getPlaygroundBySportType(type);
    }

    @Override
    public List<Playground> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(Playground playground) {
        dao.add(playground);
    }

    @Override
    public Playground findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Playground> getPlaygroundBySportType(Long sportTypeId) {
        return dao.getPlaygroundBySportType(sportTypeId);
    }

    @Override
    public void update(Playground playground) {
        dao.update(playground);
    }

    @Override
    public Playground findByName(String name) {
        return dao.findByName(name);
    }
}
