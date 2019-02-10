package com.sportgames.service;

import com.sportgames.model.Sport;

import java.util.List;
import java.util.Set;

public interface SportService {

    List<Sport> getAll();
    void add(Sport sport);
    Sport findById(Long id);
}
