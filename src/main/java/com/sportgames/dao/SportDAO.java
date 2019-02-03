package com.sportgames.dao;

import com.sportgames.model.Sport;

import java.util.List;

public interface SportDAO {
    Sport findById(Long id);
    List<Sport> getAll();
    void add(Sport sport);
    void delete(Long id);
    Sport get(Long id);
    Sport findByName(String name);
}
