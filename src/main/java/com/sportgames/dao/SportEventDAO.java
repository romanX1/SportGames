package com.sportgames.dao;

import com.sportgames.model.SportEvent;
import java.util.List;

public interface SportEventDAO {
    SportEvent findById(int id);
    List<SportEvent> getAll();
    void add(SportEvent sportEvent);
    void delete(int id);
    SportEvent get(int id);
    SportEvent findByName(String name);
}
