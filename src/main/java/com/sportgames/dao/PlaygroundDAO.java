package com.sportgames.dao;

import com.sportgames.model.Playground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PlaygroundDAO  extends JpaRepository<Playground, Long> {

    @Query(value = "SELECT play FROM Playground play " +
            "JOIN play.sports AS sport W" +
            "HERE sport.type = :type")
    List<Playground> getPlaygroundsByType(@Param("type") String type);

    Playground findByAddress(String address);

    @Query(value = "SELECT play FROM Playground play " +
            "JOIN play.sports AS sport W" +
            "HERE sport.id = :id")
    List<Playground> getPlaygroundsByType(@Param("id")Long id);


    @Query(value = "SELECT play.playground.id FROM SportEvent play")
    List<Long> getAllPlaygroundIdFromEvents();
}
