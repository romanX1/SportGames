package com.sportgames.service;

import com.sportgames.model.Playground;

import java.util.List;

public interface PlaygroundService {

    List<Playground> getPlaygroundBySportType(String type);
    List<Playground> getAll();
    void add(Playground playground);

    Playground get(Long id);
}
