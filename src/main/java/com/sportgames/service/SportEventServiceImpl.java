package com.sportgames.service;

import com.sportgames.dao.SportEventDAO;
import com.sportgames.model.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SportEventService")
@Transactional
public class SportEventServiceImpl implements SportEventService {

    @Autowired
    private SportEventDAO dao;

    @Override
    public void add(SportEvent sportEvent) {
        dao.add(sportEvent);
    }
}
