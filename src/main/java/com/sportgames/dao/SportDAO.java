package com.sportgames.dao;

import com.sportgames.model.Sport;

import java.util.List;

public interface SportDAO {
    Sport findById(int id);
    List<Sport> getAll();
    void add(Sport sport);
    void delete(int id);
    Sport get(int id);
    Sport findByName(String name);
}
