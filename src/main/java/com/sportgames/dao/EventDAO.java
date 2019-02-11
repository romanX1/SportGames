package com.sportgames.dao;

import com.sportgames.model.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("eventDAO")
public interface EventDAO extends JpaRepository<SportEvent, Long>{
    List<SportEvent> getAllByPlaygroundAddress(String adr);
    List<SportEvent> getAllByPlaygroundId(Long id);
    List<SportEvent> getAllByPlaygroundIdAndSportType(Long id, String type);
}
