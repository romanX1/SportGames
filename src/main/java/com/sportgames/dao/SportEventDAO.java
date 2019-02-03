package com.sportgames.dao;

import com.sportgames.model.SportEvent;
import java.util.List;

public interface SportEventDAO {
    SportEvent findById(Long id);
    List<SportEvent> getAll();
    void add(SportEvent sportEvent);
    void delete(Long id);
    SportEvent findByName(String name);
}
