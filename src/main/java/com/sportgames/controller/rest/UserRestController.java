package com.sportgames.controller.rest;

import com.sportgames.model.User;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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