package com.sportgames.service.impl;

import com.sportgames.dao.SportEventDAO;
import com.sportgames.model.SportEvent;
import com.sportgames.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("SportEventService")
@Transactional
public class SportEventServiceImpl implements SportEventService {

    @Autowired
    private SportEventDAO dao;

    @Override
    public List<SportEvent> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(SportEvent sportEvent) {
        dao.add(sportEvent);
    }
}
