package com.sportgames.controller.rest;

import com.sportgames.model.Point;
import com.sportgames.model.User;
import com.sportgames.model.UserRole;
import com.sportgames.service.UserRoleService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/point")
    public String getgeo(HttpServletRequest req){
        String ip=req.getRemoteAddr();
        ip+="\n"+req.getLocalAddr();
        ip+="\n"+req.getRemoteHost();
        ip+="\n"+req.getRequestURI();
        return ip+"hui";
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