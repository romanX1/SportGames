package com.sportgames.service;

import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.model.Playground;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("playgroundService")
@Transactional
public class PlaygroundServiceImpl implements PlaygroundService {

    @Autowired
    private PlaygroundDAO dao;

    @Override
    public List<Playground> getAll() {
        return dao.getAll();
    }
}
