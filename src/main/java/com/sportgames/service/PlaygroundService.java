package com.sportgames.service;

import com.sportgames.model.Playground;

import java.util.List;

public interface PlaygroundService {

    List<Playground> getAll();
    void add(Playground playground);
}
