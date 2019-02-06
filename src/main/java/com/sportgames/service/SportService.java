package com.sportgames.service;

import com.sportgames.model.Sport;

import java.util.List;

public interface SportService {

    List<Sport> getAll();
    void add(Sport sport);
    Sport findById(long id);
}
