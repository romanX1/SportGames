package com.sportgames.service.impl;

import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.model.Playground;
import com.sportgames.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("PlaygroundService")
@Transactional
public class PlaygroundServiceImpl implements PlaygroundService {

    private final PlaygroundDAO dao;

    @Autowired
    public PlaygroundServiceImpl(PlaygroundDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Playground> getPlaygroundBySportType(String type) {
        return dao.getPlaygroundsByType(type);
    }

    @Override
    public List<Playground> getAll() {
        return dao.findAll();
    }

    @Override
    public void add(Playground playground) {
        dao.saveAndFlush(playground);
    }

    @Override
    public Playground findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<Playground> getPlaygroundBySportType(Long sportTypeId) {
        return dao.getPlaygroundsByType(sportTypeId);
    }

    @Override
    public void update(Playground playground) {
        dao.saveAndFlush(playground);
    }

    @Override
    public Playground findFamousPlayground() {
        List<Long> idPlayground = dao.getAllPlaygroundIdFromEvents();
        Map<Long, Long> map = idPlayground.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Long id = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .map(e -> e.getKey())
                .findFirst().get();
        return findById(id);
    }

    @Override
    public Long countPG() {
        return dao.count();
    }


    @Override
    public Playground findByName(String name) {
        return dao.findByAddress(name);
    }
}
