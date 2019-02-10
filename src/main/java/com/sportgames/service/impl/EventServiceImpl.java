package com.sportgames.service.impl;

import com.sportgames.dao.EventDAO;
import com.sportgames.model.SportEvent;
import com.sportgames.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("SportEventService")
public class EventServiceImpl implements EventService {

    private final EventDAO dao;

    @Autowired
    public EventServiceImpl(EventDAO dao) {
        this.dao = dao;
    }

    @Override
    public SportEvent findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<SportEvent> getAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public void add(SportEvent sportEvent) {
        dao.saveAndFlush(sportEvent);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<SportEvent> getByPlayground(String adr) {
        return dao.getAllByPlaygroundAddress(adr);
    }

    @Override
    public List<SportEvent> getByPlaygroundId(Long id) {
        return dao.getAllByPlaygroundId(id);
    }

    @Override
    @Transactional
    public void update(SportEvent sportEvent) {
        dao.saveAndFlush(sportEvent);
    }
}
