package com.sportgames.controller.rest;

import com.sportgames.dao.EventDAO;
import com.sportgames.model.Playground;
import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.EventService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    private final UserService userService;
    private final EventService eventService;
    private final PlaygroundService playgroundService;

    @Autowired
    public EventRestController(UserService userService, EventService eventService, PlaygroundService playgroundService) {
        this.userService = userService;
        this.eventService = eventService;
        this.playgroundService = playgroundService;
    }

    @GetMapping("/addevent")
    public List<Playground> getAllPlayground(){
        return playgroundService.getAll();
    }

    @GetMapping("/{eventId}/join")
    public ResponseEntity<User> getAuthentificatedEvent(@PathVariable Long eventId) {

        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SportEvent sportEvent = eventService.findById(eventId);

        if(sportEvent.getUsers().size() < sportEvent.getSport().getMaxPlayers() && !sportEvent.getUsers().contains(authUser)) {
            sportEvent.getUsers().add(authUser);
            eventService.update(sportEvent);
            return ResponseEntity.status(HttpStatus.OK).body(authUser);
        }else{
            return ResponseEntity.badRequest().body(authUser);
        }

    }

    @GetMapping("/{eventId}/del")
    public User delAuthentificatedEvent(@PathVariable Long eventId) {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SportEvent sportEvent = eventService.findById(eventId);
        sportEvent.getUsers().remove(authUser);
        eventService.update(sportEvent);
        return authUser;

    }

    @GetMapping("/{playgroundId}/{sportType}")
    public List<SportEvent> getEventsByPlaygroundAndType(@PathVariable Long playgroundId, @PathVariable String sportType){
        return eventService.getllByPlaygroundIdAndSportType(playgroundId, sportType);
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
