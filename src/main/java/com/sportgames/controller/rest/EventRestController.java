package com.sportgames.controller.rest;

import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import com.sportgames.service.SportEventService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    private final UserService userService;
    private final SportEventService eventService;

    @Autowired
    public EventRestController(UserService userService, SportEventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("/{eventId}/users")
    public List<User> getUsersForEvent(@PathVariable Long eventId) {
        return userService.getUsersByEventId(eventId);
    }

    @GetMapping("/{eventId}")
    public SportEvent getEvent(@PathVariable Long eventId) {
        return eventService.findById(eventId);
    }
}
