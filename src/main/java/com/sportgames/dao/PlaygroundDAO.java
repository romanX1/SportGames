package com.sportgames.dao;

import com.sportgames.model.Playground;

import java.util.List;


public interface PlaygroundDAO {

    Playground findById(int id);
    List<Playground> list();
    void add(Playground playground);
    void delete(int id);
    Playground get(int id);
    Playground findByName(String name);
}
