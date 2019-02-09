package com.sportgames.service.impl;

import com.sportgames.dao.SportDAO;;
import com.sportgames.model.Sport;
import com.sportgames.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("SportService")
@Transactional
public class SportServiceImpl implements SportService {

    @Autowired
    private SportDAO dao;

    @Override
    public List<Sport> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(Sport sport) {
        dao.add(sport);
    }

    @Override
    public Sport findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Set<Sport> findById(Long[] id) {
        return dao.findById(id);
    }
}
