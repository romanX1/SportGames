package com.sportgames.dao;

import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
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

    @Query(value = "SELECT ev FROM SportEvent ev " +
            "JOIN ev.users AS user W" +
            "HERE user.id = :id")
    List<SportEvent> getAllByUsersId(@Param("id")Long id);


    List<SportEvent> getAllByPlaygroundIdAndSportType(Long id, String type);

    @Query(value = "SELECT event FROM SportEvent event " +
            "WHERE event.timeStart > :date")
    List<SportEvent> getAllUpToDate(@Param("date") LocalDateTime date);

    @Query(value = "SELECT play.sport FROM SportEvent play")
    List<Sport> getAllSport();

    @Query(value = "SELECT play.sport FROM SportEvent play ")
    List<Sport> getSportInMonth();

}
