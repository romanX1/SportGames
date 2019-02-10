package com.sportgames.service;

import com.sportgames.model.Playground;
import com.sportgames.model.SportEvent;

import java.util.List;

public interface EventService {

    SportEvent findById(Long id);
    List<SportEvent> getAll();
    void add(SportEvent sportEvent);
    void delete(Long id);
    List<SportEvent> getByPlayground(String adr);
    List<SportEvent> getByPlaygroundId(Long id);
    void update(SportEvent sportEvent);
}
