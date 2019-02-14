package com.sportgames.service;

import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface EventService {

    SportEvent findById(Long id);

    List<SportEvent> getAll();

    void add(SportEvent sportEvent);

    void delete(Long id);

    List<SportEvent> getByPlayground(String adr);

    List<SportEvent> getByPlaygroundId(Long id);

    public List<SportEvent> getActualEventsByPG(Long id, LocalDateTime ts, LocalDateTime te);

    List<SportEvent> getByUserId(Long id);

    void update(SportEvent sportEvent);

    List<SportEvent> getAllByPlaygroundIdAndSportType(Long id, String type);

    SportEvent findFamousSE();

    Long countSE();

    List<SportEvent> getAllUpToDate(LocalDateTime date);

    Map.Entry<Sport, Long> getFamousSport();


}
