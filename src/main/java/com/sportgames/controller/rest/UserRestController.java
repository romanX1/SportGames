package com.sportgames.controller.rest;

import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import com.sportgames.service.SportEventService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName) {
        return null;
    }
}