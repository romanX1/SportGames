package com.sportgames.controller.rest;

import com.sportgames.model.User;
import com.sportgames.model.UserRole;
import com.sportgames.service.UserRoleService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;
    private final UserRoleService userRoleService;

    @Autowired
    public UserRestController(UserService userService,
                              UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @GetMapping("/{userName}")
    public boolean checkName(@PathVariable String userName) {
        User user = userService.findByName(userName);
        if(user == null){
            return false;
        }
        return true;
    }




}