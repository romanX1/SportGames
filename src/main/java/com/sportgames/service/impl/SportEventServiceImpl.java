package com.sportgames.service.impl;

import com.sportgames.dao.SportEventDAO;
import com.sportgames.model.SportEvent;
import com.sportgames.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("SportEventService")
public class SportEventServiceImpl implements SportEventService {

    private final SportEventDAO dao;

    @Autowired
    public SportEventServiceImpl(SportEventDAO dao) {
        this.dao = dao;
    }

    @Override
    public SportEvent findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<SportEvent> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public void add(SportEvent sportEvent) {
        dao.add(sportEvent);
    }

    @Override
    public List<SportEvent> getByPlayground(String adr) {
        return dao.getAllByPlayground(adr);
    }
}
