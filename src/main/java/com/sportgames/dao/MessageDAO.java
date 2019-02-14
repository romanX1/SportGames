package com.sportgames.dao;

import com.sportgames.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDAO extends JpaRepository<Message, Long> {
    public List<Message> getAllBySportEventId(Long id);
}
