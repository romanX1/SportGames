package com.sportgames.service;

import com.sportgames.model.Playground;
import com.sportgames.model.SportEvent;

import java.util.List;

public interface SportEventService {

    SportEvent findById(Long id);
    List<SportEvent> getAll();
    void add(SportEvent sportEvent);
    List<SportEvent> getByPlayground(String adr);
}
