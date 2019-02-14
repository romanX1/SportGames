package com.sportgames.controller.rest;

import com.sportgames.model.Playground;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adminplaygrounds")
public class AdminPlaygroundRestController {

    @Autowired
    private PlaygroundService playgroundService;

    @Autowired
    private SportService sportService;

    @GetMapping("/byId/{sportTypeId}")
    public List<Playground> adminPlaygroundsByType(@PathVariable Long sportTypeId){
        List<Playground> playgrounds = playgroundService.getPlaygroundBySportType(sportTypeId);
        return playgrounds;
    }

    @GetMapping("/")
    public List<Playground> playgrounds(){
        List<Playground> playgrounds = playgroundService.getAll();
        return playgrounds;
    }

    @RequestMapping(method = RequestMethod.POST, value="/supply")
    public Boolean supplyPG(@RequestBody Playground playground){
        playgroundService.update(playground);
        return true;
    }

}
