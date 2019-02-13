package com.sportgames.dao;

import com.sportgames.model.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository("eventDAO")
public interface EventDAO extends JpaRepository<SportEvent, Long>{
    List<SportEvent> getAllByPlaygroundAddress(String adr);
    List<SportEvent> getAllByPlaygroundId(Long id);
    List<SportEvent> getAllByPlaygroundIdAndSportType(Long id, String type);
    @Query(value = "SELECT event FROM SportEvent event " +
            "WHERE event.timeStart > :date")
    List<SportEvent> getAllUpToDate(@Param("date") LocalDateTime date);

}
