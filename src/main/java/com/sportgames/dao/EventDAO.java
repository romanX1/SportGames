package com.sportgames.dao;

import com.sportgames.model.SportEvent;
import java.util.List;

public interface EventDAO {
    SportEvent findById(Long id);
    List<SportEvent> getAll();
    List<SportEvent> getAllByPlayground(String adr);
    void add(SportEvent sportEvent);
    void update(SportEvent sportEvent);
    void delete(Long id);
    SportEvent findByName(String name);
}