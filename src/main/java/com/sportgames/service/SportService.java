package com.sportgames.service;

import com.sportgames.model.Playground;
import com.sportgames.model.Sport;

import java.util.List;

public interface SportService {

    List<Sport> getAll();
    void add(Sport sport);
}
