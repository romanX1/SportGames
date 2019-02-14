package com.sportgames.controller.rest;

import com.sportgames.model.Message;
import com.sportgames.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @MessageMapping("/api/chatique")
    @SendTo("/event/34")
    public Message send(Message message) throws Exception{
        System.out.println("Got message");
        messageService.add(message);
        String time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMMM yyyy@HH:mm:ss"));
        return new Message(message.getUser(), message.getSportEvent(), message.getText(), LocalDateTime.now());
    }



}
