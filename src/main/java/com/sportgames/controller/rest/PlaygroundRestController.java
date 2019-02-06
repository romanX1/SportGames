package com.sportgames.controller.rest;

import com.sportgames.model.Playground;
import com.sportgames.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/playgrounds")
public class PlaygroundRestController {

    @Autowired
    private PlaygroundService playgroundService;

    @GetMapping("/by/{sportTypeId}")
    public List<Playground> playgroundsByType(@PathVariable Long sportTypeId){
        List<Playground> playgrounds = playgroundService.getPlaygroundBySportType(sportTypeId);
        return playgrounds;
    }

    @GetMapping("/")
    public List<Playground> playgrounds(){
        List<Playground> playgrounds = playgroundService.getAll();
        return playgrounds;
    }
}
