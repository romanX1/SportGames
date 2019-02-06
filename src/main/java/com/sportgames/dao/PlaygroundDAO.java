package com.sportgames.dao;

import com.sportgames.model.Playground;

import java.util.List;


public interface PlaygroundDAO {

    Playground findById(Long id);
    List<Playground> getAll();
    List<Playground> getPlaygroundBySportType(String type);
    void add(Playground playground);
    void delete(Long id);
    Playground findByName(String name);

    List<Playground> getPlaygroundBySportType(Long sportTypeId);
}
