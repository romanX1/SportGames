package com.sportgames.service.impl;

import com.sportgames.dao.MessageDAO;
import com.sportgames.model.Message;
import com.sportgames.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("MessageService")
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDAO dao;

    @Override
    public void add(Message message) {
        dao.save(message);
    }

    @Override
    public List<Message> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Message> findBySportEventId(Long id){ return dao.getAllBySportEventId(id);}
}
