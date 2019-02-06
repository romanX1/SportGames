package com.sportgames.controller.rest;

import com.sportgames.model.User;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

//    @RequestMapping(value = "/outdoorpanel", method = RequestMethod.GET)
//    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//        System.out.println("Updating User " + id);
//
//        User currentUser = userService.findById(id);
//
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }
}
