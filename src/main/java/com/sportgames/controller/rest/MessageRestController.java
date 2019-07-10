package com.sportgames.controller.rest;

import com.sportgames.model.Message;
import com.sportgames.model.User;
import com.sportgames.service.MessageService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/chatique")
public class MessageRestController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @MessageMapping("/api/chatique/{eventId}")
    @SendTo("/event/{eventId}")
    public Message send(@DestinationVariable Long eventId, Message message) throws Exception{
        User u=userService.findById(message.getUser().getId());
        message.setUser(u);
        messageService.add(message);
        return message;
    }



}
