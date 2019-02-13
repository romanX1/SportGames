package com.sportgames.controller.rest;

import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/playgrounds")
public class PlaygroundRestController {

    @Autowired
    private PlaygroundService playgroundService;

    @Autowired
    private SportService sportService;

    @GetMapping("/byId/{sportTypeId}")
    public List<Playground> playgroundsByType(@PathVariable Long sportTypeId){
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
        System.out.println(playground);
        playgroundService.update(playground);
        return true;
    }
}
