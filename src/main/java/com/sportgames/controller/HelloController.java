package com.sportgames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {


    @GetMapping("/")
    public String userPage(){
        return "user";
    }



}