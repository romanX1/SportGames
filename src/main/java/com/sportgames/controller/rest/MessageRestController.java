package com.sportgames.controller.rest;

import com.sportgames.model.Message;
import com.sportgames.service.MessageService;
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

//    @RequestMapping(method = RequestMethod.POST, value = "/say")
//    public void say(@RequestBody Message message){
//        messageService.add(message);
//    }
//
//    @GetMapping("/get/{eventId}")
//    public List<Message> getByEvent(@PathVariable Long eventId){
//        return messageService.findBySportEventId(eventId);
//    }

    @MessageMapping("/api/chatique/{eventId}")
    @SendTo("/event/{eventId}")
    public Message send(@DestinationVariable Long eventId, Message message) throws Exception{
        messageService.add(message);
        return message;
    }



}
