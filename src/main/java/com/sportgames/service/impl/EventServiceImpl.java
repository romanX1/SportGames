package com.sportgames.service.impl;

import com.sportgames.dao.EventDAO;
import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import com.sportgames.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.HashMap;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("SportEventService")
public class EventServiceImpl implements EventService {

    private final EventDAO dao;


    @Autowired
    public EventServiceImpl(EventDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<SportEvent> getActualEventsByPG(Long id, LocalDateTime ts, LocalDateTime te) {
        return dao.getActualEventsByPG(id, ts, te);
    }

    @Override
    public List<SportEvent> getAllUpToDate(LocalDateTime date) {
        return dao.getAllUpToDate(date);
    }

    @Override
    public Map.Entry<Sport, Long> getFamousSport() {
        List<Sport> sports = dao.getAllSport();
        Map<Sport, Long> map = sports.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Sport, Long> famousSport = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .findFirst().get();

        return famousSport;
    }

    @Override
    public Map.Entry<Sport, Long> getFamousSportInMonth() {
        LocalDateTime timeStart = LocalDateTime.now().withDayOfMonth(1);
        LocalDateTime timeEnd = LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth());
        List<Sport> sports = dao.getSportInTimes(timeStart, timeEnd);
        Map<Sport, Long> map = sports.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Sport, Long> famousSport = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .findFirst().get();
        return famousSport;
    }

    @Override
    public SportEvent findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<SportEvent> getAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public void add(SportEvent sportEvent) {
        dao.saveAndFlush(sportEvent);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<SportEvent> getByPlayground(String adr) {
        return dao.getAllByPlaygroundAddress(adr);
    }

    @Override
    public List<SportEvent> getByPlaygroundId(Long id) {
        return dao.getAllByPlaygroundId(id);
    }

    @Override
    public List<SportEvent> getByUserId(Long id) {
        return dao.getAllByUsersId(id);
    }

    @Override
    public List<SportEvent> getAllByPlaygroundIdAndSportType(Long id, String type) {
        return dao.getAllByPlaygroundIdAndSportType(id, type);
    }

    @Override
    public SportEvent findFamousSE() {
        List<SportEvent> sportEventList = dao.findAll();
        Map<SportEvent, Long> sportEventLongMap = new HashMap<>();

        for (SportEvent se : sportEventList) {
            sportEventLongMap.put(se, Long.valueOf(se.getUsers().size()));
        }

        SportEvent sportEvent = sportEventLongMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .map(e -> e.getKey())
                .findFirst()
                .get();

        return sportEvent;
    }

    @Override
    public Long countSE() {
        return dao.count();
    }

    @Override
    public Long countSEInMonth() {
        LocalDateTime timeStart = LocalDateTime.now().withDayOfMonth(1);
        LocalDateTime timeEnd = LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth());
        return dao.countSEInTimes(timeStart, timeEnd);
    }


    @Override
    @Transactional
    public void update(SportEvent sportEvent) {
        dao.saveAndFlush(sportEvent);
    }
}
