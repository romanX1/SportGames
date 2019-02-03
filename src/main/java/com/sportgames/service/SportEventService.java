package com.sportgames.service;

import com.sportgames.model.Playground;
import com.sportgames.model.SportEvent;

import java.util.List;

public interface SportEventService {

    List<SportEvent> getAll();
    void add(SportEvent sportEvent);
}
