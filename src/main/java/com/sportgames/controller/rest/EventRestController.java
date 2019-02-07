package com.sportgames.controller.rest;

import com.sportgames.model.Playground;
import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.SportEventService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final PlaygroundService playgroundService;

    @Autowired
    public EventRestController(UserService userService, SportEventService eventService, PlaygroundService playgroundService) {
        this.userService = userService;
        this.eventService = eventService;
        this.playgroundService = playgroundService;
    }

    @GetMapping("/addevent")
    public List<Playground> getAllPlayground(){
        return playgroundService.getAll();
    }

    @GetMapping("/{eventId}/join")
    public User getAuthentificatedEvent(@PathVariable Long eventId) {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SportEvent sportEvent = eventService.findById(eventId);
        sportEvent.getUsers().add(authUser);
        eventService.update(sportEvent);
        return authUser;
    }

    @GetMapping("/{eventId}/users")
    public List<User> getUsersForEvent(@PathVariable Long eventId) {
        return userService.getUsersByEventId(eventId);
    }

    @GetMapping("/{eventId}")
    public SportEvent getEvent(@PathVariable Long eventId) {
        return eventService.findById(eventId);
    }

    @GetMapping("/")
    public List<SportEvent> getAllEvent() {
        return eventService.getAll();
    }
}
