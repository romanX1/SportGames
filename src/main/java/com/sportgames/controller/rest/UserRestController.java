package com.sportgames.controller.rest;

import com.sportgames.model.User;
import com.sportgames.service.SportEventService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserRestController {

//    @Autowired
//    SportEventService sportEventService;
//
//    @RequestMapping(value="/outdoorpanel", method = RequestMethod.GET)
//    public ResponseEntity<User> updateUser(@PathVariable("type") String type) {
//
//
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }
}
