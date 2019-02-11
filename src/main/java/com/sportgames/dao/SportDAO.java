package com.sportgames.dao;

import com.sportgames.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportDAO extends JpaRepository<Sport, Long> {

    Sport findById(Long id);
    List<Sport> findAll();
    Sport findByType(String type);

}
