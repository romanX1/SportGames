package com.sportgames.controller.rest;

import com.sportgames.model.Sport;
import com.sportgames.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sport")
public class SportRestController {
    @Autowired
    private SportService sportService;

    @GetMapping("/all")
    public List<Sport> getAllSports(){
        return sportService.getAll();
    }
}
