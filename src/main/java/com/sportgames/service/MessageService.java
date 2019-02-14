package com.sportgames.service;

import com.sportgames.model.Message;

import java.util.List;

public interface MessageService {
    void add(Message message);
    List<Message> findAll();
    List<Message> findBySportEventId(Long id);
}
